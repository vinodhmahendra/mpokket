package com.simplilearn.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class Account implements AccountOperations{

    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    protected double balance;
    protected Set<Transaction> transactions = new HashSet<>();


    //constructor : name == class name
    protected Account(double initBalance) {
        balance = initBalance;
    }

    public double getBalance(){
        return balance;
    }

    protected  void addTransaction (String type, double amount){
        String transactionId  = UUID.randomUUID().toString();
        transactions.add(new Transaction(transactionId,type,amount));
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    //    public abstract boolean withdraw(double amount) ;

//    public abstract boolean deposit(double amount );
}
