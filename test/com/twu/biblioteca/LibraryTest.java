package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class LibraryTest {

    private ArrayList<Book> books;
    private ArrayList<Movie> movies;
    private Library lib;

    @Before
    public void setUp() {
        books = new ArrayList<Book>();
        Book book = new Book("Book 1", "D.D.", "2015");

        movies = new ArrayList<Movie>();
        Movie movie = new Movie("Matrix", "1999", "The Wachowski Brothers", "9");

        books.add(book);
        movies.add(movie);

        lib = new Library(books, movies);
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
    public void shouldReturnABook() throws FileNotFoundException {
        assertEquals(lib.getBook(0).getClass(), Book.class);
    }

    @Test
    public void shouldCheckOutABookByID() throws Exception {
        assertTrue(lib.checkoutBook(0));
    }

    @Test
    public void shoudlReturnABookByID() throws Exception {
        lib.getBook(0).setAvailability(false);

        assertTrue(lib.returnBook(0));
    }

    @Test
    public void shouldAddANewBook() throws FileNotFoundException {
        assertTrue(lib.addBook("Book 2", "D.D.", "2015"));
    }

    @Test
    public void shouldReturnTheBooks() {
        assertEquals(lib.getBooks().getClass(), ArrayList.class);
    }

    @Test
    public void shouldReturnAllTheMovies() {
        assertEquals(lib.allMovies(), "\nID | Name | Year | Director | Rating\n" +
                                        "0 | Matrix | 1999 | The Wachowski Brothers | 9\n");
    }

    @Test
    public void shouldCheckoutAMovieByID() {
        assertTrue(lib.checkoutMovie(0));
    }

    @Test
    public void shouldReturnAMovieByID() {
        lib.getBook(0).setAvailability(false);

        assertTrue(lib.returnMovie(0));
    }
}
