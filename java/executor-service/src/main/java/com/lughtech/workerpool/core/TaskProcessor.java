package com.lughtech.workerpool.core;

public interface TaskProcessor {

    public default TaskResult process(Task task) {
        long startTime = System.currentTimeMillis();
        try {
            return new TaskResult(task.id(), true, System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            return new TaskResult(task.id(), false, System.currentTimeMillis() - startTime);
        }
    }
}
