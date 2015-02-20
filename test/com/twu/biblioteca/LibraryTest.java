package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by ddetoni on 2/20/15.
 */
public class LibraryTest {

    @Test
    public void shouldCreateALibrary() {
        assertNotNull(new Library("data/books.txt"));
    }

    @Test
    public void shouldLoadBookData() {
        assertTrue(new Library("data/books.txt").loadBookData());
    }
}
