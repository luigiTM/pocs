import { type Request, type Response, type NextFunction } from 'express';
import { rabbitMQConnection } from "../rabbitmq/config/rabbitmq"

export const createOrder = async (req: Request, res: Response, next: NextFunction) => {
    try {
        const order = req.body;
        const { channel } = await rabbitMQConnection();
        await channel.assertQueue("order_queue", { durable:true });
        channel.sendToQueue("order_queue", Buffer.from(JSON.stringify(order)));
        res.json("Order created!");
    } catch (error) {
        next(error);
    }

}