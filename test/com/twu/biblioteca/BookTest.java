package com.twu.biblioteca;

import com.sun.tools.javac.code.Attribute;
import org.junit.Test;

import static org.junit.Assert.*;


public class BookTest {

    @Test
    public void shouldCreateANewBook() {
        assertNotNull(new Book("book 1", "D. Detoni", "2014", true));
    }

    @Test
    public void shouldReturnBookDetails() {
        assertEquals(new Book("book 1", "D. Detoni", "2014", true).getDetails(), "book 1 | D. Detoni | 2014");
    }

    @Test
    public void shouldCheckIfBookIsAvaliable() {
        assertTrue(new Book("book 1", "D. Detoni", "2014", true).isAvaliable());
        assertFalse(new Book("book 1", "D. Detoni", "2014", false).isAvaliable());
    }

    @Test
    public void shouldCheckOutTheBook() throws Exception {
        Book book = new Book("book 1", "D. Detoni", "2014", true);
        book.checkoutBook();

        assertFalse(book.isAvaliable());
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionBookAlreadyCheckout() throws Exception {
        Book book = new Book("book 1", "D. Detoni", "2014", false);
        book.checkoutBook();
    }

    @Test
    public void shouldMakeTheBookAvaliableAgain() throws Exception {
        Book book = new Book("book 1", "D. Detoni", "2014", false);
        book.returnBook();

        assertTrue(book.isAvaliable());
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionBookNotCheckout() throws Exception {
        Book book = new Book("book 1", "D. Detoni", "2014", true);
        book.returnBook();
    }

    @Test
    public void shouldReturnAnArrayDetail() {
        Book book = new Book("book 1", "D. Detoni", "2014", true);

        assertEquals(book.getArrayDetails().size(), 4);
    }
}
