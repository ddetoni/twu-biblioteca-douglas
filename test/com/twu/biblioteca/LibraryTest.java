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
}
