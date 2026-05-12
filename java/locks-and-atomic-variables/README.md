# Locks and Atomic Variables PoC

Demonstrates thread-safe account transfers using explicit locks and atomic
metrics.

## What It Shows

- `ReentrantLock` usage on shared bank account state.
- Coordinated transfers between accounts.
- Concurrent transfer execution through transfer tasks and a runner.
- Atomic counters for successful transfers, failed transfers, and transferred
  amount metrics.

## Key Files

- `src/main/java/com/lughtech/concurrent/bank/account/BankAccount.java`
- `src/main/java/com/lughtech/concurrent/bank/account/AccountRepository.java`
- `src/main/java/com/lughtech/concurrent/bank/transfer/TransferService.java`
- `src/main/java/com/lughtech/concurrent/bank/transfer/TransferTask.java`
- `src/main/java/com/lughtech/concurrent/metrics/TransferMetrics.java`
- `src/main/java/com/lughtech/concurrent/execution/TransferRunner.java`

## Run

```bash
./gradlew test
```

The `Main` class runs a batch of sample transfers.
