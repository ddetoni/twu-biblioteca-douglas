package com.twu.biblioteca;

import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class UserTest {

    @Test
    public void shouldReturnANewUser() {
        assertNotNull(new User("ddetoni"));
    }

    @Test
    public void shouldReturnUsername() {
        assertEquals(new User("ddetoni").getUsername(), "ddetoni");
    }

    @Test
    public void shouldReturnUserRole() {
        assertEquals(new User("ddetoni").getRole(), "user");
    }
}
