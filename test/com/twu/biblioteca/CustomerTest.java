package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ddetoni on 2/20/15.
 */
public class CustomerTest {

    @Test
    public void shouldReturnCustomerRole() {
        assertEquals(new Customer("ddetoni").getRole(), "customer");
    }
}
