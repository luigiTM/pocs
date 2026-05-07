package com.lughtech.workerpool.worker;

import com.lughtech.workerpool.core.TaskProcessor;
import com.lughtech.workerpool.queue.TaskQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkerPool {

    private ExecutorService executorService;
    private List<Worker> workers;
    private final TaskQueue taskQueue;
    private final TaskProcessor taskProcessor;

    public WorkerPool(TaskQueue taskQueue, TaskProcessor taskProcessor) {
        this.taskQueue = taskQueue;
        this.taskProcessor = taskProcessor;
    }

    public void start(int workers) {
        this.workers = new ArrayList<>(workers);
        this.executorService = Executors.newFixedThreadPool(workers);
        for (int i = 0; i < workers; i++) {
            var worker = new Worker(this.taskQueue, this.taskProcessor);
            this.workers.add(worker);
            executorService.submit(worker);
        }
    }

    public boolean stop() throws InterruptedException {
        workers.forEach(Worker::stop);
        executorService.shutdown();
        return executorService.awaitTermination(5, TimeUnit.MINUTES);
    }
}
