package com.simplilearn.model;

import com.simplilearn.errors.InsufficientBalanceException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("savings")
public class SavingsAccount extends Account implements InterestEarning{
    private double interestRate;

    public SavingsAccount(double initBalance,double interestRate){
        super ( initBalance );
        this.interestRate = interestRate;
    }

    @Override
    public boolean deposit(double amount) {
        balance = balance + amount;
        addTransaction("deposit",amount);
        return true;
    }

    @Override
    public boolean withdraw(double amount) throws InsufficientBalanceException {
        if ( amount <= balance ){
            balance = balance - amount;
            addTransaction("withdraw",amount);
            return true;
        }else {
//            return false; old code
            throw new InsufficientBalanceException("Insufficient balance");
//            method();
        }
    }

    @Override
    public void addInterest() {
        balance = balance + balance * interestRate;
    }
}
