package com.twu.biblioteca;


import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {

    @Test
    public void shouldReturnAnWelcomeMessage() throws FileNotFoundException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Customer user = new Customer("ddetoni");

        new BibliotecaApp().welcome(user);

        assertEquals(outContent.toString(), "Hello ddetoni. Welcome to the Bangalore Public Library Management System. " +
                "You are authenticated as a CUSTOMER.\n");
    }

    @Test
    public void shouldAuthenticateTheUser() throws FileNotFoundException {
        BibliotecaApp bibApp = new BibliotecaApp();

        ByteArrayInputStream in = new ByteArrayInputStream("ddetoni\n1234\n".getBytes());
        System.setIn(in);

        assertNotNull(bibApp.authentication());
    }

    @Test
    public void shouldChooseAFailOptionFromMenu() throws Exception {
        String input = "123\n";
        String output = getMenuOptions() +
                "Enter an option:\n" + "Select a valid option!\n";

        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheListBooksOption() throws Exception {
        String input = "1\n";
        String output = getMenuOptions() +
                "Enter an option:\n" +
                "\nID | Name | Author | Year | Status\n" +
                "0 | Cem anos de solidão | Gabriel Garcia Marquez | 1967\n";


        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheQuitOptionFromMenu() throws Exception {
        String input = "0\n";
        String output = getMenuOptions() +
                "Enter an option:\n" +
                "*** Bye! ***\n";

        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheCheckoutBookOptionFromMenu() throws Exception {
        String input = "2\n" +
                "0\n";
        String output = getMenuOptions() +
                "Enter an option:\n" +
                "Enter the book ID:\n" +
                "*** Thank you! Enjoy the book. ***\n";

        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheCheckoutBookOptionWithWrongID() throws Exception {
        String input = "2\n" +
                "1234\n";
        String output = getMenuOptions() +
                "Enter an option:\n" +
                "Enter the book ID:\n" +
                "*** That book is not available. ***\n";

        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheReturnBookOption() throws Exception {
        String input = "3\n" +
                "1\n";
        String output = getMenuOptions() +
                "Enter an option:\n" +
                "Enter the book ID:\n" +
                "*** Thank you for returning the book. ***\n";

        menuOption(input, output);
    }

    private void menuOption(String input, String output) throws Exception {
        BibliotecaApp bibApp = new BibliotecaApp();

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bibApp.menu();

        assertEquals(outContent.toString(), output);
    }

    private String getMenuOptions() {
        return "\nOptions:\n" +
                "\t1 - List of all books.\n" +
                "\t2 - Check-out book.\n" +
                "\t3 - Return book.\n" +
                "\t0 - Quit\n";
    }

}
