package com.lughtech.ioc.service;

import com.lughtech.ioc.domain.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    void createTask(String title);

    void completeTask(UUID id);

    List<Task> listTasks();
}
