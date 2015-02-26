package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CustomerTest {

    @Test
    public void shouldReturnANewUser() {
        assertNotNull(new Customer("ddetoni", "Douglas Detoni", "ddetoni@thoughtworks.com", "05381452897"));
    }

    @Test
    public void shouldReturnUsername() {
        assertEquals(new Customer("ddetoni", "Douglas Detoni", "ddetoni@thoughtworks.com", "05381452897").getUsername(), "ddetoni");
    }

    @Test
    public void shouldReturnCustomerRole() {
        assertEquals(new Customer("ddetoni", "Douglas Detoni", "ddetoni@thoughtworks.com", "05381452897").getRole(), "customer");
    }

    @Test
    public void shouldReturnCustomerInfo() {
        Customer customer = new Customer("ddetoni", "Douglas Detoni", "ddetoni@thoughtworks.com", "05381452897");
        String info = "Name: Douglas Detoni\n" +
                "Email: ddetoni@thoughtworks.com\n" +
                "Phone Number: 05381452897\n";

        assertEquals(customer.getMyInfo(), info);
    }
}
