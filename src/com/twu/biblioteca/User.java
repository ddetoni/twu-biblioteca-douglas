package com.twu.biblioteca;


abstract class User {
    private String identifier;


    public User(String identifier) {
        this.identifier = identifier;
    };

    public String getIdentifier() {
        return this.identifier;
    }


    public String getRole() {
        return "user";
    }
}
