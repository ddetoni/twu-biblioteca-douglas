package com.twu.biblioteca;

/**
 * Created by ddetoni on 2/20/15.
 */
public class Customer extends User {

    private String name;
    private String email;
    private String phone;

    public Customer(String libraryNumber, String password, String name, String email, String phone) {
        super(libraryNumber, password);

        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String getRole() {
        return "customer";
    }

    public String getMyInfo() {
        return "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone Number: " + phone + "\n";
    }

    public String getName() {
        return name;
    }
}
