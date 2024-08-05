package org.demo.seminar16_20240805.code;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExamples {
    public static void main(String[] args) {
        Date currentDate = new Date();

        // Полная дата и время
        SimpleDateFormat fullFormatter = new SimpleDateFormat("EEEE, dd MMMM, yyyy HH:mm:ss.SSS z");
        System.out.println("Полная дата и время: " + fullFormatter.format(currentDate));

        // Только дата
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Только дата: " + dateFormatter.format(currentDate));

        // Только время
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Только время: " + timeFormatter.format(currentDate));

        // День недели, месяц, день и год
        SimpleDateFormat dayMonthYearFormatter = new SimpleDateFormat("E, MMM dd yyyy");
        System.out.println("День недели, месяц, день и год: " + dayMonthYearFormatter.format(currentDate));

        // Часы, минуты, секунды и AM/PM
        SimpleDateFormat timeAmPmFormatter = new SimpleDateFormat("hh:mm:ss a");
        System.out.println("Часы, минуты, секунды и AM/PM: " + timeAmPmFormatter.format(currentDate));

        // Часовой пояс
        SimpleDateFormat timeZoneFormatter = new SimpleDateFormat("Z");
        System.out.println("Часовой пояс: " + timeZoneFormatter.format(currentDate));

        // ISO 8601 формат с часовым поясом
        SimpleDateFormat isoFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        System.out.println("ISO 8601 формат с часовым поясом: " + isoFormatter.format(currentDate));
    }
}
