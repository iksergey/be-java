package org.demo.seminar06_20240610.code.bibliotheks;

public class PrintedBook extends Book {
    private int pages;
    private String bindingType;

    public PrintedBook(String title, String author, int year, String isbn, int pages, String bindingType) {
        super(title, author, year, isbn);
        this.pages = pages;
        this.bindingType = bindingType;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }

    @Override
    public String toString() {
        return super.toString() +
                " pages: " + pages +
                " bindingType: " + bindingType;
    }
}
