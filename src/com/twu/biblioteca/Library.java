package com.twu.biblioteca;


import java.io.File;
import java.io.FileNotFoundException;
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

            addBook(splitedLine[0], splitedLine[1], splitedLine[2]);
        }
    }

    private void addBook(String name, String author, String year) {
        this.books.add(new Book(name, author, year, true));
    }
}
