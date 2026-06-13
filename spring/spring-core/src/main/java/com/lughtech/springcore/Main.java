package com.lughtech.springcore;

import com.lughtech.springcore.config.AppConfig;
import com.lughtech.springcore.service.job.JobService;
import com.lughtech.springcore.service.task.TaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    static void main() {
        System.out.println("Creating context");
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Retrieving TaskService");
        var taskService = context.getBean(TaskService.class);

        taskService.createTask("This is a task");
        taskService.createTask("This is another task");
        taskService.listTasks().forEach(System.out::println);

        System.out.println("Retrieving another TaskService");
        var anotherTaskService = context.getBean(TaskService.class);
        anotherTaskService.listTasks().forEach(System.out::println);

        System.out.println("Retrieving JobService");
        var jobService = context.getBean(JobService.class);
        jobService.createJob("This is a job");
        jobService.listJobs().forEach(System.out::println);

        System.out.println("Retrieving another JobService");
        var anotherJobService = context.getBean(JobService.class);
        anotherJobService.createJob("This is another job");
        jobService.listJobs().forEach(System.out::println);

        System.out.println("Closing context");
        context.close();
    }

}
