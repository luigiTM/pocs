package com.lughtech.springcore.service.task;

import com.lughtech.springcore.domain.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    void createTask(String title);

    void completeTask(UUID id);

    List<Task> listTasks();
}
