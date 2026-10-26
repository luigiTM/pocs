import ampq from "amqplib";

export const rabbitMQConnection = async () => {
    try {
        const connection = await ampq.connect("amqp://user:password@localhost");
        const channel = await connection.createChannel();
        console.log("Connected to RabbitMQ");
        return { connection, channel };
    } catch (error) {
        console.log("Error connecting to RabbitMQ: ", error);
        throw error;
    }
};