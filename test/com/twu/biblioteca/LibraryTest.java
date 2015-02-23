package com.twu.biblioteca;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;


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

        assertEquals(lib.allBooks(),
                "Name | Author | Year | Status\n" +
                "Cem anos de solidão | Gabriel Garcia Marquez | 1967 | Avaliable\n" +
                "The Agile Samurai | Jonathan Rasmusson | 2010 | Not Avaliable\n");

    }

    @Test
    public void shouldReturnABookByID() throws FileNotFoundException {
        Library lib = new Library("data/books.txt");
        lib.loadBookData();

        assertEquals(lib.getBook(1).getClass(), Book.class);
    }

    @Test
    public void shouldCheckOutABookByID() throws Exception {
        Library lib = new Library("data/books.txt");
        lib.loadBookData();

        assertTrue(lib.checkoutBook(0));
    }

    @Test
    public void shoudlReturnABookByID() throws Exception {
        Library lib = new Library("data/books.txt");
        lib.loadBookData();
        lib.getBook(0).checkoutBook();

        assertTrue(lib.returnBook(0));
    }

    @Test
    public void shouldAddANewBook() throws FileNotFoundException {
        Library lib = new Library("data/books.txt");
        lib.loadBookData();

        assertTrue(lib.addBook("Book 1", "D.D.", "2015", "false"));
    }


}
