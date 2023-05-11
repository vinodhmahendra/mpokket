package com.simplilearn.client;

import com.simplilearn.model.*;

public class TestBanking {
    public static void main(String[] args) {

        Bank simplilearnBank = new Bank();
        Customer customer;
        Account account; // super class type

        System.out.println("Creating the customer chushruth vinodh");
        simplilearnBank.addCustomer("chushruth","vinodh");
        customer = simplilearnBank.getCustomer(0);
        System.out.println("Creating his Savings Account with a 500.00 balance and 3% interest.");
        customer.setAccount(new SavingsAccount(500.00,0.03));

        System.out.println("Creating the customer  Samarth Vishnu");
        simplilearnBank.addCustomer("Samarth","Vishnu");
        customer = simplilearnBank.getCustomer(1);
        System.out.println("Creating his Checking Account with a 500.00 balance and no overdraft protection.");
        customer.setAccount(new CheckingAccount(500.00));

        System.out.println("Creating the customer  Vinodh Mahendra");
        simplilearnBank.addCustomer("Vinodh","Mahendra");
        customer = simplilearnBank.getCustomer(2);
        System.out.println("Creating his Checking Account with a 500.00 balance and 500.00 in overdraft protection.");
        customer.setAccount(new CheckingAccount(500.00,500.00));

        System.out.println("Creating the customer  Bhavya Keshavulu");
        simplilearnBank.addCustomer("Bhavya","Keshavulu");
        customer = simplilearnBank.getCustomer(3);
        System.out.println("Bhavya shares her checking account with her husband Vinodh.");
        customer.setAccount(simplilearnBank.getCustomer(2).getAccount());


        System.out.println();

        System.out.println("Retrieving the customer Chushruth Vinodh with his savings account");
        customer = simplilearnBank.getCustomer(0);
        account = customer.getAccount();

        System.out.println("Withdraw 150.00: " + account.withdraw(150.00));
        System.out.println("Deposit 22.50 :" + account.deposit(22.50));
        System.out.println("Withdraw 47.62 : " + account.withdraw(47.62));
        System.out.println("Withdraw 400.00 :" + account.withdraw(400.00));

        System.out.println("Customer [ " + customer.getLastName()
         + " , " + customer.getFirstName() +
                " ] has a balance of " + account.getBalance());

        System.out.println("Retrieving the customer Samarth Vishnu with his checking account");
        customer = simplilearnBank.getCustomer(1);
        account = customer.getAccount();

        System.out.println("Withdraw 150.00: " + account.withdraw(150.00));
        System.out.println("Deposit 22.50 :" + account.deposit(22.50));
        System.out.println("Withdraw 47.62 : " + account.withdraw(47.62));
        System.out.println("Withdraw 400.00 :" + account.withdraw(400.00));

        System.out.println("Customer [ " + customer.getLastName()
                + " , " + customer.getFirstName() +
                " ] has a balance of " + account.getBalance());

        System.out.println("Retrieving the customer Chushruth Vinodh with his savings account");
        customer = simplilearnBank.getCustomer(0);
        account = customer.getAccount();

        System.out.println("Withdraw 150.00: " + account.withdraw(150.00));
        System.out.println("Deposit 22.50 :" + account.deposit(22.50));
        System.out.println("Withdraw 47.62 : " + account.withdraw(47.62));
        System.out.println("Withdraw 400.00 :" + account.withdraw(400.00));

        System.out.println("Customer [ " + customer.getLastName()
                + " , " + customer.getFirstName() +
                " ] has a balance of " + account.getBalance());


        System.out.println("Retrieving the customer  Vinodh Mahendra with his checking account that has overdraft protection");
        customer = simplilearnBank.getCustomer(2);
        account = customer.getAccount();

        System.out.println("Withdraw 150.00: " + account.withdraw(150.00)); // virtual method invocation
        System.out.println("Deposit 22.50 :" + account.deposit(22.50));
        System.out.println("Withdraw 47.62 : " + account.withdraw(47.62)); // virtual method invocation
        System.out.println("Withdraw 400.00 :" + account.withdraw(400.00)); // virtual method invocation

        System.out.println("Customer [ " + customer.getLastName()
                + " , " + customer.getFirstName() +
                " ] has a balance of " + account.getBalance());

        System.out.println("Retrieving the customer Bhavya Keshavulu with her joint checking account with husband Vinodh.");
        customer = simplilearnBank.getCustomer(3);
        account = customer.getAccount();

        System.out.println("Deposit 150.00: " + account.deposit(150.00));
        System.out.println("Withdraw 750.62 : " + account.withdraw(750.00)); // virtual method invocation


        System.out.println("Customer [ " + customer.getLastName()
                + " , " + customer.getFirstName() +
                " ] has a balance of " + account.getBalance());
    }
}
