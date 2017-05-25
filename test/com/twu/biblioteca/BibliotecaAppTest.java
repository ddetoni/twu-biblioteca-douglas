package com.twu.biblioteca;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Customer;
import com.twu.biblioteca.domain.Librarian;
import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.services.AuthService;
import com.twu.biblioteca.services.DataService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {

    private DataService dataService;
    private AuthService authService;
    private BibliotecaApp bibApp;

    @Before
    public void setUp() throws FileNotFoundException {
        dataService = mock(DataService.class);
        authService = mock(AuthService.class);

        Customer customer = new Customer("ddetoni", "123", "Douglas Detoni", "ddetoni@thoughtworks.com", "05381452897");

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Cem anos de solidão", "Gabriel Garcia Marquez", "1967"));
        books.add(new Book("The Agile Samurai", "Jonathan Rasmusson", "2010"));
        books.get(1).setAvailability(false);
        books.get(1).setCustomer(customer);

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Matrix", "1999", "The Wachowski Brothers", "9"));
        movies.add(new Movie("Birdman", "2014", "Alejandro González Iñárritu", "9"));
        movies.get(1).setAvailability(false);


        when(dataService.loadBooks(anyString())).thenReturn(books);
        when(dataService.loadMovies(anyString())).thenReturn(movies);
        when(dataService.saveBooks(anyString(), eq(books))).thenReturn(true);

        when(authService.getLoggedUser()).thenReturn(customer);

        bibApp = new BibliotecaApp(dataService, authService);
    }

    @Test
    public void shouldReturnAnWelcomeMessage() throws FileNotFoundException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Customer user = new Customer("ddetoni", "", "", "", "");

        bibApp.welcome(user);

        assertEquals(outContent.toString(), "Hello ddetoni. Welcome to the Bangalore Public Library Management System. " +
                "You are authenticated as a CUSTOMER.\n");
    }

    @Test
    public void shouldAuthenticateTheUser() throws FileNotFoundException {

        ByteArrayInputStream in = new ByteArrayInputStream("123-4567\n1234\n".getBytes());
        System.setIn(in);

        AuthService authService = new AuthService();
        authService.loadData("data/users.txt");

        BibliotecaApp biblioteca = new BibliotecaApp(new DataService(authService), authService);

        assertNotNull(biblioteca.authentication());
    }

    @Test
    public void shouldChooseAFailOptionFromMenu() throws Exception {
        String input = "123\n";
        String output = getCustomerMenuOptions() +
                "Enter an option:\n" + "Select a valid option!\n";

        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheListBooksOption() throws Exception {
        String input = "1\n";
        String output = getCustomerMenuOptions() +
                "Enter an option:\n" +
                "\nID | Name | Author | Year | Status\n" +
                "0 | Cem anos de solidão | Gabriel Garcia Marquez | 1967\n";


        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheQuitOptionFromMenu() throws Exception {
        String input = "0\n";
        String output = getCustomerMenuOptions() +
                "Enter an option:\n" +
                "*** Bye! ***\n";

        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheCheckoutBookOptionFromMenu() throws Exception {
        String input = "2\n" +
                "0\n";
        String output = getCustomerMenuOptions() +
                "Enter an option:\n" +
                "Enter the book ID:\n" +
                "*** Thank you! Enjoy the book. ***\n";

        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheCheckoutBookOptionWithWrongID() throws Exception {
        String input = "2\n" +
                "1234\n";
        String output = getCustomerMenuOptions() +
                "Enter an option:\n" +
                "Enter the book ID:\n" +
                "*** That book is not available. ***\n";

        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheReturnBookOption() throws Exception {
        String input = "3\n" +
                "1\n";
        String output = getCustomerMenuOptions() +
                "Enter an option:\n" +
                "Enter the book ID:\n" +
                "*** Thank you for returning the book. ***\n";

        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheMyInfoOption() throws Exception {
        String input = "7\n";
        String output = getCustomerMenuOptions() +
                "Enter an option:\n" +
                "*** My Info ***\n" +
                "Name: Douglas Detoni\n" +
                "Email: ddetoni@thoughtworks.com\n" +
                "Phone Number: 05381452897\n";

        menuOption(input, output);
    }

    @Test
    public void shouldNotShowTheMyInfoOption() throws Exception {
        when(authService.getLoggedUser()).thenReturn(new Librarian("detoni", "123"));

        String input = "0\n";
        String output = getLibrarianMenuOptions() +
                "Enter an option:\n" +
                "*** Bye! ***\n";

        menuOption(input, output);
    }

    @Test
    public void shouldListAllMovies() throws Exception {
        String input = "4\n";
        String output = getCustomerMenuOptions() +
                "Enter an option:\n\n" +
                "ID | Name | Year | Director | Rating\n" +
                "0 | Matrix | 1999 | The Wachowski Brothers | 9\n";


        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheCheckoutMovieOption() throws Exception {
        String input = "5\n" +
                "0\n";
        String output = getCustomerMenuOptions() +
                "Enter an option:\n" +
                "Enter the movie ID:\n" +
                "*** Thank you! Enjoy the movie. ***\n";

        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheReturnMovieOption() throws Exception {
        String input = "6\n" +
                "1\n";
        String output = getCustomerMenuOptions() +
                "Enter an option:\n" +
                "Enter the movie ID:\n" +
                "*** Thank you for returning the movie. ***\n";

        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheBookCheckedOption() throws Exception {
        when(authService.getLoggedUser()).thenReturn(new Librarian("detoni", "123"));

        String input = "8\n";
        String output = getLibrarianMenuOptions() +
                "Enter an option:\n" +
                "ID | Title | Customer Name\n" +
                "1 | The Agile Samurai | Douglas Detoni\n";

        menuOption(input, output);
    }

    @Test
    public void shouldNotBeAbleToChooseTheCheckOutBookOptionAsALibrarian() throws Exception {
        when(authService.getLoggedUser()).thenReturn(new Librarian("detoni", "123"));

        String input = "2\n";
        String output = getLibrarianMenuOptions() +
                "Enter an option:\n" +
                "Select a valid option!\n";

        menuOption(input, output);

    }

    @Test
    public void shouldNotBeAbleToChooseTheReturnBookOptionAsALibrarian() throws Exception {
        when(authService.getLoggedUser()).thenReturn(new Librarian("detoni", "123"));

        String input = "3\n";
        String output = getLibrarianMenuOptions() +
                "Enter an option:\n" +
                "Select a valid option!\n";

        menuOption(input, output);

    }

    @Test
    public void shouldNotBeAbleToChooseTheCheckOutMovieOptionAsALibrarian() throws Exception {
        when(authService.getLoggedUser()).thenReturn(new Librarian("detoni", "123"));

        String input = "5\n";
        String output = getLibrarianMenuOptions() +
                "Enter an option:\n" +
                "Select a valid option!\n";

        menuOption(input, output);

    }

    @Test
    public void shouldNotBeAbleToChooseTheReturnMovieOptionAsALibrarian() throws Exception {
        when(authService.getLoggedUser()).thenReturn(new Librarian("detoni", "123"));

        String input = "6\n";
        String output = getLibrarianMenuOptions() +
                "Enter an option:\n" +
                "Select a valid option!\n";

        menuOption(input, output);

    }

    @Test
    public void shouldNotBePossibleToCheckOutACheckedBook() throws Exception {
        String input = "2\n" +
                "1\n";
        String output = getCustomerMenuOptions() +
                "Enter an option:\n" +
                "Enter the book ID:\n" +
                "*** That book is not available. ***\n";

        menuOption(input, output);
    }

    @Test
    public void shouldNotBePossibleToReturnANotCheckedBook() throws Exception {
        String input = "3\n" +
                "0\n";
        String output = getCustomerMenuOptions() +
                "Enter an option:\n" +
                "Enter the book ID:\n" +
                "*** That is not a valid book to return. ***\n";

        menuOption(input, output);
    }

    @Test
    public void shouldNotBePossibleToCheckOutACheckedMovie() throws Exception {
        String input = "5\n" +
                "1\n";
        String output = getCustomerMenuOptions() +
                "Enter an option:\n" +
                "Enter the movie ID:\n" +
                "*** That movie is not available. ***\n";

        menuOption(input, output);
    }

    @Test
    public void shouldNotBePossibleToReturnANotCheckedMovie() throws Exception {
        String input = "6\n" +
                "0\n";
        String output = getCustomerMenuOptions() +
                "Enter an option:\n" +
                "Enter the movie ID:\n" +
                "*** That is not a valid movie to return. ***\n";

        menuOption(input, output);
    }

    private void menuOption(String input, String output) throws Exception {

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bibApp.menu();

        assertEquals(outContent.toString(), output);
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

}
