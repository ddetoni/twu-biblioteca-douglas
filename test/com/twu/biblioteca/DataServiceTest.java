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
        assertNotNull(new DataService());
    }

    @Test
    public void shouldLoadData() throws FileNotFoundException {
        assertEquals(new DataService().load("data/books_test.txt").size(), 2);
    }

    @Test
    public void shouldSaveData() throws FileNotFoundException {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("Book 1", "D.D.", "2015");

        books.add(book);

        assertTrue(new DataService().save("data/books1_test.txt", books));
    }
}
