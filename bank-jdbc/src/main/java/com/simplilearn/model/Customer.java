package com.simplilearn.model;

import java.util.HashMap;
import java.util.Map;

public class Customer {

    private Integer id;
    private String firstName;
    private String lastName;

//    private Account account;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Map<String,Account> accounts = new HashMap<>();
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

    public Account getAccount(String accountId)
    {
        return this.accounts.get(accountId);
    }

   public void addAccount(String accountId,Account account){
        this.accounts.put(accountId,account);
   }
}
