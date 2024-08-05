package org.demo.seminar16_20240805.todo;

import java.time.ZonedDateTime;

public class TaskItem {
    private String id;
    private String title;
    private String description;
    private ZonedDateTime createdAt;
    private ZonedDateTime deadline;
    private String timeZone;

    // Конструкторы, геттеры и сеттеры
    public TaskItem(
            String id,
            String title,
            String description,
            ZonedDateTime createdAt,
            ZonedDateTime deadline,
            String timeZone) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.deadline = deadline;
        this.timeZone = timeZone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(ZonedDateTime deadline) {
        this.deadline = deadline;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
