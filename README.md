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
| [Locks and Atomic Variables](java/locks-and-atomic-variables) | Concurrent bank transfers using explicit locks and atomic metrics. |
| [Properties API](java/properties-api) | Reading and updating regular and XML Java properties files. |
| [Reflection API](java/reflection-api) | Runtime class, field, constructor, method, and modifier inspection with reflection. |
| [Streams](java/streams) | Java Stream API operations including matching, reducing, filtering, collecting, and mapping. |

See [java/README.md](java/README.md) for Java-specific setup and commands.
