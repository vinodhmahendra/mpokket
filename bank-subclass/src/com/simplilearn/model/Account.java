package com.simplilearn.model;

public class Account {

    protected double balance;



    //constructor : name == class name
    protected Account(double initBalance) {
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
