# Callable and Future PoC

Demonstrates concurrent task execution with `Callable`, `Future`, and a fixed
thread pool.

## What It Shows

- API tasks modeled as `Callable<ApiResult>`.
- Parallel execution through `ExecutorService#submit`.
- Waiting for task results with `Future#get`.
- Aggregating multiple task responses into a single `AggregatedResponse`.
- Unit tests with JUnit and Mockito.

## Key Files

- `src/main/java/com/lughtech/aggregator/api`
- `src/main/java/com/lughtech/aggregator/core/AggregatorService.java`
- `src/main/java/com/lughtech/aggregator/core/AggregatedResponse.java`
- `src/test/java/com/lughtech/aggregator/core/AggregatorServiceTest.java`

## Run

```bash
./gradlew test
```

The `Main` class builds a small list of API tasks and executes them through the
aggregator service.
