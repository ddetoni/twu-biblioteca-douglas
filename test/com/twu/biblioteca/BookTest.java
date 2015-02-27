package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;


public class BookTest {

    @Test
    public void shouldCreateANewBook() {
        assertNotNull(new Book("book 1", "D. Detoni", "2014"));
    }

    @Test
    public void shouldReturnBookDetailsWithoutAvaliability() {
        assertEquals(new Book("book 1", "D. Detoni", "2014").getDetails(" | ", false), "book 1 | D. Detoni | 2014");
    }

    @Test
    public void shouldReturnBookDetailsWithAvaliability() {
        assertEquals(new Book("book 1", "D. Detoni", "2014").getDetails(":", true), "book 1:D. Detoni:2014:true");
    }

    @Test
    public void shouldCheckIfBookIsAvaliable() {
        assertTrue(new Book("book 1", "D. Detoni", "2014").isAvailable());
    }

    @Test
    public void shouldCheckOutTheBook() throws Exception {
        Book book = new Book("book 1", "D. Detoni", "2014");
        book.setAvailability(false);

        assertFalse(book.isAvailable());
    }
}
