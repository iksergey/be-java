package org.demo.seminar16_20240805.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository implements TaskDAO {
    private List<TaskItem> tasks = new ArrayList<>();

    @Override
    public void createTask(TaskItem task) {
        tasks.add(task);
    }

    @Override
    public TaskItem readTask(String id) {
        Optional<TaskItem> task = tasks.stream().filter(t -> t.getId().equals(id)).findFirst();
        return task.orElse(null);
    }

    @Override
    public void updateTask(TaskItem task, String id) {
        int index = tasks.indexOf(readTask(id));
        if (index != -1) {
            tasks.set(index, task);
        }
    }

    @Override
    public void deleteTask(String id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }

    @Override
    public List<TaskItem> getAllTasks() {
        return tasks;
    }
}
