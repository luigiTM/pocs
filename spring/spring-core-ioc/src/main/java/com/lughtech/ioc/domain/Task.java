package com.lughtech.ioc.domain;

import java.util.UUID;

public class Task {
    private UUID id;
    private String title;
    private boolean completed;

    public Task(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.completed = false;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setCompleted() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }
}
