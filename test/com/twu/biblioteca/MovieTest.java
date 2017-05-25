package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MovieTest {

    @Test
    public void shouldInstantiateAMovie() {
        assertNotNull(new Movie("Matrix", "1999", "The Wachowski Brothers", "9"));
    }

    @Test
    public void shouldReturnTrueOnIsAvaliableMethod() {
        Movie movie = new Movie("Matrix", "1999", "The Wachowski Brothers", "9");

        assertTrue(movie.isAvailable());
    }

    @Test
    public void shouldChangeTheMovieAvailability() {
        Movie movie = new Movie("Matrix", "1999", "The Wachowski Brothers", "9");
        movie.setAvailability(false);

        assertFalse(movie.isAvailable());
    }

    @Test
    public void shouldReturnTheCustomerThatCheckedOutTheMovie() {
        Movie movie = new Movie("Matrix", "1999", "The Wachowski Brothers", "9");
        Customer customer = new Customer("", "", "", "", "");
        movie.setCustomer(customer);

        assertEquals(movie.checkedOutBy(), customer);
    }

    @Test
    public void shouldReturnTheMovieDetails() {
        Movie movie = new Movie("Matrix", "1999", "The Wachowski Brothers", "9");

        assertEquals(movie.getDetailsSeparatedBy(" | ", false), "Matrix | 1999 | The Wachowski Brothers | 9");
    }

}
