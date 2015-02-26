package com.twu.biblioteca;


abstract class User {
    private String username;


    public User(String username) {
        this.username = username;
    };

    public String getUsername() {
        return this.username;
    }


    public String getRole() {
        return "user";
    }
}
