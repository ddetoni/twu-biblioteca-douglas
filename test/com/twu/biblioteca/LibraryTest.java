package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class LibraryTest {

    private ArrayList<Book> books;
    private Library lib;

    @Before
    public void setUp() {
        books = new ArrayList<Book>();
        Book book = new Book("Book 1", "D.D.", "2015", true);

        books.add(book);

        lib = new Library(books);
    }

    @Test
    public void shouldCreateALibrary() {
        assertNotNull(lib);
    }

    @Test
    public void shouldReturnTheTotalOfBooksLoaded() throws FileNotFoundException {
        assertEquals(lib.totalOfBooks(), 1);
    }

    @Test
    public void shouldPrintTheWholeBookList() throws FileNotFoundException {
        assertEquals(lib.allBooks(),
                "\nID | Name | Author | Year | Status\n" +
                "0 | Book 1 | D.D. | 2015\n");

    }

    @Test
    public void shouldReturnABookByID() throws FileNotFoundException {
        assertEquals(lib.getBook(0).getClass(), Book.class);
    }

    @Test
    public void shouldCheckOutABookByID() throws Exception {
        assertTrue(lib.checkoutBook(0));
    }

    @Test
    public void shoudlReturnABookByID() throws Exception {
        lib.getBook(0).checkoutBook();

        assertTrue(lib.returnBook(0));
    }

    @Test
    public void shouldAddANewBook() throws FileNotFoundException {
        assertTrue(lib.addBook("Book 2", "D.D.", "2015", "false"));
    }

    @Test
    public void shouldReturnTheBooks() {
        assertEquals(lib.getBooks().getClass(), ArrayList.class);
    }
}
