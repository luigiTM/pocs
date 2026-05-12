# Annotations PoC

Demonstrates how to create custom Java annotations and use reflection to
validate object fields at runtime.

## What It Shows

- Custom annotations: `@NotNull`, `@MinLength`, and `@Email`.
- Reflection-based field inspection with `Field#setAccessible`.
- A reusable `ObjectValidator` that returns a structured `ValidationResult`.
- A simple `User` model annotated with validation constraints.

## Key Files

- `src/main/java/com/lughtech/validator/annotations`
- `src/main/java/com/lughtech/validator/validators/ObjectValidator.java`
- `src/main/java/com/lughtech/validator/model/User.java`
- `src/main/java/com/lughtech/validator/Main.java`

## Run

```bash
./gradlew test
```

The `Main` class can also be launched from an IDE to validate a sample `User`
instance and print the validation result.
