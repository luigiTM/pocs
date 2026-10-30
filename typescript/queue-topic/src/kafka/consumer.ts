import { createConsumer } from "./config/kafka";

const consumeMessages = async (
  consumerName: string,
  topic: string,
): Promise<void> => {
  // Each name creates a separate group, so all consumers receive the message. In
  // the same group, Kafka would assign each partition to only one consumer at a time.
  const consumer = createConsumer(`${consumerName}-group`);

  await consumer.connect();
  // A new group starts with messages published after it subscribes.
  await consumer.subscribe({ topic, fromBeginning: false });

  await consumer.run({
    eachMessage: async ({ message }) => {
      console.log(`[Kafka] Consumer ${consumerName} received: ${message.value?.toString()}`);
    },
  });
};

export const startKafkaConsumers = async (topic: string): Promise<void> => {
  await Promise.all([
    consumeMessages("consumer-1", topic),
    consumeMessages("consumer-2", topic),
    consumeMessages("consumer-3", topic),
    consumeMessages("consumer-4", topic),
    consumeMessages("consumer-5", topic),
  ]);
};
