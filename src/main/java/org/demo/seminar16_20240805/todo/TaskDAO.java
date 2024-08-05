package org.demo.seminar16_20240805.todo;

import java.util.List;

public interface TaskDAO {
    void createTask(TaskItem task);

    TaskItem readTask(String id);

    void updateTask(TaskItem task, String id);

    void deleteTask(String id);

    List<TaskItem> getAllTasks();
}
