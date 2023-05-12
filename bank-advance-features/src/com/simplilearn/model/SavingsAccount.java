package com.simplilearn.model;

public class SavingsAccount extends Account{
    private double interestRate;

    public SavingsAccount(double initBalance,double interestRate){
        super ( initBalance );
        this.interestRate = interestRate;
    }

    @Override
    public boolean deposit(double amount) {
        balance = balance + amount;
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if ( amount <= balance ){
            balance = balance - amount;
            return true;
        }else {
            return false;
        }
    }
}
