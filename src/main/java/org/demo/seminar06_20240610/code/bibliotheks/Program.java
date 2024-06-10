package org.demo.seminar06_20240610.code.bibliotheks;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Repository library = new LibraryRepository();

        library.addBook(new Book("Война и мир", "Лев Толстой", 1869, "1234567890"));
        library.addBook(new EBook("Мастер и Маргарита", "Михаил Булгаков", 1966, "2345678901", "EPUB", 2.5));
        library.addBook(new PrintedBook("Преступление и наказание", "Фёдор Достоевский", 1866, "3456789012", 672, "Твёрдый переплёт"));

        library.removeBookByISBN("2345678901");

        ArrayList<Book> foundBooksByTitle = library.findBookByTitle("Война и мир");
        for (Book book : foundBooksByTitle) {
            System.out.println(book);
        }

        System.out.println();

        ArrayList<Book> foundBooksByAuthor = library.findBookByAuthor("Фёдор Достоевский");
        for (Book book : foundBooksByAuthor) {
            System.out.println(book);
        }

        System.out.println();
        
        ArrayList<Book> allBooks = library.getAllBooks();
        for (Book book : allBooks) {
            System.out.println(book);
        }
    }
}