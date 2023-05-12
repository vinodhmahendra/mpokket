package com.simplilearn.model;

public class CheckingAccount extends Account{
    private double overdraftAmount;

    public CheckingAccount ( double initBalance , double overdraftAmount){
        super ( initBalance ); // invoke constructoe present in super class
        this.overdraftAmount = overdraftAmount;
    }

    public CheckingAccount(double initBalance) {
        this (initBalance,0.0); // invoke a constructor present in a same class
    }

    //override a withdraw
    @Override
    public boolean withdraw(double amount) {
       boolean result = true;
       if ( balance < amount ) {
           double overdraftNeeded = amount - balance ;
           if ( overdraftAmount < overdraftNeeded ){
               result = false;
           }else {
               balance = 0.0;
               overdraftAmount -= overdraftNeeded;
           }
       }else {
           balance -= amount;
       }
       return  result;
    }

    @Override
    public boolean deposit(double amount) {
        balance = balance + amount;
        return true;
    }
}
