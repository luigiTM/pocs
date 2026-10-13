import express from 'express'
import orderRoutes from './routes/order.routes';

import { Router, type Request, type Response } from 'express';

const app = express();

app.use(express.json())

app.use('/api/order', orderRoutes);

app.listen(3333, () => 'server running on port 3333')