# Kafka scripts

These scripts use KafkaJS and the local broker cluster from
`../docker-compose.yaml` (`localhost:19092`, `localhost:19093`, and
`localhost:19094`). Defaults are loaded from `scripts/.env`.

From the `java/spring/kafka-consumer` directory, install dependencies once and
run the wrapper:

```sh
npm --prefix scripts install
./scripts/execute.sh [create-topics|produce-messages|all]
```

Pass `create-topics` or `produce-messages` to run one script. `all` (the default)
creates the configured topics and then produces sample messages.
The wrapper loads defaults from `scripts/.env` before running either JavaScript
file; edit that file to change the settings. The setup script creates
`topic-with-replication`; the producer script publishes to `poc-consumer` by
default.

Configuration is available through environment variables:

- `KAFKA_BROKERS`: comma-separated broker addresses (configured as `localhost:19092,localhost:19093,localhost:19094`)
- `KAFKA_TOPICS`: comma-separated topic names for creation (configured as `topic-with-replication`)
- `KAFKA_TOPIC`: topic for producing messages (configured as `poc-consumer`)
- `KAFKA_PARTITIONS`: partitions per created topic (configured as `3`)
- `KAFKA_REPLICATION_FACTOR`: replication factor (configured as `3`)
- `KAFKA_MIN_IN_SYNC_REPLICAS`: minimum in-sync replicas (configured as `2`)
- `MESSAGE_COUNT`: number of sample messages to produce (configured as `3`)
