package com.twu.biblioteca;

import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class UserTest {

    @Test
    public void should_return_a_new_user() {
        assertNotNull(new User("ddetoni"));
    }

    @Test
    public void should_return_username() {
        assertEquals(new User("ddetoni").getUsername(), "ddetoni");
    }

    @Test
    public void should_return_user_role() {
        assertEquals(new User("ddetoni").getRole(), "user");
    }
}
