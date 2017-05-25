package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class BookTest {

    @Test
    public void shouldCreateANewBook() {
        assertNotNull(new Book("book 1", "D. Detoni", "2014"));
    }

    @Test
    public void shouldReturnBookDetailsWithoutAvaliability() {
        assertEquals(new Book("book 1", "D. Detoni", "2014").getDetailsSeparatedBy(" | ", false), "book 1 | D. Detoni | 2014");
    }

    @Test
    public void shouldReturnBookDetailsWithAvaliability() {
        Book book = new Book("book 1", "D. Detoni", "2014");
        book.setAvailability(false);
        book.setCustomer(new Customer("detoni", "123", "", "", ""));


        assertEquals(book.getDetailsSeparatedBy(":", true), "book 1:D. Detoni:2014:false:detoni");
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
