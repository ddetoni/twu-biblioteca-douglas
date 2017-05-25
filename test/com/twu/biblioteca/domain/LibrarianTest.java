package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class LibrarianTest {

    @Test
    public void shouldReturnANewUser() {
        assertNotNull(new Librarian("ddetoni", "123"));
    }

    @Test
    public void shouldReturnIdentifier() {
        assertEquals(new Librarian("ddetoni", "123").getIdentifier(), "ddetoni");
    }

    @Test
    public void shouldReturnLibrarianRole() {
        assertEquals(new Librarian("ddetoni", "123").getRole(), "librarian");
    }
}
