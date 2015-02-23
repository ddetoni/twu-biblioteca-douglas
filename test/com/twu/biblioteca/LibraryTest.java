package com.twu.biblioteca;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class LibraryTest {

    @Test
    public void shouldCreateALibrary() {
        assertNotNull(new Library("data/books.txt"));
    }

    @Test(expected = FileNotFoundException.class)
    public void shouldLoadBookData() throws FileNotFoundException {
        new Library("data/cars.txt").loadBookData();
    }

    @Test
    public void shouldReturnTheTotalOfBooksLoaded() throws FileNotFoundException {
        assertEquals(new Library("data/books.txt").loadBookData(), 2);
    }

    @Test
    public void shouldPrintTheWholeBookList() throws FileNotFoundException {
        Library lib = new Library("data/books.txt");
        lib.loadBookData();

        assertEquals(lib.printAllBooks(),
                "Name | Author | Year | Status\n" +
                "Cem anos de solidão | Gabriel Garcia Marquez | 1967 | Free\n" +
                "The Agile Samurai | Jonathan Rasmusson | 2010 | Free\n");

    }
}
