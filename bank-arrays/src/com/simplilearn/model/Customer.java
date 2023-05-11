package com.simplilearn.model;

public class Customer {

    private String firstName;
    private String lastName;

    private Account account;

    public Customer (String f, String l) {
        firstName = f;
        lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        //this keyword refer to current instance (object)
        this.account = account;
    }
}
