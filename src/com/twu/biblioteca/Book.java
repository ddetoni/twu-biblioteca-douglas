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

    @Override
    public String getDetailsSeparatedBy(String separator, boolean showAvailability) {

        if(showAvailability) {
            if(isAvailable()) {
                return this.name + separator + this.author + separator + this.year + separator + isAvailable();
            } else {
                return this.name + separator + this.author + separator + this.year + separator + isAvailable() + separator + super.checkedOutBy().getIdentifier();
            }

        } else {
            return this.name + separator + this.author + separator + this.year;
        }
    }

    public String getName() {
        return name;
    }
}
