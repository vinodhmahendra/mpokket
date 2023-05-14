package com.simplilearn.client;

import com.simplilearn.errors.InsufficientBalanceException;
import com.simplilearn.model.*;
import com.simplilearn.tasks.TransactionTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestBanking {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        Bank simplilearnBank = new Bank();

        try {
            System.out.println("Creating the customer chushruth vinodh");
            Bank.addCustomer("chushruth", "vinodh");
            Customer customer1 = Bank.getCustomer(0);
            System.out.println("Creating his Savings Account with a 500.00 balance and 3% interest.");
            customer1.addAccount("1", new SavingsAccount(500.00, 0.03));


//            System.out.println("Creating the customer Samarth Vishnu");
//            Bank.addCustomer("Samarth", "Vishnu");
//            Customer customer2 = Bank.getCustomer(1);
//            System.out.println("Creating his Checking Account with a 500.00 balance and no overdraft protection.");
//            customer2.addAccount("2", new CheckingAccount(500.00));

            Runnable task1 = new TransactionTask(customer1.getAccount("1"));
//            Runnable task2 = new TransactionTask(customer2.getAccount("2"));

            executorService.submit(task1);
//            executorService.submit(task2);
        } finally {
            executorService.shutdown();
        }
    }
}
