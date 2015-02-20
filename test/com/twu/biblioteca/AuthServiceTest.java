package com.twu.biblioteca;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class AuthServiceTest {

    @Test
    public void shouldInstantiateAnAuthservice() {
        assertNotNull(new AuthService("data/users.txt"));
    }

    @Test
    public void shouldLoginUser() throws FileNotFoundException {
        assertTrue(new AuthService("data/users.txt").login("ddetoni", "1234"));
    }

    @Test
    public void shouldReturnLoggedUser() throws FileNotFoundException {
        AuthService auth = new AuthService("data/users.txt");
        auth.login("ddetoni", "1234");

        assertEquals(auth.getLoggedUser().getUsername(), "ddetoni");
    }



}
