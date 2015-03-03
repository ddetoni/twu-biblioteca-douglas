package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CustomerTest {

    @Test
    public void shouldReturnANewUser() {
        assertNotNull(new Customer("ddetoni", "123", "Douglas Detoni", "ddetoni@thoughtworks.com", "05381452897"));
    }

    @Test
    public void shouldReturnIdentifier() {
        assertEquals(new Customer("123-4567", "123", "Douglas Detoni", "ddetoni@thoughtworks.com", "05381452897").getIdentifier(), "123-4567");
    }

    @Test
    public void shouldReturnCustomerRole() {
        assertEquals(new Customer("123-4567", "123", "Douglas Detoni", "ddetoni@thoughtworks.com", "05381452897").getRole(), "customer");
    }

    @Test
    public void shouldReturnCustomerInfo() {
        Customer customer = new Customer("123-4567", "123", "Douglas Detoni", "ddetoni@thoughtworks.com", "05381452897");
        String info = "Name: Douglas Detoni\n" +
                "Email: ddetoni@thoughtworks.com\n" +
                "Phone Number: 05381452897\n";

        assertEquals(customer.getMyInfo(), info);
    }
}
