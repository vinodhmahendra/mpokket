package com.simplilearn.client;

import com.simplilearn.errors.InsufficientBalanceException;
import com.simplilearn.model.*;

public class TestBanking {
    public static void main(String[] args) {

//        Bank simplilearnBank = new Bank();
        Customer customer;
        Account account; // super class type

        System.out.println("Creating the customer chushruth vinodh");
        Bank.addCustomer("chushruth","vinodh");
        customer = Bank.getCustomer(0);
        System.out.println("Creating his Savings Account with a 500.00 balance and 3% interest.");
        customer.setAccount(new SavingsAccount(500.00,0.03));

        System.out.println("Creating the customer  Samarth Vishnu");
        Bank.addCustomer("Samarth","Vishnu");
        customer = Bank.getCustomer(1);
        System.out.println("Creating his Checking Account with a 500.00 balance and no overdraft protection.");
        customer.setAccount(new CheckingAccount(500.00));

        System.out.println("Creating the customer  Vinodh Mahendra");
        Bank.addCustomer("Vinodh","Mahendra");
        customer = Bank.getCustomer(2);
        System.out.println("Creating his Checking Account with a 500.00 balance and 500.00 in overdraft protection.");
        customer.setAccount(new CheckingAccount(500.00,500.00));

        System.out.println("Creating the customer  Bhavya Keshavulu");
        Bank.addCustomer("Bhavya","Keshavulu");
        customer = Bank.getCustomer(3);
        System.out.println("Bhavya shares her checking account with her husband Vinodh.");
        customer.setAccount(Bank.getCustomer(2).getAccount());


        System.out.println();

        System.out.println("Retrieving the customer Chushruth Vinodh with his savings account");
        customer = Bank.getCustomer(0);
        account = customer.getAccount();

        System.out.println("Withdraw 150.00: " + account.withdraw(150.00));
        System.out.println("Deposit 22.50 :" + account.deposit(22.50));
        System.out.println("Withdraw 47.62 : " + account.withdraw(47.62));
        System.out.println("Withdraw 400.00 :" + account.withdraw(400.00));
//        try {
//            System.out.println("Withdraw 150.00: " + account.withdraw(150.00));
//            System.out.println("Deposit 22.50 :" + account.deposit(22.50));
//            System.out.println("Withdraw 47.62 : " + account.withdraw(47.62));
//            System.out.println("Withdraw 400.00 :" + account.withdraw(400.00));
//        }catch (InsufficientBalanceException variable) {
//            System.out.println(variable.getMessage());
//        }
        System.out.println("Customer [ " + customer.getLastName()
         + " , " + customer.getFirstName() +
                " ] has a balance of " + account.getBalance());

//        System.out.println("Retrieving the customer Samarth Vishnu with his checking account");
//        customer = Bank.getCustomer(1);
//        account = customer.getAccount();
//
//        System.out.println("Withdraw 150.00: " + account.withdraw(150.00));
//        System.out.println("Deposit 22.50 :" + account.deposit(22.50));
//        System.out.println("Withdraw 47.62 : " + account.withdraw(47.62));
//        System.out.println("Withdraw 400.00 :" + account.withdraw(400.00));
//
//        System.out.println("Customer [ " + customer.getLastName()
//                + " , " + customer.getFirstName() +
//                " ] has a balance of " + account.getBalance());
//
//        System.out.println("Retrieving the customer Chushruth Vinodh with his savings account");
//        customer = Bank.getCustomer(0);
//        account = customer.getAccount();
//
//        System.out.println("Withdraw 150.00: " + account.withdraw(150.00));
//        System.out.println("Deposit 22.50 :" + account.deposit(22.50));
//        System.out.println("Withdraw 47.62 : " + account.withdraw(47.62));
//        System.out.println("Withdraw 400.00 :" + account.withdraw(400.00));
//
//        System.out.println("Customer [ " + customer.getLastName()
//                + " , " + customer.getFirstName() +
//                " ] has a balance of " + account.getBalance());
//
//
//        System.out.println("Retrieving the customer  Vinodh Mahendra with his checking account that has overdraft protection");
//        customer = Bank.getCustomer(2);
//        account = customer.getAccount();
//
//        System.out.println("Withdraw 150.00: " + account.withdraw(150.00)); // virtual method invocation
//        System.out.println("Deposit 22.50 :" + account.deposit(22.50));
//        System.out.println("Withdraw 47.62 : " + account.withdraw(47.62)); // virtual method invocation
//        System.out.println("Withdraw 400.00 :" + account.withdraw(400.00)); // virtual method invocation
//
//        System.out.println("Customer [ " + customer.getLastName()
//                + " , " + customer.getFirstName() +
//                " ] has a balance of " + account.getBalance());
//
//        System.out.println("Retrieving the customer Bhavya Keshavulu with her joint checking account with husband Vinodh.");
//        customer = Bank.getCustomer(3);
//        account = customer.getAccount();
//
//        System.out.println("Deposit 150.00: " + account.deposit(150.00));
//        System.out.println("Withdraw 750.62 : " + account.withdraw(750.00)); // virtual method invocation
//
//
//        System.out.println("Customer [ " + customer.getLastName()
//                + " , " + customer.getFirstName() +
//                " ] has a balance of " + account.getBalance());
    }
}
