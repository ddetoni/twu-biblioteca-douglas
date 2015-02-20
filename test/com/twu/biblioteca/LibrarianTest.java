package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ddetoni on 2/20/15.
 */
public class LibrarianTest {

    @Test
    public void should_return_librarian_role() {
        assertEquals(new Librarian("ddetoni").getRole(), "librarian");
    }
}
