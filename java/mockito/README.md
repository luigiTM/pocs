# Mockito

Proof of concept for Mockito usage with JUnit Jupiter.

## What It Covers

- Creating mocks manually and with Mockito annotations.
- Stubbing return values.
- Argument matchers.
- Spies.
- Verifying interactions.
- Argument captors.
- Exception stubbing.
- Ordered verification.
- Static method mocking.

The examples use a small order service fixture with an `OrderRepository` and
`NotificationService`.

## Commands

Run the tests:

```bash
./gradlew test
```

Build the project:

```bash
./gradlew build
```

## Dependencies

- JUnit Jupiter for tests.
- Mockito core and Mockito's JUnit Jupiter extension.
