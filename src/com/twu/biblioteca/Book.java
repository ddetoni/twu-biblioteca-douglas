package com.twu.biblioteca;


public class Book extends Item {

    private String year;
    private String author;
    private String name;

    public Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getDetails(String separator, boolean showAvailability) {

        if(showAvailability) {
            return this.name + separator + this.author + separator + this.year + separator + isAvailable();
        } else {
            return this.name + separator + this.author + separator + this.year;
        }
    }
}
