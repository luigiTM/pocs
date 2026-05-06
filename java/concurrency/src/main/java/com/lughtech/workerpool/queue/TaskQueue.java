package com.lughtech.workerpool.queue;

import com.lughtech.workerpool.core.Task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class TaskQueue {

    private BlockingQueue<Task> queue;

    public TaskQueue() {
        this.queue = new SynchronousQueue<>();
    }

    public boolean submit(Task task) {
        // Block if full
        return this.queue.add(task);
    }

    public Task take() throws InterruptedException {
        // Block until task is available
        return this.queue.take();
    }
}
