package org.demo.seminar06_20240610.code.bibliotheks.classWork;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Program {
    public static void main(String[] args) throws Exception {

        ArrayList<Book> books = new ArrayList<>();
        Random random = new Random(0);
        for (int i = 0; i < 10; i++) {
            books.add(
                    new Book.BookBuilder()
                            .setIsbn("123-4123-1231")
                            .setAuthor("Какой-то автор " + String.valueOf(i + 1))
                            .setTitle("Какое-то название " + String.valueOf(i + 1))
                            .setYear(random.nextInt(1900, 2000))
                            .build());
        }

        System.out.println(books);
        System.out.println();
        // Collections.sort(books);
        // Начать с отдельного класса
        books.sort(new BookSortByYear());

        // Реализация через анонимный класс
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.year == o2.year)
                    return 0;
                else if (o1.year < o2.year)
                    return -1;
                else
                    return 1;
            }
        });

        // Реализация через лямбда-выражение
        books.sort((o1, o2) -> {
            if (o1.year == o2.year)
                return 0;
            else if (o1.year < o2.year)
                return -1;
            else
                return 1;
        });
        // Реализация через лямбда-выражение
        // с использованием Integer.compare
        books.sort((o1, o2) -> Integer.compare(o1.year, o2.year));

        System.out.println(books);

        // Работает если Book реализует Comparable<Book>
        // var tempBool = books.toArray();
        // System.out.println(Arrays.toString(tempBool));
        // Arrays.sort(tempBool);
        // System.out.println();
        // System.out.println(Arrays.toString(tempBool));
    }
}
