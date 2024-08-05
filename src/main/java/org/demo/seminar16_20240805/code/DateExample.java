package org.demo.seminar16_20240805.code;

import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        // Создание текущей даты
        Date currentDate = new Date();
        System.out.println("Текущая дата: " + currentDate);

        // Создание даты с использованием миллисекунд
        Date specificDate = new Date(1700000000000L);
        System.out.println("Дата по миллисекундам: " + specificDate);

        // Сравнение дат
        Date date1 = new Date(1600000000000L);
        System.out.println("Дата date1: " + date1);
        Date date2 = new Date(1600000000000L);
        System.out.println("Дата date2: " + date2);
        System.out.println("date1 после date2? " + date1.after(date2));
        System.out.println("date1 до date2? " + date1.before(date2));
        System.out.println("date1 равно date2? " + date1.equals(date2));

        // Получение и установка времени
        long time = currentDate.getTime();
        System.out.println("Время в миллисекундах: " + time);
        currentDate.setTime(1600000000000L);
        System.out.println("Обновленная дата: " + currentDate);
    }
}
