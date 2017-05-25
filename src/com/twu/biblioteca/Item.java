package com.twu.biblioteca;

abstract class Item {

    private boolean availability;
    private Customer customer;

    public Item() {
        this.availability = true;
    }

    public boolean isAvailable() {
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
