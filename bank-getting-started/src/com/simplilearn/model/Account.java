package com.simplilearn.model;

public class Account {

    private double balance;

    //constructor : name == class name
    public Account(double initBalance) {
        balance = initBalance;
    }

    public double getBalance(){
        return balance;
    }

    public void withdraw(double amount) {
    if  ( amount <= balance ) {
        balance = balance - amount;
    }else {
        System.out.println("insufficient balance");
    }
    }
    public  void deposit(double amount){
        //update the balance
        balance = balance + amount;
        return ; // implicit return statement will be added by javac
    }
}
