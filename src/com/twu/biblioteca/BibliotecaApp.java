package com.twu.biblioteca;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class BibliotecaApp {

    private AuthService authService;
    private Library lib;

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public BibliotecaApp() throws FileNotFoundException {
        this.authService = new AuthService("data/users.txt");
        this.lib = new Library("data/books.txt");

        this.lib.loadBookData();
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

    public void menu() {
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter an option:");
        Integer option = reader.nextInt();

        switch(option)
        {
            case 1:
                print(this.lib.allBooks());
                break;
            default:
                print("Select a valid option!\n");
        }
    }

    private void print(String text) {
        System.out.print(text);
    }
}
