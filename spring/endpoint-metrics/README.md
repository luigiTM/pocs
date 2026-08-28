# Endpoint Metrics

A small Spring Boot application that demonstrates using Spring AOP to log the execution time of controller endpoints. It exposes a simple user API backed by an in-memory H2 database.

## What it demonstrates

- An `@Around` aspect that intercepts controller methods.
- Entry and exit logs with the method name and elapsed time.
- A warning when an endpoint takes more than 2,500 ms.
- Spring Data JPA persistence with H2.

The `GET /api/users/{id}` endpoint deliberately waits for 2.5 seconds before loading the user, making it useful for observing the timing logs and slow-request warning.

## Requirements

- JDK 25 (the Gradle build uses a Java 25 toolchain)

The Gradle wrapper is included, so a separate Gradle installation is not required.

## Run locally

On macOS/Linux:

```bash
./gradlew bootRun
```

On Windows:

```bat
gradlew.bat bootRun
```

The application starts on `http://localhost:8080`.

There are currently no automated tests. Once tests are added, run them with `./gradlew test`.

## API

### Create a user

```bash
curl -X POST http://localhost:8080/api/users \
  -H 'Content-Type: application/json' \
  -d '{"name":"Ada Lovelace","email":"ada@example.com"}'
```

Example response:

```json
{
  "id": 1,
  "name": "Ada Lovelace",
  "email": "ada@example.com"
}
```

### Get a user

```bash
curl http://localhost:8080/api/users/1
```

This request has an intentional delay of roughly 2.5 seconds.

## Metrics logs

`LoggingAspect` applies to methods in classes whose names end in `Controller` under `com.lughtech.endpoint_metrics`. It records both successful and failed requests. Each request produces logs similar to:

```text
Entering: UserController.getUser(..)
Exiting: UserController.getUser(..) executed in 2504ms
Method UserController.getUser(..) execution time is greater than or equal to 2500ms
```

Failed requests also emit an error log before their elapsed time is recorded.

## Database and H2 console

The app uses the in-memory database `jdbc:h2:mem:metrics`; its contents are reset when the application stops. SQL logging is enabled.

While the application is running, open the H2 console at `http://localhost:8080/h2-console` and connect with:

| Setting | Value |
| --- | --- |
| JDBC URL | `jdbc:h2:mem:metrics` |
| User Name | `sa` |
| Password | *(leave blank)* |

## Bruno collection

Import [`bruno-collection/aop-metrics`](bruno-collection/aop-metrics) into [Bruno](https://www.usebruno.com/) to run the included **Create user** and **Get user** requests.
