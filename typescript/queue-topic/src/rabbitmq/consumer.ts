import { rabbitMQConnection } from "./config/rabbitmq";
import { ORDERS_TOPIC, producer } from "../kafka/config/kafka";

const consumeMessage = async (consumerName: string, queue: string) => {
    const { channel } = await rabbitMQConnection();
    await channel.assertQueue(queue, { durable: true });
    console.log(`Waiting for message in ${queue}...`);

    channel.consume(queue, async (message) => {
        if(message) {
            console.log(`[RabbitMQ] Consumer ${consumerName} received: ${message.content.toString()}`);
            await producer.send({
                topic: ORDERS_TOPIC,
                messages: [{ value: message.content }],
            });
            // Acknowledge in RabbitMQ only after Kafka accepts the publication.
            channel.ack(message);
        }
    });
}

export const startRabbitMQConsumers = async (): Promise<void> => {
    // All consumers use the same queue, so they compete and only one receives each message.
    await Promise.all([
        consumeMessage("consumer-1", "order_queue"),
        consumeMessage("consumer-2", "order_queue"),
        consumeMessage("consumer-3", "order_queue"),
        consumeMessage("consumer-4", "order_queue"),
        consumeMessage("consumer-5", "order_queue"),
    ]);
};
