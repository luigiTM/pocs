# Java PoCs

A collection of standalone Java proof-of-concept projects. Each directory is an
independent Gradle project with its own wrapper.

## Projects

| PoC | Focus | How to verify |
| --- | --- | --- |
| [anotations](anotations) | Custom validation annotations and reflection-based validation. | `cd java/anotations && ./gradlew test` |
| [callable-and-future](callable-and-future) | Running multiple API tasks concurrently with `Callable` and `Future`. | `cd java/callable-and-future && ./gradlew test` |
| [executor-service](executor-service) | Worker pool built with `ExecutorService`, workers, and a blocking queue. | `cd java/executor-service && ./gradlew test` |
| [functional-interfaces](functional-interfaces) | JDK functional interfaces and primitive specializations. | `cd java/functional-interfaces && ./gradlew test` |
| [java-time-and-joda-time](java-time-and-joda-time) | Creation, conversion, manipulation, duration, and period examples for `java.time` and Joda-Time. | `cd java/java-time-and-joda-time && ./gradlew test` |
| [jdk-features/http-client](jdk-features/http-client) | Java `HttpClient` CRUD-style calls against JSONPlaceholder with Jackson JSON mapping. | `cd java/jdk-features/http-client && ./gradlew build` |
| [jdk-features/switch-expressions](jdk-features/switch-expressions) | Arithmetic calculator implemented with Java switch expressions. | `cd java/jdk-features/switch-expressions && ./gradlew test` |
| [junit5](junit5) | JUnit Jupiter examples for core annotations, assertions, assumptions, lifecycle, and test variants. | `cd java/junit5 && ./gradlew test` |
| [locks-and-atomic-variables](locks-and-atomic-variables) | Account transfers using locks plus atomic counters for metrics. | `cd java/locks-and-atomic-variables && ./gradlew test` |
| [mockito](mockito) | Mockito basics and advanced examples using an order service test fixture. | `cd java/mockito && ./gradlew test` |
| [properties-api](properties-api) | Java `.properties` and XML properties loading, reading, updating, and removal. | `cd java/properties-api && ./gradlew test` |
| [reflection-api](reflection-api) | Reflection over classes, constructors, fields, methods, modifiers, and interfaces. | `cd java/reflection-api && ./gradlew test` |
| [streams](streams) | Stream API examples for matching, reducing, counting, collecting, finding, and mapping. | `cd java/streams && ./gradlew test` |

## Requirements

- JDK installed locally.
- No global Gradle installation is required because each project includes
  `gradlew`.

## Common Commands

Run the tests for a PoC:

```bash
cd java/<poc-directory>
./gradlew test
```

Compile a PoC:

```bash
cd java/<poc-directory>
./gradlew build
```

Some projects include a `Main` class that can be launched from an IDE or another
Java runner after compilation.

## Notes

- The `junit5` project includes an explicit `fail("This test should fail")`
  example in `AssertionsTest`, so the full test suite currently demonstrates a
  failing test result by design.
- The `jdk-features/http-client` project calls
  `https://jsonplaceholder.typicode.com`, so running its `Main` class requires
  network access.
