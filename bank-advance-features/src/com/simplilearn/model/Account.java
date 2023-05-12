package com.simplilearn.model;

public abstract class Account {

    protected double balance;



    //constructor : name == class name
    protected Account(double initBalance) {
        balance = initBalance;
    }

    public double getBalance(){
        return balance;
    }

    public abstract boolean withdraw(double amount) ;

    public abstract boolean deposit(double amount );
}
