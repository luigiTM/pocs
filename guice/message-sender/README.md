# Message Sender

A small Java proof of concept demonstrating dependency injection with [Google Guice](https://github.com/google/guice). It sends messages through interchangeable email, SMS, and WhatsApp sender implementations.

## How it works

Guice modules register client and sender implementations. `MessageService` selects the appropriate sender from a map based on `MessageType`:

- `EMAIL` uses an SMTP email client.
- `SMS` uses a Twilio client.
- `WHATSAPP` uses a Twilio client.

The sample application in `Application.java` sends one message for each channel. The clients are demonstration implementations; they do not configure or make real external requests.

## Requirements

- A Java Development Kit (JDK)

## Run

```bash
./gradlew run
```

## Test

```bash
./gradlew test
```
