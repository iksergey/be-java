package org.demo.seminar06_20240610.code.bibliotheks;

import java.util.ArrayList;

public class LibraryRepository implements Repository {
    private ArrayList<Book> books;

    public LibraryRepository() {
        this.books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBookByISBN(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    @Override
    public ArrayList<Book> findBookByTitle(String title) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public ArrayList<Book> findBookByAuthor(String author) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
