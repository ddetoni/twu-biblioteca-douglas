package com.twu.biblioteca;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Customer;
import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.domain.User;
import com.twu.biblioteca.services.AuthService;
import com.twu.biblioteca.services.DataService;

public class BibliotecaApp {

    private DataService dataService;
    private AuthService authService;
    private Library lib;

    public static void main(String[] args) throws Exception {
        AuthService authService = new AuthService();
        DataService dataService = new DataService(authService);
        authService.loadData("data/users.txt");

        BibliotecaApp bibApp = new BibliotecaApp(dataService, authService);

        User loggedUser = bibApp.authentication();

        if (loggedUser != null) {
            bibApp.welcome(loggedUser);
            while (bibApp.menu()) {
            }
        }


    }

    BibliotecaApp(DataService dataService, AuthService authService) throws FileNotFoundException {
        this.authService = authService;
        this.dataService = dataService;

        ArrayList<Book> books = dataService.loadBooks("data/books.txt");
        ArrayList<Movie> movies = dataService.loadMovies("data/movies.txt");
        this.lib = new Library(books, movies);
    }

    void welcome(User loggedUser) {
        print("Hello " + loggedUser.getIdentifier() + ". Welcome to the Bangalore Public Library Management System. " +
                "You are authenticated as a " + loggedUser.getRole().toUpperCase() + ".\n");
    }

    User authentication() throws FileNotFoundException {
        Scanner reader = new Scanner(System.in);

        print("Enter the identifier: \n");
        String username = reader.next();

        print("Enter the password: \n");
        String password = reader.next();

        this.authService.login(username, password);

        return this.authService.getLoggedUser();
    }

    boolean menu() throws Exception {
        User loggedUser = authService.getLoggedUser();

        Scanner reader = new Scanner(System.in);
        Integer id;

        if (isCustomer(loggedUser)) {
            print(getCustomerMenuOptions());
        } else {
            print(getLibrarianMenuOptions());
        }


        print("Enter an option:\n");
        Integer option = reader.nextInt();

        switch (option) {
            case 0:
                quitOption();
                return false;

            case 1:
                listBooksOption();
                break;

            case 2:
                if (isCustomer(loggedUser)) {
                    checkoutBookOption(reader, (Customer) loggedUser);
                } else {
                    print("Select a valid option!\n");
                }
                break;

            case 3:
                if (isCustomer(loggedUser)) {
                    returnBookOption(reader);
                } else {
                    print("Select a valid option!\n");
                }

                break;

            case 4:
                print(lib.allMovies());

                break;
            case 5:
                if (isCustomer(loggedUser)) {
                    checkoutMovieOption((Customer) loggedUser, reader);
                } else {
                    print("Select a valid option!\n");
                }

                break;

            case 6:
                if (isCustomer(loggedUser)) {
                    returnMovieOption(reader);
                } else {
                    print("Select a valid option!\n");
                }

                break;

            case 7:
                myInfoOption(loggedUser);
                break;

            case 8:

                if (loggedUser.getRole().equals("librarian")) {
                    print(lib.checkedOutBooks());
                } else {
                    print("Select a valid option!\n");
                }

                break;

            default:
                print("Select a valid option!\n");
        }
        return true;
    }

    private void returnMovieOption(Scanner reader) {
        Integer id;
        print("Enter the movie ID:\n");
        id = reader.nextInt();

        this.lib.returnMovie(id);
    }

    private void checkoutMovieOption(Customer loggedUser, Scanner reader) {
        Integer id;
        print("Enter the movie ID:\n");
        id = reader.nextInt();

        this.lib.checkoutMovie(id, loggedUser);
    }

    private void quitOption() throws FileNotFoundException {
        dataService.saveBooks("data/books.txt", lib.getBooks());
        print("*** Bye! ***\n");
    }

    private void listBooksOption() {
        print(this.lib.allBooks());
    }

    private void checkoutBookOption(Scanner reader, Customer customer) throws Exception {
        Integer id;
        print("Enter the book ID:\n");
        id = reader.nextInt();

        this.lib.checkoutBook(id, customer);
    }

    private void returnBookOption(Scanner reader) throws Exception {
        Integer id;
        print("Enter the book ID:\n");
        id = reader.nextInt();

        this.lib.returnBook(id);
    }

    private void myInfoOption(User loggedUser) {
        if (isCustomer(loggedUser)) {
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
                "\t4 - List of all movies.\n" +
                "\t8 - Books checked out.\n" +
                "\t0 - Quit\n";
    }

    private void print(String text) {
        System.out.print(text);
    }
}
