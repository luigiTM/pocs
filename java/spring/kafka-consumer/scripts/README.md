# Kafka scripts

These scripts use KafkaJS and the local broker from `docker-compose.yaml` (`localhost:29092`).

Install dependencies once, then run the wrapper from any directory:

```sh
npm --prefix scripts install
./scripts/execute.sh [create-topics|produce-messages|all]
```

Pass `create-topics` or `produce-messages` to run one script. `all` (the default)
creates the configured topics and then produces sample messages.
The wrapper loads defaults from `scripts/.env` before running either JavaScript
file; edit that file to change the settings.

Configuration is available through environment variables:

- `KAFKA_BROKERS`: comma-separated broker addresses (default: `localhost:29092`)
- `KAFKA_TOPICS`: comma-separated topic names for creation (default: `messages`)
- `KAFKA_TOPIC`: topic for producing (default: `messages`)
- `KAFKA_PARTITIONS`: partitions per created topic (default: `1`)
- `KAFKA_REPLICATION_FACTOR`: replication factor (default: `1`)
- `MESSAGE_COUNT`: number of sample messages to produce (default: `3`)
