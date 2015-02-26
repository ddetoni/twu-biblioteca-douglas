package com.twu.biblioteca;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    private String booksPath;
    private ArrayList<Book> books;

    public Library(String path) {
        this.booksPath = path;
        this.books = new ArrayList<Book>();
    }

    public int loadBookData() throws FileNotFoundException {

        Scanner fileScanner = new Scanner(new File(this.booksPath));

        parseData(fileScanner);

        return this.books.size();
    }

    private void parseData(Scanner fileScanner) {
        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String [] splitedLine = line.split(":");

            addBook(splitedLine[0], splitedLine[1], splitedLine[2], splitedLine[3]);
        }
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

    public boolean saveData() throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter(this.booksPath);

        for(int i=0; i < this.books.size(); i++) {
            ArrayList<String> details = this.books.get(i).getArrayDetails();
            writer.println(details.get(0) + ":" + details.get(1) + ":" + details.get(2) + ":" + details.get(3));
        }

        writer.close();
        return true;
    }
}
