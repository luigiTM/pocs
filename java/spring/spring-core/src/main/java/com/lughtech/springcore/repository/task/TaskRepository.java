package com.lughtech.springcore.repository.task;

import com.lughtech.springcore.domain.Task;

import java.util.List;
import java.util.UUID;

public interface TaskRepository {

    void save(Task task);

    List<Task> findAll();

    Task findById(UUID id);
}
