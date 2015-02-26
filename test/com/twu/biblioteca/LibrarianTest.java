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
    public void shouldReturnUsername() {
        assertEquals(new Librarian("ddetoni").getUsername(), "ddetoni");
    }

    @Test
    public void shouldReturnLibrarianRole() {
        assertEquals(new Librarian("ddetoni").getRole(), "librarian");
    }
}
