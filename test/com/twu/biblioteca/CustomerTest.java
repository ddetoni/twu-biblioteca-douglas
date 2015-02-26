package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CustomerTest {

    @Test
    public void shouldReturnANewUser() {
        assertNotNull(new Customer("ddetoni"));
    }

    @Test
    public void shouldReturnUsername() {
        assertEquals(new Customer("ddetoni").getUsername(), "ddetoni");
    }

    @Test
    public void shouldReturnCustomerRole() {
        assertEquals(new Customer("ddetoni").getRole(), "customer");
    }
}
