package com.twu.biblioteca.domain;


public class Librarian extends User {


    public Librarian(String username, String password) {
        super(username, password);
    }

    @Override
    public String getRole() {
        return "librarian";
    }
}
