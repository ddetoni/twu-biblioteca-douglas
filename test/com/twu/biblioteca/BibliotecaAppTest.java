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
    public void shouldChooseAFailOptionFromMenu() throws FileNotFoundException {
        BibliotecaApp bibApp = new BibliotecaApp();

        ByteArrayInputStream in = new ByteArrayInputStream("123\n".getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bibApp.menu();

        assertEquals(outContent.toString(),
                "Enter an option:\n" + "Select a valid option!\n");
    }

    @Test
    public void shouldChooseTheListBooksOption() throws FileNotFoundException {
        BibliotecaApp bibApp = new BibliotecaApp();

        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bibApp.menu();

        assertEquals(outContent.toString(),
                "Enter an option:\n" +
                        "Name | Author | Year | Status\n" +
                        "Cem anos de solidão | Gabriel Garcia Marquez | 1967 | Avaliable\n" +
                        "The Agile Samurai | Jonathan Rasmusson | 2010 | Avaliable\n"
        );

    }
}
