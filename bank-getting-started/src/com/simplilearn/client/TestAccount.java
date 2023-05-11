package com.simplilearn.client;

import com.simplilearn.model.Account;

public class TestAccount {
    public static void main(String[] args) {

        System.out.println("Welcome to Bank Application!!");
        //initialize with 25000.00
        Account account = new Account(25000.00);
        account.deposit(10000.00);
        account.withdraw(150000.00);

        System.out.println("Final account balance is :" + account.getBalance());
    }
}
