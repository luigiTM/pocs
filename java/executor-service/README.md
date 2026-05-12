# Executor Service PoC

Demonstrates a basic worker pool built on top of Java's `ExecutorService`.

## What It Shows

- Fixed-size worker pool creation with `Executors.newFixedThreadPool`.
- Worker lifecycle management with start and stop operations.
- Task submission through a shared task queue.
- Task processing using a `TaskProcessor` abstraction.
- Graceful shutdown with `awaitTermination`.

## Key Files

- `src/main/java/com/lughtech/workerpool/worker/WorkerPool.java`
- `src/main/java/com/lughtech/workerpool/worker/Worker.java`
- `src/main/java/com/lughtech/workerpool/queue/TaskQueue.java`
- `src/main/java/com/lughtech/workerpool/core`
- `src/main/java/com/lughtech/workerpool/execution/WorkerPoolRunner.java`

## Run

```bash
./gradlew test
```

The `Main` class creates a worker-pool runner, produces sample tasks, and stops
the pool.
