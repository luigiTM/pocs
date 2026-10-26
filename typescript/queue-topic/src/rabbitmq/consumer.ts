import { rabbitMQConnection } from "./config/rabbitmq";

const consumeMessage = async (consumerName: string, queue: string) => {
    const { channel } = await rabbitMQConnection();
    await channel.assertQueue(queue, { durable: true });
    console.log(`Waiting for message in ${queue}...`);

    channel.consume(queue, (message) => {
        if(message) {
            console.log(`Consumer ${consumerName} received: ${message.content.toString()}`);
            channel.ack(message);
        }
    });
}

consumeMessage("consumer-1", "order_queue");
consumeMessage("consumer-2", "order_queue");
consumeMessage("consumer-3", "order_queue");
consumeMessage("consumer-4", "order_queue");
consumeMessage("consumer-5", "order_queue");