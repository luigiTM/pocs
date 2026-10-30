import { Kafka, logLevel, type Consumer } from "kafkajs";

const kafkaConfig = {
  clientId: "queue-topic-poc",
  brokers: ["localhost:9092"],
  logLevel: logLevel.ERROR,
};

export const kafka = new Kafka(kafkaConfig);
export const producer = kafka.producer();
export const admin = kafka.admin();
export const ORDERS_TOPIC = "orders";

// Consumers are not singletons: the groupId determines whether they share or replicate consumption.
export const createConsumer = (groupId: string): Consumer =>
  kafka.consumer({ groupId });

let initialization: Promise<void> | undefined;

export const initializeKafka = (): Promise<void> => {
  // Storing the Promise makes concurrent calls share the same initialization.
  initialization ??= (async () => {
    await Promise.all([producer.connect(), admin.connect()]);

    // createTopics is idempotent: an existing topic is not created again.
    await admin.createTopics({
      topics: [
        {
          topic: ORDERS_TOPIC,
          numPartitions: 3,
          replicationFactor: 1,
        },
      ],
      waitForLeaders: true,
    });
  })();

  return initialization;
};
