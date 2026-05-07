package com.lughtech.workerpool.queue;

import com.lughtech.workerpool.core.Task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class TaskQueue {

    private final BlockingQueue<Task> queue;

    public TaskQueue(int queueSize) {
        this.queue = new ArrayBlockingQueue<>(queueSize);
    }

    public void submit(Task task) throws InterruptedException {
        this.queue.put(task);
    }

    public Task take() throws InterruptedException {
        return this.queue.take();
    }
}
