package com.lughtech.ioc.repository;

import com.lughtech.ioc.domain.Task;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemoryTaskRepository implements TaskRepository {

    private final Map<UUID, Task> inMemoryStorage = new HashMap<>();

    @Override
    public void save(Task task) {
        inMemoryStorage.put(task.id(), task);
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
