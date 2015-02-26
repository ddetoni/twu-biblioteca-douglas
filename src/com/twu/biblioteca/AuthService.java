package com.twu.biblioteca;

import java.io.*;
import java.util.Scanner;

public class AuthService {
    String usersPath;
    User loggedUser;

    public AuthService(String path) {
        this.usersPath = path;
    }

    public boolean login(String username, String password) throws FileNotFoundException {

        Scanner fileScanner = new Scanner(new File(this.usersPath));

        return checkCredentials(username, password, fileScanner);
    }

    private boolean checkCredentials(String username, String password, Scanner fileScanner) {
        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String [] splitedLine = line.split(":");

            if(splitedLine[0].equals(username) && splitedLine[2].equals(password)) {

                if(splitedLine[1].equals("customer")) {
                    this.loggedUser = new Customer(username, splitedLine[3], splitedLine[4], splitedLine[5]);
                } else if(splitedLine[1].equals("librarian")) {
                    this.loggedUser = new Librarian(username);
                }

                return true;
            }
        }
        return false;
    }

    public User getLoggedUser() {
        return this.loggedUser;
    }
}
