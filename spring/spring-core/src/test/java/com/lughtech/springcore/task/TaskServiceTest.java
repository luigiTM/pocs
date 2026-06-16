package com.lughtech.springcore.task;

import com.lughtech.springcore.config.AppConfig;
import com.lughtech.springcore.service.task.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class TaskServiceTest {

    @Test
    void shouldGetTaskServiceFromContext() {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            var taskService = context.getBean(TaskService.class);
            assertNotNull(taskService);
        }
    }

    @Test
    void shouldGetTaskServiceAsSingleton() {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            var taskService = context.getBean(TaskService.class);
            var anotherTaskService = context.getBean(TaskService.class);
            assertSame(taskService, anotherTaskService);
        }
    }
}
