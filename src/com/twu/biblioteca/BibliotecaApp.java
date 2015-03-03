package com.twu.biblioteca;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private DataService dataService;
    private AuthService authService;
    private Library lib;

    public static void main(String[] args) throws Exception {
        DataService dataService = new DataService();
        AuthService authService = new AuthService("");
        authService.loadData("data/users.txt");

        BibliotecaApp bibApp = new BibliotecaApp(dataService, authService);

        User loggedUser = bibApp.authentication();

        if(loggedUser != null) {
            bibApp.welcome(loggedUser);
            while(bibApp.menu()) {}
        }

    }

    public BibliotecaApp(DataService dataService, AuthService authService) throws FileNotFoundException {
        this.authService = authService;
        this.dataService = dataService;

        ArrayList<Book> books = dataService.loadBooks("data/books.txt");
        ArrayList<Movie> movies = dataService.loadMovies("data/movies.txt");
        this.lib = new Library(books, movies);
    }

    public void welcome(User loggedUser) {
        print("Hello " + loggedUser.getIdentifier() + ". Welcome to the Bangalore Public Library Management System. " +
                "You are authenticated as a " + loggedUser.getRole().toUpperCase() +".\n");
    }

    public User authentication() throws FileNotFoundException {
        Scanner reader = new Scanner(System.in);

        print("Enter the identifier: \n");
        String username = reader.next();

        print("Enter the password: \n");
        String password = reader.next();

        this.authService.login(username, password);

        return this.authService.getLoggedUser();
    }

    public boolean menu() throws Exception {
        User loggedUser = authService.getLoggedUser();

        Scanner reader = new Scanner(System.in);
        Integer id;

        if(isCustomer(loggedUser)) {
            print(getCustomerMenuOptions());
        } else {
            print(getLibrarianMenuOptions());
        }


        print("Enter an option:\n");
        Integer option = reader.nextInt();

        switch(option)
        {
            case 0:
                quitOption();
                return false;

            case 1:
                listBooksOption();
                break;

            case 2:
                checkoutBookOption(reader);
                break;

            case 3:
                returnBookOption(reader);
                break;

            case 4:
                print(lib.allMovies());

                break;
            case 5:
                print("Enter the movie ID:\n");
                id = reader.nextInt();

                this.lib.checkoutMovie(id);
                break;

            case 6:
                print("Enter the movie ID:\n");
                id = reader.nextInt();

                this.lib.returnMovie(id);
                break;

            case 7:
                myInfoOption(loggedUser);
                break;

            default:
                print("Select a valid option!\n");
        }
        return true;
    }

    private void quitOption() throws FileNotFoundException {
        dataService.save("data/books.txt", lib.getBooks());
        print("*** Bye! ***\n");
    }

    private void listBooksOption() {
        print(this.lib.allBooks());
    }

    private void checkoutBookOption(Scanner reader) throws Exception {
        Integer id;
        print("Enter the book ID:\n");
        id = reader.nextInt();

        this.lib.checkoutBook(id);
    }

    private void returnBookOption(Scanner reader) throws Exception {
        Integer id;
        print("Enter the book ID:\n");
        id = reader.nextInt();

        this.lib.returnBook(id);
    }

    private void myInfoOption(User loggedUser) {
        if(isCustomer(loggedUser)) {
            print("*** My Info ***\n");
            Customer loggedCustomer = (Customer) loggedUser;

            print(loggedCustomer.getMyInfo());
        } else {
            print("Select a valid option!\n");
        }
    }

    private boolean isCustomer(User loggedUser) {
        return loggedUser.getRole().equals("customer");
    }

    private String getCustomerMenuOptions() {
        return "\nOptions:\n" +
                "\t1 - List of all books.\n" +
                "\t2 - Check-out book.\n" +
                "\t3 - Return book.\n" +
                "\t4 - List of all movies.\n" +
                "\t5 - Check-out movie.\n" +
                "\t6 - Return movie.\n" +
                "\t7 - My Info.\n" +
                "\t0 - Quit\n";
    }

    private String getLibrarianMenuOptions() {
        return "\nOptions:\n" +
                "\t1 - List of all books.\n" +
                "\t2 - Check-out book.\n" +
                "\t3 - Return book.\n" +
                "\t5 - Check-out movie.\n" +
                "\t6 - Return movie.\n" +
                "\t0 - Quit\n";
    }

    private void print(String text) {
        System.out.print(text);
    }
}
