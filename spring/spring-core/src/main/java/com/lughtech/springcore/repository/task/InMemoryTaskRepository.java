package com.lughtech.springcore.repository.task;

import com.lughtech.springcore.domain.Task;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemoryTaskRepository implements TaskRepository {

    private final Map<UUID, Task> inMemoryStorage = new HashMap<>();

    @PostConstruct
    public void init() {
        System.out.println("Created InMemoryTaskRepository");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroyed InMemoryTaskRepository");
    }

    @Override
    public void save(Task task) {
        inMemoryStorage.put(task.getId(), task);
    }

    @Override
    public List<Task> findAll() {
        return inMemoryStorage.values().stream().toList();
    }

    @Override
    public Task findById(UUID id) {
        return inMemoryStorage.get(id);
    }

}
