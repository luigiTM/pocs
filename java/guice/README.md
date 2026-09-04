# Google Guice PoCs

Standalone Gradle projects that explore dependency injection with
[Google Guice](https://github.com/google/guice).

| PoC | Focus | Run from the repository root |
| --- | --- | --- |
| [message-sender](message-sender) | Console application with map bindings for email, SMS, and WhatsApp senders. | `cd java/guice/message-sender && ./gradlew run` |
| [message-sender-web](message-sender-web) | Jetty HTTP service that routes messages to Guice-managed senders. | `cd java/guice/message-sender-web && ./gradlew run` |

Run a project's tests with `./gradlew test` from that project's directory. Both
projects use demonstration clients only; no provider credentials or real message
delivery are required.
