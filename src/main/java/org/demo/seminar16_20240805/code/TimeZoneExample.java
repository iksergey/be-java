package org.demo.seminar16_20240805.code;

import java.time.ZonedDateTime;
import java.util.Set;
import java.time.ZoneId;

public class TimeZoneExample {
    public static void main(String[] args) {

        Set<String> allZones = ZoneId.getAvailableZoneIds();
        allZones.stream().sorted().forEach(System.out::println);
        System.out.println("---------");

        ZonedDateTime pragueTime = ZonedDateTime.now(ZoneId.of("Europe/Prague"));
        System.out.println("Текущая дата и время в Праге: " + pragueTime);

        // Текущая дата и время в Нью-Йорке
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Текущая дата и время в Нью-Йорке: " + newYorkTime);

        // Перевод времени из одной временной зоны в другую
        ZonedDateTime convertedTime = pragueTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Время в Праге, переведенное в Нью-Йорк: " + convertedTime);
    }
}
