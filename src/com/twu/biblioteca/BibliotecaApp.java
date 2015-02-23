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

        print("Enter the username: \n");
        String username = reader.next();

        print("Enter the password: \n");
        String password = reader.next();

        this.authService.login(username, password);

        return this.authService.getLoggedUser();
    }

    public void menu() throws Exception {
        Scanner reader = new Scanner(System.in);
        Integer id;

        print("Options:\n" +
                "\t1 - List of all books.\n" +
                "\t2 - Check-out book.\n" +
                "\t3 - Return book.\n" +
                "\t0 - Quit\n");

        print("Enter an option:\n");
        Integer option = reader.nextInt();

        switch(option)
        {
            case 0:
                print("Bye!\n");
                //System.exit(0);
                break;
            case 1:
                print(this.lib.allBooks());
                break;
            case 2:
                print("Enter the book ID:\n");
                id = reader.nextInt();

                this.lib.checkoutBook(id);
                break;
            case 3:
                print("Enter the book ID:\n");
                id = reader.nextInt();

                this.lib.returnBook(id);
                break;

            default:
                print("Select a valid option!\n");
        }
    }

    private void print(String text) {
        System.out.print(text);
    }
}
