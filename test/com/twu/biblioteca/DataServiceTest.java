package com.twu.biblioteca;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class DataServiceTest {

    @Test
    public void shouldInstantiateADataService() {
        assertNotNull(new DataService(new AuthService()));
    }

    @Test
    public void shouldLoadBooksData() throws FileNotFoundException {
        AuthService authService = new AuthService();
        authService.loadData("data/users.txt");

        ArrayList<Book> books = new DataService(authService).loadBooks("data/fixtures/books_test.txt");

        assertEquals(books.size(), 2);
        assertEquals(books.get(1).checkedOutBy().getIdentifier(), "123-4567");
    }

    @Test
    public void shouldSaveBookData() throws FileNotFoundException {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("Book 1", "D.D.", "2015");
        book.setCustomer(new Customer("detoni", "123", "", "", ""));

        books.add(book);

        assertTrue(new DataService(new AuthService()).saveBooks("data/fixtures/books1_test.txt", books));
    }

    @Test
    public void shouldLoadMovieData() throws FileNotFoundException {
        ArrayList<Movie> movies = new DataService(new AuthService()).loadMovies("data/fixtures/movies_test.txt");

        assertEquals(movies.size(), 2);
        assertEquals(movies.get(1).checkedOutBy(), null);
    }

    @Test
    public void shouldSaveMovieData() throws FileNotFoundException {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie = new Movie("Movie 1", "2014", "D.D.", "10");
        movie.setAvailability(false);
        movie.setCustomer(new Customer("detoni", "123", "", "", ""));

        movies.add(movie);

        assertTrue(new DataService(new AuthService()).saveMovies("data/fixtures/movies1_test.txt", movies));
    }
}
