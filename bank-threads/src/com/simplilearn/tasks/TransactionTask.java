package com.simplilearn.tasks;

import com.simplilearn.errors.InsufficientBalanceException;
import com.simplilearn.model.Account;
import com.simplilearn.model.Transaction;

import java.util.Scanner;

public class TransactionTask implements  Runnable{

    private Account account;
    private Scanner scanner;

    public TransactionTask(Account account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        try {
            System.out.println("Initial Balance : " + account.getBalance());
            System.out.println("Enter deposit amount:");
            double depositAmount = scanner.nextDouble();
            account.deposit(depositAmount);
            System.out.println("After Deposit of "+depositAmount+ " Balance: "  + account.getBalance());
            System.out.println("Enter withdraw amount:");
            double withdrawAmount = scanner.nextDouble();
            account.withdraw(withdrawAmount);
            System.out.println("After Withdrawal of "+withdrawAmount+" , Balance: " + account.getBalance());

            for (Transaction transaction : account.getTransactions()) {
                System.out.println("Transaction ID: " + transaction.getTransactionId() +
                        ", Type: " + transaction.getType() + ", Amount: " + transaction.getAmount());
            }
        }catch (InsufficientBalanceException varaible){
            System.out.println(varaible.getMessage());
        }
    }
}
