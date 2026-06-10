package com.lughtech.ioc.service;

import com.lughtech.ioc.domain.Task;
import com.lughtech.ioc.repository.TaskRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostConstruct
    public void init() {
        System.out.println("Created TaskService");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroyed TaskService");
    }

    @Override
    public void createTask(String title) {
        var newTask = new Task(title);
        taskRepository.save(newTask);
    }

    @Override
    public void completeTask(UUID id) {
        var task = taskRepository.findById(id);
        if (!task.isCompleted()) {
            task.setCompleted();
        }
    }

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll();
    }
}
