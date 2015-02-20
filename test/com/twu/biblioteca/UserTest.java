package com.twu.biblioteca;

import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class UserTest {

    @Test
    public void should_return_a_new_user() {
        assertNotNull(new User("Douglas", "Detoni"));
    }

    @Test
    public void should_return_user_name() {
        assertEquals(new User("Douglas", "Detoni").getName(), "Douglas");
    }

    @Test
    public void should_return_user_last_name() {
        assertEquals(new User("Douglas", "Detoni").getLastName(), "Detoni");
    }

    @Test
    public void should_return_user_role() {
        assertEquals(new User("Douglas", "Detoni").getRole(), "user");
    }
}
