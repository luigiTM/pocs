package com.lughtech.springcore.repository.job;

import com.lughtech.springcore.domain.Job;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemoryJobRepository implements JobRepository {

    private final Map<UUID, Job> inMemoryStorage = new HashMap<>();

    @PostConstruct
    public void init() {
        System.out.println("Created InMemoryJobRepository");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroyed InMemoryJobRepository");
    }

    @Override
    public void saveJob(Job job) {
        inMemoryStorage.put(job.getId(), job);
    }

    @Override
    public List<Job> findAll() {
        return inMemoryStorage.values().stream().toList();
    }

    @Override
    public Job finById(UUID id) {
        return inMemoryStorage.get(id);
    }
}
