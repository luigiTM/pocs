# RabbitMQ Queue vs. Kafka Topic

A TypeScript proof of concept that demonstrates the difference between competing consumers on a RabbitMQ queue and consumers in separate Kafka consumer groups.

## Goal

The application receives an order over HTTP and publishes it to the `order_queue` queue. Five RabbitMQ consumers compete for messages from that queue, so only one of them receives each message. The selected consumer then forwards the payload to the Kafka `orders` topic.

Kafka also has five consumers, but each one belongs to a different `groupId`. As a result, every consumer receives a copy of each published event.

```text
POST /api/order
       │
       ▼
RabbitMQ: order_queue
       │
       ├── consumer-1 ─┐
       ├── consumer-2  │ only one receives each message
       ├── consumer-3  │
       ├── consumer-4  │
       └── consumer-5 ─┘
              │
              ▼
       Kafka: orders
              │
       ┌──────┼────────┬────────┬────────┐
       ▼      ▼        ▼        ▼        ▼
    group-1 group-2  group-3  group-4  group-5
       │      │        │        │        │
       └──────┴────────┴────────┴────────┘
              all receive the event
```

## Observed behavior

For three identical messages, the logs show that RabbitMQ distributed processing among `consumer-2`, `consumer-3`, and `consumer-5`:

```text
[RabbitMQ] Consumer consumer-2 received: {"customerId":1,"itemId":1,"quantity":1}
[RabbitMQ] Consumer consumer-3 received: {"customerId":1,"itemId":1,"quantity":1}
[RabbitMQ] Consumer consumer-5 received: {"customerId":1,"itemId":1,"quantity":1}
```

Each message was forwarded to Kafka and received by all five consumers:

```text
[Kafka] Consumer consumer-1 received: {"customerId":1,"itemId":1,"quantity":1}
[Kafka] Consumer consumer-2 received: {"customerId":1,"itemId":1,"quantity":1}
[Kafka] Consumer consumer-3 received: {"customerId":1,"itemId":1,"quantity":1}
[Kafka] Consumer consumer-4 received: {"customerId":1,"itemId":1,"quantity":1}
[Kafka] Consumer consumer-5 received: {"customerId":1,"itemId":1,"quantity":1}
```

The Kafka log order may vary because the consumers process events independently.

> If the Kafka consumers used the same `groupId`, they would share the topic partitions, and only one consumer in the group would process each event. The broadcast behavior in this POC comes from using five separate consumer groups, not merely from using a topic.

## Technologies

- Node.js and TypeScript
- Express
- RabbitMQ 4 with the Management UI
- Apache Kafka 4 in KRaft mode
- KafkaJS
- Docker Compose

## Running the project

### Prerequisites

- Docker with Docker Compose
- Node.js
- pnpm

Start RabbitMQ, Kafka, and Kafka UI:

```bash
docker compose up -d
```

Install the dependencies and start the application:

```bash
pnpm install
pnpm dev
```

During startup, the application creates the `orders` topic with three partitions if it does not already exist.

## Sending an order

```bash
curl -X POST http://localhost:3333/api/order \
  -H 'Content-Type: application/json' \
  -d '{"customerId":1,"itemId":1,"quantity":1}'
```

Expected response:

```json
"Order created!"
```

Repeat the request to see different RabbitMQ consumers receive the messages while every Kafka consumer receives each forwarded event.

## Local interfaces

| Service | Address | Credentials |
| --- | --- | --- |
| API | `http://localhost:3333` | — |
| RabbitMQ Management | `http://localhost:15672` | `user` / `password` |
| Kafka UI | `http://localhost:8080` | — |

## Acknowledgment flow

The RabbitMQ consumer acknowledges a message only after Kafka accepts the publication. This prevents the message from being acknowledged and removed from the queue before it is forwarded to the topic. As with any flow that uses separate acknowledgment steps, a failure between publication and acknowledgment may still cause the message to be processed again; production consumers should be idempotent.

## Project structure

```text
src/
├── controllers/order.controller.ts  # Receives an order and publishes it to RabbitMQ
├── kafka/
│   ├── config/kafka.ts               # Connection and topic creation
│   └── consumer.ts                   # Five consumers in separate groups
├── rabbitmq/
│   ├── config/rabbitmq.ts            # RabbitMQ connection
│   └── consumer.ts                   # Five consumers competing for the queue
├── routes/order.routes.ts
└── server.ts                         # Coordinated application startup
```

Stop the services with:

```bash
docker compose down
```
