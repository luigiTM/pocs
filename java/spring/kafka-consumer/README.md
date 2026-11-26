# Spring Kafka Consumer PoC

A Spring Boot application that publishes JSON messages to a three-broker Kafka
cluster and consumes them with two consumer groups. One listener uses automatic
offset commits; the other commits offsets manually. The producer enables
idempotence and uses `acks=all`.

## Requirements

- JDK 17 or later
- Docker with Docker Compose

## Run locally

Start the Kafka cluster from this directory:

```bash
docker compose up -d
```

Create the configured topics and publish sample messages using the helper
scripts (see [scripts/README.md](scripts/README.md)), or start the application
directly:

```bash
./gradlew bootRun
```

The application listens on port `8081`. Its Kafka listeners and producer
connect to the local broker addresses `localhost:19092`, `localhost:19093`,
and `localhost:19094`.

Publish a message through the HTTP endpoint:

```bash
curl -X POST http://localhost:8081/api/messages/ -i
```

The endpoint creates a message with a generated UUID and publishes it to
`topic-with-replication`. Both consumer groups listen to that topic; inspect
the application logs to see their processing and offset-commit behavior.

The Kafka UI is available at <http://localhost:8080>. Stop the services with:

```bash
docker compose down
```

The producer and consumers use the topic `topic-with-replication`. The
companion scripts also create `poc-consumer` and `topic-with-replication` by
default; the latter has three partitions and replication factor three.
