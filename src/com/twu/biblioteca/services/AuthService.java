package com.twu.biblioteca.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.twu.biblioteca.domain.Customer;
import com.twu.biblioteca.domain.Librarian;
import com.twu.biblioteca.domain.User;

public class AuthService {

    private User loggedUser;
    private List<User> users;

    public AuthService() {
        this.users = new ArrayList<>();
    }

    public boolean login(String username, String password) throws FileNotFoundException {
        return checkCredentials(username, password);
    }

    private boolean checkCredentials(String username, String password) {

        for (User user : users) {
            if (user.getIdentifier().equals(username) && user.getPassword().equals(password)) {
                this.loggedUser = user;
                return true;
            }
        }
        return false;
    }

    public User getLoggedUser() {
        return this.loggedUser;
    }

    public boolean loadData(String path) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(path));

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] splitedLine = line.split(":");
            User user;

            if (splitedLine[1].equals("customer")) {
                user = new Customer(splitedLine[0], splitedLine[2], splitedLine[3], splitedLine[4], splitedLine[5]);
            } else {
                user = new Librarian(splitedLine[0], splitedLine[2]);
            }

            users.add(user);
        }
        return true;
    }

    User getUser(int id) {
        return this.users.get(id);
    }

    User getUserByIdentifier(String identifier) {

        for (User user : users) {
            if (user.getIdentifier().equals(identifier)) {
                return user;
            }
        }

        return null;

    }
}
