package com.twu.biblioteca;


import java.util.ArrayList;

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

    public String getDetails(String separator, boolean showAvailability) {

        if(showAvailability) {
            return this.name + separator + this.author + separator + this.year + separator + this.status;
        } else {
            return this.name + separator + this.author + separator + this.year;
        }
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

    public ArrayList<String> getArrayDetails() {
        ArrayList<String> details = new ArrayList<String>();

        details.add(this.name);
        details.add(this.author);
        details.add(this.year);
        details.add( (this.status ? "true" : "false") );

        return details;
    }
}
