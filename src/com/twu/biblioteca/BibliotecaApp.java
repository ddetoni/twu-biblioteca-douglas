package com.twu.biblioteca;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class BibliotecaApp {

    private AuthService authService;

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public BibliotecaApp() {
        this.authService = new AuthService("data/users.txt");
    }

    public String welcome() {
        return "Hello.";
    }

    public User authentication() throws FileNotFoundException {
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter the username: ");
        String username = reader.next();

        System.out.println("Enter the password: ");
        String password = reader.next();

        this.authService.login(username, password);

        User loggedUser = this.authService.getLoggedUser();
        return loggedUser;
    }
}
