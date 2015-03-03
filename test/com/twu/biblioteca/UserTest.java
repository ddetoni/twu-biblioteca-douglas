package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UserTest {

    @Test
    public void shouldReturnTheUserPassword() {
        User user = new Customer("321-7654", "321", "User1", "user@gmail.com", "02132456787");

        assertEquals(user.getPassword(), "321");
    }
}
