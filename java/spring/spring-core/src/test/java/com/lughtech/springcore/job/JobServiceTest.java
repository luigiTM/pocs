package com.lughtech.springcore.job;

import com.lughtech.springcore.config.AppConfig;
import com.lughtech.springcore.service.job.JobService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class JobServiceTest {

    @Test
    void shouldGetJobServiceFromContext() {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            var jobService = context.getBean(JobService.class);
            assertNotNull(jobService);
        }
    }

    @Test
    void shouldGetJobServiceAsPrototype() {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            var jobService = context.getBean(JobService.class);
            var anotheJjobService = context.getBean(JobService.class);
            assertNotSame(jobService, anotheJjobService);
        }
    }

}
