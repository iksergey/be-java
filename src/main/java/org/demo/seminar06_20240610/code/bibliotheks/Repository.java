package org.demo.seminar06_20240610.code.bibliotheks;

import java.util.ArrayList;

public interface Repository {
    void addBook(Book book);

    void removeBookByISBN(String isbn);

    ArrayList<Book> findBookByTitle(String title);

    ArrayList<Book> findBookByAuthor(String author);

    ArrayList<Book> getAllBooks();
}
