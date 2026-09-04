package com.lughtech.springcore.repository.job;

import com.lughtech.springcore.domain.Job;

import java.util.List;
import java.util.UUID;

public interface JobRepository {

    void saveJob(Job job);

    List<Job> findAll();

    Job finById(UUID id);

}
