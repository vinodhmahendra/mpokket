package com.simplilearn.model;

public class Account {

    private double balance;


    public Account () {
        balance = 10000; //default value
    }
    //constructor : name == class name
    public Account(double initBalance) {
        balance = initBalance;
    }

    public double getBalance(){
        return balance;
    }

    public boolean withdraw(double amount) {
    if  ( amount <= balance ) {
        balance = balance - amount;
        return  true;
    }else {
//        System.out.println("insufficient balance");
        return false;
    }
    }
    public  boolean deposit(double amount ){
        //update the balance
        balance = balance + amount;
        return true ;
    }
}
