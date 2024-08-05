package org.demo.seminar16_20240805.code;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeExample {
    public static void main(String[] args) {
        // Текущая дата и время с часовым поясом
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();
        System.out.println("Текущая дата и время с часовым поясом: " + currentZonedDateTime);

        // Создание конкретной даты и времени с часовым поясом
        ZonedDateTime specificZonedDateTime = ZonedDateTime.of(2033, 8, 5, 14, 30, 45, 0, ZoneId.of("Europe/Moscow"));
        System.out.println("Конкретная дата и время с часовым поясом: " + specificZonedDateTime);

        // Форматирование даты и времени с часовым поясом
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");
        String formattedZonedDateTime = currentZonedDateTime.format(formatter);
        System.out.println("Форматированная дата и время с часовым поясом: " + formattedZonedDateTime);

        // Изменение даты и времени с часовым поясом
        ZonedDateTime nextDay = currentZonedDateTime.plusDays(1);
        System.out.println("Дата и время с часовым поясом через день: " + nextDay);

        ZonedDateTime previousMonth = currentZonedDateTime.minusMonths(1);
        System.out.println("Дата и время с часовым поясом месяц назад: " + previousMonth);
    }
}
