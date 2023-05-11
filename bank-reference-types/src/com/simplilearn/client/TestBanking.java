package com.simplilearn.client;

import com.simplilearn.model.Account;
import com.simplilearn.model.Customer;

public class TestBanking {
    public static void main(String[] args) {

        System.out.println("Creating the customer Samarth Vishnu");
        Customer customer = new Customer("Samarth","Vishnu");

        System.out.println("Creating his account with a 500.00 balance");
        Account account = new Account();

        customer.setAccount(account);

        System.out.println("Witdraw 150 : " +customer.getAccount().withdraw(150.00));

        System.out.println("Deposit 22.50 : " + customer.getAccount().deposit(22.50));

        System.out.println("Witdraw 47.62 : " +customer.getAccount().withdraw(47.62));


        System.out.println("Customer  [ "+customer.getFirstName() + " , " + customer.getLastName() + " ] " +
                "has a balance of " + customer.getAccount().getBalance());
    }
}
