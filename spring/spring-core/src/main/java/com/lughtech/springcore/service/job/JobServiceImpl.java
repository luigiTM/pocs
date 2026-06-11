package com.lughtech.springcore.service.job;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class JobServiceImpl implements JobService {

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
        System.out.println("Creating job with name " + jobName);
    }

}
