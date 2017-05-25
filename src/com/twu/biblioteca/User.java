package com.twu.biblioteca;


abstract class User {

    private String identifier;
    private String password;


    public User(String identifier, String password) {
        this.identifier = identifier;
        this.password = password;
    }

    public String getIdentifier() {
        return this.identifier;
    }


    public String getRole() {
        return "user";
    }

    public String getPassword() {
        return password;
    }
}
