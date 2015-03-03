package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AuthService {
    String usersPath;
    User loggedUser;
    private ArrayList<User> users;

    public AuthService(String path) {
        this.usersPath = path;
        this.users = new ArrayList<User>();
    }

    public boolean login(String username, String password) throws FileNotFoundException {
        return checkCredentials(username, password);
    }

    private boolean checkCredentials(String username, String password) {

        for(User user : users) {
            if(user.getIdentifier().equals(username) && user.getPassword().equals(password)) {
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

    public User getUser(int id) {
        return this.users.get(id);
    }
}
