import { Kafka } from 'kafkajs';

const brokers = (process.env.KAFKA_BROKERS ?? 'localhost:29092')
  .split(',')
  .map((broker) => broker.trim())
  .filter(Boolean);
const topicNames = (process.env.KAFKA_TOPICS ?? 'messages')
  .split(',')
  .map((topic) => topic.trim())
  .filter(Boolean);
const numPartitions = Number.parseInt(process.env.KAFKA_PARTITIONS ?? '1', 10);
const replicationFactor = Number.parseInt(process.env.KAFKA_REPLICATION_FACTOR ?? '1', 10);
const minInSyncReplicas = Number.parseInt(process.env.KAFKA_MIN_IN_SYNC_REPLICAS ?? '1', 10)

if (brokers.length === 0 || topicNames.length === 0 || numPartitions < 1 || replicationFactor < 1) {
  throw new Error('Set valid brokers, topic names, partitions, and replication factor.');
}

const kafka = new Kafka({ clientId: 'kafka-topic-setup', brokers });
const admin = kafka.admin();

try {
  await admin.connect();
  const created = await admin.createTopics({
    waitForLeaders: true,
    topics: topicNames.map((topic) => ({
      topic,
      numPartitions,
      replicationFactor,
      configEntries: [
        { name: 'min.insync.replicas', value: String(minInSyncReplicas) }
      ] })),
  });

  console.log(created
    ? `Created topics: ${topicNames.join(', ')}`
    : `All requested topics already exist: ${topicNames.join(', ')}`);
} finally {
  await admin.disconnect();
}
