package com.lughtech.ioc;

import com.lughtech.ioc.config.AppConfig;
import com.lughtech.ioc.service.TaskService;
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
        System.out.println("Closing context");
        context.close();
    }

}
