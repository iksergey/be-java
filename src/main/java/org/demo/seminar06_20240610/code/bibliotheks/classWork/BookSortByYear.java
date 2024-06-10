package org.demo.seminar06_20240610.code.bibliotheks.classWork;

import java.util.Comparator;

public class BookSortByYear implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        if (o1.year == o2.year)
            return 0;
        else if (o1.year < o2.year)
            return -1;
        else
            return 1;
    }
}
