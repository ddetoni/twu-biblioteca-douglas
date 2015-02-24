package com.twu.biblioteca;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;


public class LibraryTest {

    private String booksPath = "data/books_test.txt";;

    @Test
    public void shouldCreateALibrary() {
        assertNotNull(new Library(this.booksPath));
    }

    @Test(expected = FileNotFoundException.class)
    public void shouldLoadBookData() throws FileNotFoundException {
        new Library("data/cars.txt").loadBookData();
    }

    @Test
    public void shouldReturnTheTotalOfBooksLoaded() throws FileNotFoundException {
        assertEquals(new Library(this.booksPath).loadBookData(), 2);
    }

    @Test
    public void shouldPrintTheWholeBookList() throws FileNotFoundException {
        Library lib = new Library(this.booksPath);
        lib.loadBookData();

        assertEquals(lib.allBooks(),
                "\nID | Name | Author | Year | Status\n" +
                "0 | Cem anos de solidão | Gabriel Garcia Marquez | 1967\n");

    }

    @Test
    public void shouldReturnABookByID() throws FileNotFoundException {
        Library lib = new Library(this.booksPath);
        lib.loadBookData();

        assertEquals(lib.getBook(1).getClass(), Book.class);
    }

    @Test
    public void shouldCheckOutABookByID() throws Exception {
        Library lib = new Library(this.booksPath);
        lib.loadBookData();

        assertTrue(lib.checkoutBook(0));
    }

    @Test
    public void shoudlReturnABookByID() throws Exception {
        Library lib = new Library(this.booksPath);
        lib.loadBookData();
        lib.getBook(0).checkoutBook();

        assertTrue(lib.returnBook(0));
    }

    @Test
    public void shouldAddANewBook() throws FileNotFoundException {
        Library lib = new Library(this.booksPath);
        lib.loadBookData();

        assertTrue(lib.addBook("Book 1", "D.D.", "2015", "false"));
    }

    @Test
    public void shouldSaveTheDataInTheFile() throws FileNotFoundException, UnsupportedEncodingException {
        Library lib = new Library("data/books1_test.txt");

        lib.addBook("Book 1", "D.D.", "2015", "true");

        assertTrue(lib.saveData());

    }


}
