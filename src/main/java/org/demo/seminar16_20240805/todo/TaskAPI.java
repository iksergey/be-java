package org.demo.seminar16_20240805.todo;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;

public class TaskAPI {
    private TaskDAO taskDAO = new TaskRepository();

    public String createTask(String title, String description, ZonedDateTime deadline, String timeZone)
            throws IOException {
        String id = IdGenerator.generateId();
        ZonedDateTime createdAt = ZonedDateTime.now();
        TaskItem task = new TaskItem(id, title, description, createdAt, deadline, timeZone);
        taskDAO.createTask(task);
        return JsonConverter.toJson(task);
    }

    public String readTask(String id) throws IOException {
        TaskItem task = taskDAO.readTask(id);
        return task != null ? JsonConverter.toJson(task) : "{}";
    }

    public String updateTask(String id, String title, String description, ZonedDateTime deadline, String timeZone)
            throws IOException {
        TaskItem task = taskDAO.readTask(id);
        if (task != null) {
            task.setTitle(title);
            task.setDescription(description);
            task.setDeadline(deadline);
            task.setTimeZone(timeZone);
            taskDAO.updateTask(task, id);
            return JsonConverter.toJson(task);
        }
        return "{}";
    }

    public void deleteTask(String id) {
        taskDAO.deleteTask(id);
    }

    public String getAllTasks() throws IOException {
        List<TaskItem> tasks = taskDAO.getAllTasks();
        return JsonConverter.toJson(tasks);
    }
}
