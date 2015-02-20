package com.twu.biblioteca;


public class Book {

    private boolean status;
    private String year;
    private String author;
    private String name;

    public Book(String name, String author, String year, boolean status) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.status = status;
    }

    public String getDetails() {
        return this.name + " | " + this.author + " | " + this.year;
    }

    public boolean isAvaliable() {
        return this.status;
    }

    public void checkoutBook() throws Exception {
        if(this.status) {
            this.status = false;
        } else throw new Exception("Book was already checkout.");

    }

    public void returnBook() throws Exception {
        if(!this.status) {
            this.status = true;
        } else throw new Exception("Book was not checkout.");

    }
}
