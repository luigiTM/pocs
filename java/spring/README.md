# Spring PoCs

Standalone Gradle projects that explore Spring Framework and Spring Boot.

| PoC | Focus | Run from the repository root |
| --- | --- | --- |
| [endpoint-metrics](endpoint-metrics) | Spring Boot user API with AOP-based controller timing logs and H2 persistence. | `cd java/spring/endpoint-metrics && ./gradlew bootRun` |
| [spring-core](spring-core) | Java-configured Spring context, scopes, lifecycle hooks, and YAML-backed configuration. | `cd java/spring/spring-core && ./gradlew test` |
| [spring-boot-rest-template](spring-boot-rest-template) | Spring Boot endpoint that maps JSONPlaceholder users with `RestTemplate`. | `cd java/spring/spring-boot-rest-template && ./gradlew bootRun` |
| [spring-data-jdbc](spring-data-jdbc) | Product REST API using Spring Data JDBC and an in-memory H2 database. | `cd java/spring/spring-data-jdbc && ./gradlew bootRun` |

Run tests with `./gradlew test` from an individual project directory. The Spring
Boot projects use a Java 25 toolchain; `endpoint-metrics` has additional API,
database, and Bruno collection details in its project README.
