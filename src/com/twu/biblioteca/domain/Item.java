package com.twu.biblioteca.domain;

abstract class Item {

    private boolean availability;
    private Customer customer;

    Item() {
        this.availability = true;
    }

    boolean isAvailable() {
        return this.availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer checkedOutBy() {
        return this.customer;
    }

    public abstract String getDetailsSeparatedBy(String separator, boolean showAvailability);
}
