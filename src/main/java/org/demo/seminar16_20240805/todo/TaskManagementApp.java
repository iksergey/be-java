package org.demo.seminar16_20240805.todo;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TaskManagementApp {
    public static void run() {
        TaskAPI taskAPI = new TaskAPI();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать задачу");
            System.out.println("2. Просмотреть задачу");
            System.out.println("3. Обновить задачу");
            System.out.println("4. Удалить задачу");
            System.out.println("5. Просмотреть все задачи");
            System.out.println("6. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Введите название задачи:");
                        String title = scanner.nextLine();

                        System.out.println("Введите описание задачи:");
                        String description = scanner.nextLine();

                        System.out.println("Введите дедлайн (например, 2024-08-05T10:15:30+01:00[Europe/London]):");
                        String deadlineStr = scanner.nextLine();
                        ZonedDateTime deadline = ZonedDateTime.parse(deadlineStr,
                                DateTimeFormatter.ISO_ZONED_DATE_TIME);

                        System.out.println("Введите временную зону (например, Europe/London):");
                        String timeZone = scanner.nextLine();

                        String newTaskJson = taskAPI.createTask(title, description, deadline, timeZone);
                        System.out.println("Задача создана: " + newTaskJson);
                        break;

                    case 2:
                        System.out.println("Введите ID задачи:");
                        String readId = scanner.nextLine();

                        String taskJson = taskAPI.readTask(readId);
                        System.out.println("Задача: " + taskJson);
                        break;

                    case 3:
                        System.out.println("Введите ID задачи:");
                        String updateId = scanner.nextLine();

                        System.out.println("Введите новое название задачи:");
                        String newTitle = scanner.nextLine();

                        System.out.println("Введите новое описание задачи:");
                        String newDescription = scanner.nextLine();

                        System.out
                                .println("Введите новый дедлайн (например, 2024-08-05T10:15:30+01:00[Europe/London]):");
                        String newDeadlineStr = scanner.nextLine();
                        ZonedDateTime newDeadline = ZonedDateTime.parse(newDeadlineStr,
                                DateTimeFormatter.ISO_ZONED_DATE_TIME);

                        System.out.println("Введите новую временную зону (например, Europe/London):");
                        String newTimeZone = scanner.nextLine();

                        String updatedTaskJson = taskAPI.updateTask(updateId, newTitle, newDescription, newDeadline,
                                newTimeZone);
                        System.out.println("Задача обновлена: " + updatedTaskJson);
                        break;

                    case 4:
                        System.out.println("Введите ID задачи:");
                        String deleteId = scanner.nextLine();

                        taskAPI.deleteTask(deleteId);
                        System.out.println("Задача удалена.");
                        break;

                    case 5:
                        String allTasksJson = taskAPI.getAllTasks();
                        System.out.println("Все задачи: " + allTasksJson);
                        break;

                    case 6:
                        System.out.println("Выход из программы.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }
    }
}
