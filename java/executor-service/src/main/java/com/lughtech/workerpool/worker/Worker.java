package com.lughtech.workerpool.worker;

import com.lughtech.workerpool.core.TaskProcessor;
import com.lughtech.workerpool.queue.TaskQueue;

public class Worker implements Runnable {

    private final TaskQueue taskQueue;
    private final TaskProcessor taskProcessor;
    private volatile boolean running = true;

    public Worker(TaskQueue taskQueue, TaskProcessor taskProcessor) {
        this.taskQueue = taskQueue;
        this.taskProcessor = taskProcessor;
    }

    @Override
    public void run() {
        log("STARTED");

        while (running) {
            try {
                log("WAITING_FOR_TASK");

                var task = taskQueue.take();

                log("PICKED_TASK id=" + task.id());

                long start = System.nanoTime();

                var result = taskProcessor.process(task);

                long duration = System.nanoTime() - start;

                log("FINISHED_TASK id=" + task.id() +
                        " success=" + result.success() +
                        " execTime=" + result.executionTime() +
                        " totalTime=" + duration);

            } catch (InterruptedException e) {
                log("INTERRUPTED - shutting down");
                Thread.currentThread().interrupt();
                break;

            } catch (Exception e) {
                log("ERROR processing task: " + e.getMessage());
            }
        }

        log("STOPPED");
    }

    public void stop() {
        log("STOP_REQUESTED");
        this.running = false;
    }

    private void log(String message) {
        System.out.println(
                "[Worker-" + Thread.currentThread().threadId() + "] " + message
        );
    }
}