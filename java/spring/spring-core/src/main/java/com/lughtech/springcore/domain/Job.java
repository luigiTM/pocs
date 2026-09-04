package com.lughtech.springcore.domain;

import java.util.UUID;

public class Job {

    private final UUID id;
    private final String title;
    private boolean completed;

    public Job(String title) {
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

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
