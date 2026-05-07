package com.lughtech.workerpool.execution;

import com.lughtech.workerpool.core.HashingTaskProcessor;
import com.lughtech.workerpool.core.Task;
import com.lughtech.workerpool.core.TaskProcessor;
import com.lughtech.workerpool.queue.TaskQueue;
import com.lughtech.workerpool.worker.WorkerPool;

import java.util.UUID;

public class WorkerPoolRunner {

    private final TaskQueue taskQueue;
    private final WorkerPool workerPool;

    public WorkerPoolRunner(int queueSize, int workers) {
        this.taskQueue = new TaskQueue(queueSize);
        TaskProcessor taskProcessor = new HashingTaskProcessor();
        this.workerPool = new WorkerPool(this.taskQueue, taskProcessor);
        this.workerPool.start(workers);
    }

    public void produce(int tasks) throws InterruptedException {
        for (int i = 0; i < tasks; i++) {
            var task = new Task(UUID.randomUUID(), "");
            this.taskQueue.submit(task);
        }
    }

    public void stop() throws InterruptedException {
        this.workerPool.stop();
    }
}
