# Message Sender Web

A small Java HTTP service that demonstrates dependency injection with [Google Guice](https://github.com/google/guice). It accepts a message over HTTP and routes it to an interchangeable email, SMS, or WhatsApp sender.

The included clients are demonstration implementations: they log delivery attempts and do **not** send real messages or require provider credentials.

## Stack

- Java and Gradle
- Jetty 12
- Google Guice 7
- Jackson

## Run locally

This project uses Java records, so use JDK 17 or later.

```bash
./gradlew run
```

The service starts on `http://localhost:8080` and remains running until interrupted.

## Send a message

`POST /messages` accepts a JSON body with `subject`, `content`, `recipient`, and `messageType`.

```bash
curl --request POST http://localhost:8080/messages \
  --header 'Content-Type: application/json' \
  --data '{
    "subject": "Welcome",
    "content": "Thanks for signing up!",
    "recipient": {
      "email": "ada@example.com",
      "phoneNumber": "+15551234567"
    },
    "messageType": "EMAIL"
  }'
```

A successful request returns:

```json
{
  "message": "Message sent successfully"
}
```

Supported `messageType` values are:

| Type | Sender | Recipient field used |
| --- | --- | --- |
| `EMAIL` | SMTP demonstration client | `recipient.email` |
| `SMS` | Twilio demonstration client | `recipient.phoneNumber` |
| `WHATSAPP` | Twilio demonstration client | `recipient.phoneNumber` |

For example, change `messageType` to `SMS` or `WHATSAPP` in the request above to exercise those routes. Check the application logs to see the simulated delivery attempt.

## How routing works

Guice assembles the application from two modules:

- `ClientModule` binds the email, SMS, and WhatsApp client interfaces to their concrete implementations.
- `SenderModule` uses Guice's `MapBinder` to associate each `MessageType` with a `MessageSender`.

`MessageController` deserializes the request and delegates it to `MessageService`. The service obtains the matching sender from `MessageSenderFactory`, which invokes the configured client.
