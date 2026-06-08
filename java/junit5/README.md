# JUnit 5

Proof of concept for JUnit Jupiter testing features.

## What It Covers

- Basic annotations, display names, tags, and disabled tests.
- Assertions, grouped assertions, and reference checks.
- Assumptions and conditional execution.
- Exception assertions.
- Test lifecycle callbacks.
- Nested tests.
- Dynamic tests.
- Parameterized tests backed by inline values and CSV resources.
- Repeated tests.
- Timeout assertions.

## Commands

Run the tests:

```bash
./gradlew test
```

Build the project:

```bash
./gradlew build
```

## Notes

`AssertionsTest` includes an explicit `fail("This test should fail")` example.
Because of that demonstration, the full `./gradlew test` command currently
reports a failing test.
