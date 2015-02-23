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
        assertEquals(new BibliotecaApp().welcome(), "Hello.");
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
                "Name | Author | Year | Status\n" +
                "Cem anos de solidão | Gabriel Garcia Marquez | 1967 | Avaliable\n" +
                "The Agile Samurai | Jonathan Rasmusson | 2010 | Avaliable\n";


        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheQuitOptionFromMenu() throws Exception {
        String input = "0\n";
        String output = getMenuOptions() +
                "Enter an option:\n" +
                "Bye!\n";

        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheCheckoutBookOptionFromMenu() throws Exception {
        String input = "2\n" +
                "1\n";
        String output = getMenuOptions() +
                "Enter an option:\n" +
                "Enter the book ID:\n" +
                "Thank you! Enjoy the book.\n";

        menuOption(input, output);
    }

    @Test
    public void shouldChooseTheCheckoutBookOptionWithWrongID() throws Exception {
        String input = "2\n" +
                "1234\n";
        String output = getMenuOptions() +
                "Enter an option:\n" +
                "Enter the book ID:\n" +
                "That book is not available.\n";

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
        return "Options:\n" +
                "\t1 - List of all books.\n" +
                "\t2 - Check-out book.\n" +
                "\t0 - Quit\n";
    }

}
