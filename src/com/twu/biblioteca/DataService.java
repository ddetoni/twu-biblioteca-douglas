package com.twu.biblioteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class DataService {

    public ArrayList<Book> load(String path) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(path));
        ArrayList<Book> books = new ArrayList<Book>();

        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String [] splitedLine = line.split(":");

            boolean avaliability = (splitedLine[3]).equals("true") ? true : false;

            books.add(new Book(splitedLine[0], splitedLine[1], splitedLine[2], avaliability));
        }

        return books;
    }

    public boolean save(String path, ArrayList<Book> content) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(path);

        for(Book book: content) {
            writer.println(book.getDetails(":", true));
        }
        writer.close();

        return true;
    }
}
