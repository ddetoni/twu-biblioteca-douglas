package com.twu.biblioteca;

/**
 * Created by ddetoni on 2/20/15.
 */
public class Librarian extends User {


    public Librarian(String username, String password) {
        super(username, password);
    }

    @Override
    public String getRole() {
        return "librarian";
    }
}
