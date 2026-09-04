package com.lughtech.springcore.service.job;

import com.lughtech.springcore.domain.Job;

import java.util.List;
import java.util.UUID;

public interface JobService {

    void createJob(String jobName);

    void completeJob(UUID id);

    List<Job> listJobs();

}
