package com.lughtech.workerpool.core;

public class TaskProcessor {

    public TaskResult processTask(Task task) {
        long startTime = System.currentTimeMillis();
        try {
            return new TaskResult(task.id(), true, System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            return new TaskResult(task.id(), false, System.currentTimeMillis() - startTime);
        }
    }
}
