package org.demo.seminar16_20240805.code;

import java.time.LocalDate;
import java.time.DayOfWeek;

public class LocalDateExample {
    public static void main(String[] args) {
        // Текущая дата
        LocalDate currentDate = LocalDate.now();
        System.out.println("Текущая дата: " + currentDate);

        // Создание конкретной даты
        LocalDate specificDate = LocalDate.of(2023, 8, 5);
        System.out.println("Конкретная дата: " + specificDate);

        // Получение частей даты
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        System.out.println("Год: " + year);
        System.out.println("Месяц: " + month);
        System.out.println("День: " + day);
        System.out.println("День недели: " + dayOfWeek);

        // Изменение даты
        LocalDate nextWeek = currentDate.plusWeeks(1);
        System.out.println("Дата через неделю: " + nextWeek);

        LocalDate previousMonth = currentDate.minusMonths(1);
        System.out.println("Дата месяц назад: " + previousMonth);
    }
}
