package com.twu.biblioteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class DataService {

    private AuthService authService;

    public DataService(AuthService authService) {
        this.authService = authService;
    }

    public ArrayList<Book> loadBooks(String path) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(path));
        ArrayList<Book> books = new ArrayList<Book>();

        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String [] splitedLine = line.split(":");
            User user = null;

            boolean availability = (splitedLine[3]).equals("true");

            if(splitedLine.length > 4) {
                user = authService.getUserByIdentifier(splitedLine[4]);
            }


            Book book = new Book(splitedLine[0], splitedLine[1], splitedLine[2]);
            book.setAvailability(availability);
            book.setCustomer((Customer) user);

            books.add(book);
        }

        return books;
    }

    public boolean saveBooks(String path, ArrayList<Book> content) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(path);

        for(Book book: content) {
            writer.println(book.getDetailsSeparatedBy(":", true));
        }
        writer.close();

        return true;
    }

    public ArrayList<Movie> loadMovies(String path) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(path));
        ArrayList<Movie> movies = new ArrayList<Movie>();

        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String [] splitedLine = line.split(":");

            boolean availability = (splitedLine[4]).equals("true");

            Movie movie = new Movie(splitedLine[0], splitedLine[1], splitedLine[2], splitedLine[3]);
            movie.setAvailability(availability);

            movies.add(movie);
        }

        return movies;
    }

    public boolean saveMovies(String path, ArrayList<Movie> content) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(path);

        for(Movie movie: content) {
            writer.println(movie.getDetailsSeparatedBy(":", true));
        }
        writer.close();

        return true;
    }
}
