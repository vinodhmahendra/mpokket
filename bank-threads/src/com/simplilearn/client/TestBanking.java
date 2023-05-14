package com.simplilearn.client;

import com.simplilearn.errors.InsufficientBalanceException;
import com.simplilearn.model.*;

public class TestBanking {
    public static void main(String[] args) {

//        Bank simplilearnBank = new Bank();
        Customer customer;
        Account account; // super class type

        System.out.println("Creating the customer chushruth vinodh");
        Bank.addCustomer("chushruth", "vinodh");
        customer = Bank.getCustomer(0);
        System.out.println("Creating his Savings Account with a 500.00 balance and 3% interest.");
        customer.addAccount("1", new SavingsAccount(500.00, 0.03));
        account = customer.getAccount("1");
        System.out.println("Account creaated with balance : " + account.getBalance());
        System.out.println("Deposit 200.00: " + account.deposit(200.00));
        System.out.println("Withdraw 100.00: " + account.withdraw(100.00));
        for (Transaction transaction : account.getTransactions()) {
            System.out.println("Transaction ID: " + transaction.getTransactionId() +
                    ", Type: " + transaction.getType() + ", Amount: " + transaction.getAmount());
        }

    }
}
