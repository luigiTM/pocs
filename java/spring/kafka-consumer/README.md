# Kafka PoC

Kafka is a distributed log, with replication and partitions.

## Key elements

- Topic: where the message are published.
- Partition: each topic is divided into partitions, immutable ordered logs. The partition is the replication and parallelism unit.
- Offset: each message receives a sequential number inside the partition. The consumer controls your position(offset) and can reset it to reprocess messages.
- Broker: a kafka cluster server.
- Consumer group: abstraction that allows to scale the consumption, each partition is assigned to a consumer inside the group, the group as a whole consume all partitions.

## Producer

The producer chooses which partition to send(round-robin or based on a key) and defines when to consider a success write based on the ack parameter.

| ack        | Behavior                              | Guarantee                                             |
|------------|---------------------------------------|-------------------------------------------------------|
| 0          | Does not wait for broker confirmation | Can lose data(fire and forget)                        |
| 1          | Wait for the leader confirmation      | Can lose data if the leader fails before confirmation |
| all(or -1) | Waits for all replicas in sync        | Better durability                                     |

## Consumer

Consumers have two ways to read:

- subscribe(consumer group):
  - The consumer joins in a group and receives all assigned partitions.
  - Allow for horizontal scalability, several consumers from the same group share the partitions.
  - Rebalance happens when a consumer enters or leaves the group.

- assign(manual assignment)
  - Consumer chooses which partitions to consume.
  - No group coordination, usefully for specific scenarios.

- Offset control:
  - Auto-commit: The client commits offsets in the background periodically, risks losing messages if the commit happens before processing, or duplicates if the process fails after the processing and before the commit.
  - Manual commit: Needs to commit after processing the message, gives total control and is the base for at-least-once delivery.

## Delivery guarantees

Kafka offers three options, with clear trade-offs:

- at-most-once: acks=0 in the producer and/or offset commit before processing.
  - can lose messages, but they are never duplicated.
- at-lest-once: `acks=all` + retries no consumer, consumer commits offset only after processing.
  - no messages are lost, but duplicates can happen if something fails after processing and before commiting.
- exactly-once: idempotent producer + kakfa transactions, consumer with `isolation.level=read_commited`