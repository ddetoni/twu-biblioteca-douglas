package com.twu.biblioteca;


public class User {
    private String lastName;
    private String name;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    };

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getRole() {
        return "user";
    }
}
