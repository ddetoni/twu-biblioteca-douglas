package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class LibrarianTest {

    @Test
    public void shouldReturnANewUser() {
        assertNotNull(new Librarian("ddetoni"));
    }

    @Test
    public void shouldReturnIdentifier() {
        assertEquals(new Librarian("ddetoni").getIdentifier(), "ddetoni");
    }

    @Test
    public void shouldReturnLibrarianRole() {
        assertEquals(new Librarian("ddetoni").getRole(), "librarian");
    }
}
