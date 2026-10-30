import express from 'express'
import orderRoutes from './routes/order.routes';
import { startRabbitMQConsumers } from './rabbitmq/consumer';
import { initializeKafka, ORDERS_TOPIC } from './kafka/config/kafka';
import { startKafkaConsumers } from './kafka/consumer';

const app = express();

app.use(express.json())

app.use('/api/order', orderRoutes);

const startServer = async () => {
  // Kafka must be ready before RabbitMQ starts forwarding messages.
  await initializeKafka();
  await startKafkaConsumers(ORDERS_TOPIC);
  await startRabbitMQConsumers();

  app.listen(3333, () => {
    console.log('Server running on port 3333');
  });
};

startServer().catch((error) => {
  console.error('Error starting server:', error);
});
