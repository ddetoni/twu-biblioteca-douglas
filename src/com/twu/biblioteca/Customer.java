package com.twu.biblioteca;

/**
 * Created by ddetoni on 2/20/15.
 */
public class Customer extends User {

    public Customer(String username) {
        super(username);
    }

    @Override
    public String getRole() {
        return "customer";
    }

}
