package org.demo.seminar01_20240521.code;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Example01 {

    public static void main(String[] args) {
        hello();
        print("какой-то текст");

        String value = getDateAndTime();
        String sumToText = getSumText(1, 2);

        System.out.printf("%s%n", value);
        System.out.printf("%s%n", sumToText);
    }

    public static void hello() {

        System.out.println("hello");
    }

    public static void print(String text) {

        System.out.printf("hello %s\n", text);
    }

    public static String getDateAndTime() {
        // Получаем текущую дату и время с использованием LocalDateTime
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Определяем формат для вывода даты и времени
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Форматируем дату и время согласно заданному формату
        return currentDateTime.format(formatter);
    }

    public static String getSumText(int x, int y) {
        int sum = x + y;
        return String.format("%d + %d = %d", x, y, sum);
    }
}