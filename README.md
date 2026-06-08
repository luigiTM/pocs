# PoCs

A collection of proof-of-concept projects used to explore language features,
APIs, and implementation patterns.

## Implemented PoCs

### Java

The Java folder contains standalone Gradle projects, each focused on a specific
topic:

| PoC | Description |
| --- | --- |
| [Annotations](java/anotations) | Custom annotations with reflection-based object validation. |
| [Callable and Future](java/callable-and-future) | Concurrent API aggregation with `Callable`, `Future`, and `ExecutorService`. |
| [Executor Service](java/executor-service) | Worker-pool implementation backed by a fixed thread pool and a shared task queue. |
| [Functional Interfaces](java/functional-interfaces) | Examples of Java functional interfaces such as `Function`, `Predicate`, `Consumer`, `Supplier`, and operators. |
| [HTTP Client](java/jdk-features/http-client) | Java `HttpClient` examples for GET, POST, PUT, and DELETE requests with JSON mapping. |
| [Java Time and Joda-Time](java/java-time-and-joda-time) | Date and time examples comparing `java.time` and Joda-Time APIs. |
| [JUnit 5](java/junit5) | JUnit Jupiter examples covering assertions, assumptions, lifecycle, nested, dynamic, repeated, parameterized, exception, and timeout tests. |
| [Locks and Atomic Variables](java/locks-and-atomic-variables) | Concurrent bank transfers using explicit locks and atomic metrics. |
| [Mockito](java/mockito) | Mockito examples for mocks, stubs, matchers, spies, captors, ordered verification, exceptions, and static mocking. |
| [Properties API](java/properties-api) | Reading and updating regular and XML Java properties files. |
| [Reflection API](java/reflection-api) | Runtime class, field, constructor, method, and modifier inspection with reflection. |
| [Streams](java/streams) | Java Stream API operations including matching, reducing, filtering, collecting, and mapping. |
| [Switch Expressions](java/jdk-features/switch-expressions) | Calculator example using Java switch expressions. |

See [java/README.md](java/README.md) for Java-specific setup and commands.
