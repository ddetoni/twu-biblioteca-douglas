package com.twu.biblioteca;


import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public boolean addBook(String name, String author, String year, String statusText) {
        boolean status = statusText.equals("true") ? true : false;

        return this.books.add(new Book(name, author, year, status));
    }

    public String allBooks() {
        String allBooks = "\nID | Name | Author | Year | Status\n";

        for(int i=0; i < this.books.size(); i++) {
            Book book = this.books.get(i);
            if(book.isAvaliable()) {
                allBooks += i + " | " + book.getDetails(" | ", false) + "\n";
            }
        }

        return allBooks;
    }

    public Book getBook(int id) {
        try {
            return this.books.get(id);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("*** That book is not available. ***\n");
            return null;
        }
    }

    public boolean checkoutBook(int id) throws Exception {
        Book book;
        try {
            book = this.books.get(id);
            book.checkoutBook();

            System.out.print("*** Thank you! Enjoy the book. ***\n");
            return true;
        } catch (Exception e) {
            System.out.print("*** That book is not available. ***\n");
            return false;
        }
    }

    public boolean returnBook(int id) throws Exception {
        Book book;
        try {
            book = this.books.get(id);
            book.returnBook();

            System.out.print("*** Thank you for returning the book. ***\n");
            return true;
        } catch (Exception e) {
            System.out.print("*** That is not a valid book to return. ***\n");
            return false;
        }
    }

    public int totalOfBooks() {
        return this.books.size();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
