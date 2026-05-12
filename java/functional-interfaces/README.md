# Functional Interfaces PoC

Demonstrates common Java functional interfaces through focused JUnit examples.

## What It Shows

- `Function` and primitive variants such as `IntFunction`, `LongFunction`, and
  `DoubleFunction`.
- Conversion interfaces such as `ToIntFunction`, `ToLongFunction`, and
  `ToDoubleFunction`.
- `BiFunction`.
- `Predicate`, `Consumer`, `Supplier`, and operator interfaces.
- Lambda expressions and method references.

## Key Files

- `src/test/java/com/lughtech/functionaInterfaces/function/FunctionTest.java`
- `src/test/java/com/lughtech/functionaInterfaces/function/PredicateTest.java`
- `src/test/java/com/lughtech/functionaInterfaces/function/ConsumerTest.java`
- `src/test/java/com/lughtech/functionaInterfaces/function/SupplierTest.java`
- `src/test/java/com/lughtech/functionaInterfaces/function/OperatorTest.java`

## Run

```bash
./gradlew test
```
