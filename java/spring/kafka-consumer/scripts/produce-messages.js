import { Kafka } from 'kafkajs';

const brokers = (process.env.KAFKA_BROKERS ?? 'localhost:29092')
  .split(',')
  .map((broker) => broker.trim())
  .filter(Boolean);
const topic = process.env.KAFKA_TOPIC ?? 'messages';
const count = Number.parseInt(process.env.MESSAGE_COUNT ?? '3', 10);

if (brokers.length === 0 || !topic || count < 1) {
  throw new Error('Set valid brokers, topic, and message count.');
}

const kafka = new Kafka({ clientId: 'kafka-message-producer', brokers });
const producer = kafka.producer();

try {
  await producer.connect();
  const messages = Array.from({ length: count }, (_, index) => ({
    key: `sample-${index + 1}`,
    value: JSON.stringify({
      id: index + 1,
      message: `Hello from Kafka (${index + 1})`,
      createdAt: new Date().toISOString(),
    }),
  }));

  await producer.send({ topic, messages });
  console.log(`Produced ${messages.length} messages to topic "${topic}".`);
} finally {
  await producer.disconnect();
}
