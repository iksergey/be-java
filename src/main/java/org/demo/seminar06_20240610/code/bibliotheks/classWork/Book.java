package org.demo.seminar06_20240610.code.bibliotheks.classWork;

public class Book implements Comparable<Book> {
    static class BookBuilder {
        private Book instance;
        private boolean flag;

        public BookBuilder() {
            instance = new Book();
            flag = false;
        }

        public BookBuilder setTitle(String title) {
            instance.title = title;
            flag = true;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            instance.author = author;
            return this;
        }

        public BookBuilder setYear(int year) {
            instance.year = year;
            return this;
        }

        public BookBuilder setIsbn(String isbn) {
            instance.isbn = isbn;
            return this;
        }

        public Book build() throws Exception {
            if (!flag)
                throw new Exception("У вас не указано название");
            return instance;
        }
    }

    public String title;
    public String author;
    public int year;
    public String isbn;

    private Book() {
        this.title = "";
        this.author = "";
        this.year = 0;
        this.isbn = "";
    }

    @Override
    public String toString() {

        return String.format("[%s %s %d %s]",
                this.title,
                this.author,
                this.year,
                this.isbn).trim();
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.year, o.year);
    }
}
