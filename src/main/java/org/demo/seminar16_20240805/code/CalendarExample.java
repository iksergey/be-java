package org.demo.seminar16_20240805.code;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarExample {
    public static void main(String[] args) {
        // Создание текущей даты
        Calendar calendar = new GregorianCalendar();
        System.out.println("Текущая дата: " + calendar.getTime());

        // Получение различных частей даты
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // Месяцы начинаются с 0
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Год: " + year);
        System.out.println("Месяц: " + (month + 1));
        System.out.println("День: " + day);

        // Изменение даты
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, Calendar.JULY);
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        System.out.println("Измененная дата: " + calendar.getTime());

        // Добавление дней
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        System.out.println("Дата после добавления 10 дней: " + calendar.getTime());
    }
}
