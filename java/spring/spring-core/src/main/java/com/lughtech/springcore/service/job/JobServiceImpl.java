package com.lughtech.springcore.service.job;

import com.lughtech.springcore.domain.Job;
import com.lughtech.springcore.repository.job.JobRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Scope("prototype")
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    @PostConstruct
    public void init() {
        System.out.println("Created JobService");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroyed JobService");
    }

    @Override
    public void createJob(String jobName) {
        jobRepository.saveJob(new Job(jobName));
    }

    @Override
    public void completeJob(UUID id) {
        var job = jobRepository.finById(id);
        if (!job.isCompleted()) {
            job.setCompleted();
        }
    }

    @Override
    public List<Job> listJobs() {
        return jobRepository.findAll();
    }

    @Autowired
    public void setJobRepository(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

}
