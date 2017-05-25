package com.twu.biblioteca.domain;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Customer;
import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.domain.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class LibraryTest {

    private Library lib;

    @Before
    public void setUp() {
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("Book 1", "D.D.", "2015");
        Book book2 = new Book("Book 2", "D.D.", "2015");
        Book book3 = new Book("Book 3", "D.D.", "2015");
        book2.setAvailability(false);
        book2.setCustomer(new Customer("001-4321", "123", "Marcos Their", "", ""));
        book3.setAvailability(false);
        book3.setCustomer(new Customer("001-1234", "123", "Carlos Artor", "", ""));


        ArrayList<Movie> movies = new ArrayList<>();
        Movie movie = new Movie("Matrix", "1999", "The Wachowski Brothers", "9");

        books.add(book);
        books.add(book2);
        books.add(book3);

        movies.add(movie);

        lib = new Library(books, movies);
    }

    @Test
    public void shouldCreateALibrary() {
        assertNotNull(lib);
    }

    @Test
    public void shouldReturnTheTotalOfBooksLoaded() throws FileNotFoundException {
        assertEquals(lib.totalOfBooks(), 3);
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
        assertTrue(lib.checkoutBook(0, new Customer("detoni", "123", "", "", "")));
        assertEquals(lib.getBook(0).checkedOutBy().getIdentifier(), "detoni");
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
        assertTrue(lib.checkoutMovie(0, new Customer("detoni", "123", "", "", "")));
        assertEquals(lib.getMovie(0).checkedOutBy().getIdentifier(), "detoni");
    }

    @Test
    public void shouldReturnAMovieByID() {
        lib.getMovie(0).setAvailability(false);

        assertTrue(lib.returnMovie(0));
    }

    @Test
    public void shouldReturnTheCheckedOutBooks() {
        assertEquals(lib.checkedOutBooks(), "ID | Title | Customer Name\n" +
                "1 | Book 2 | Marcos Their\n" +
                "2 | Book 3 | Carlos Artor\n");
    }
}
