package com.simplilearn.model;

public interface AccountOperations {

    boolean withdraw(double amount);
    boolean deposit (double amount);

    double getBalance();
}
