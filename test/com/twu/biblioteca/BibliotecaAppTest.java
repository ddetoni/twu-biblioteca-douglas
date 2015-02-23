package com.twu.biblioteca;


import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {

    @Test
    public void shouldReturnAnWelcomeMessage() {
        assertEquals(new BibliotecaApp().welcome(), "Hello.");
    }

    @Test
    public void shouldAuthenticateTheUser() throws FileNotFoundException {
        BibliotecaApp bibApp = new BibliotecaApp();

        ByteArrayInputStream in = new ByteArrayInputStream("ddetoni\n1234\n".getBytes());
        System.setIn(in);

        assertNotNull(bibApp.authentication());
    }
}
