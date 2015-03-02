package com.twu.biblioteca;


import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Movie> movies;

    public Library(ArrayList<Book> books, ArrayList<Movie> movies) {
        this.books = books;
        this.movies = movies;
    }

    public boolean addBook(String name, String author, String year) {
        return this.books.add(new Book(name, author, year));
    }

    public String allBooks() {
        String allBooks = "\nID | Name | Author | Year | Status\n";

        for(int i=0; i < this.books.size(); i++) {
            Book book = this.books.get(i);
            if(book.isAvailable()) {
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
            book.setAvailability(false);

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
            book.setAvailability(true);

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

    public String allMovies() {
        String allMovies = "\nID | Name | Year | Director | Rating\n";
        Integer count = 0;

        for(Movie movie : movies) {
            if (movie.isAvailable()) {
                allMovies += count++ + " | " + movie.getDetailsSeparatedBy(" | ") + "\n";
            }
        }

        return allMovies;
    }
}
