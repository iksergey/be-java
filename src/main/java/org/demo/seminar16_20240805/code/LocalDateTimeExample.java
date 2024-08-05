package org.demo.seminar16_20240805.code;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        // Текущая дата и время
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Текущая дата и время: " + currentDateTime);

        // Создание конкретной даты и времени
        LocalDateTime specificDateTime = LocalDateTime.of(2023, 8, 5, 14, 30, 45);
        System.out.println("Конкретная дата и время: " + specificDateTime);

        // Форматирование даты и времени
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Форматированная дата и время: " + formattedDateTime);

        // Изменение даты и времени
        LocalDateTime nextHour = currentDateTime.plusHours(1);
        System.out.println("Дата и время через час: " + nextHour);

        LocalDateTime previousDay = currentDateTime.minusDays(1);
        System.out.println("Дата и время день назад: " + previousDay);
    }
}
