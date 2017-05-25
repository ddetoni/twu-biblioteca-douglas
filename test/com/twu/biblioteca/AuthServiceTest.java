package com.twu.biblioteca;

import java.io.FileNotFoundException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class AuthServiceTest {

    @Test
    public void shouldInstantiateAnAuthservice() {
        assertNotNull(new AuthService());
    }

    @Test
    public void shouldLoginUser() throws FileNotFoundException {
        AuthService authService = new AuthService();
        authService.loadData("data/users.txt");

        assertTrue(authService.login("123-4567", "1234"));
    }

    @Test
    public void shouldReturnLoggedUser() throws FileNotFoundException {
        AuthService auth = new AuthService();
        auth.loadData("data/users.txt");
        auth.login("123-4567", "1234");

        assertEquals(auth.getLoggedUser().getIdentifier(), "123-4567");
    }

    @Test
    public void shouldLoadUserData() throws FileNotFoundException {
        assertTrue(new AuthService().loadData("data/users.txt"));
    }

    @Test
    public void shouldReturnAnUserFromID() throws FileNotFoundException {
        AuthService authService = new AuthService();
        authService.loadData("data/users.txt");

        assertEquals(authService.getUser(0).getIdentifier(), "123-4567");
        assertEquals(authService.getUser(1).getIdentifier(), "001-0001");
    }

    @Test
    public void shouldReturnAnUserFromIdentifier() throws FileNotFoundException {
        AuthService authService = new AuthService();
        authService.loadData("data/users.txt");

        assertEquals(authService.getUserByIdentifier("123-4567").getIdentifier(), "123-4567");
    }


}
