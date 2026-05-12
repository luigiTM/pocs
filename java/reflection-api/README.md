# Reflection API PoC

Demonstrates Java reflection through tests that inspect and manipulate classes
at runtime.

## What It Shows

- Reading class names, packages, superclasses, and implemented interfaces.
- Inspecting modifiers, constructors, fields, and methods.
- Instantiating objects dynamically through constructors.
- Reading and writing field values through reflection.
- Distinguishing public members from declared members.

## Key Files

- `src/main/java/com/lughtech/reflection/model`
- `src/main/java/com/lughtech/reflection/actions`
- `src/test/java/com/lughtech/reflection/model/PersonReflectionTest.java`
- `src/test/java/com/lughtech/reflection/utils/Utils.java`

## Run

```bash
./gradlew test
```
