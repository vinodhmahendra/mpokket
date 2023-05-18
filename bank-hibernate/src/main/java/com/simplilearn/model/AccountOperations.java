package com.simplilearn.model;

import com.simplilearn.errors.InsufficientBalanceException;

public interface AccountOperations {

    boolean withdraw(double amount) throws InsufficientBalanceException;
    boolean deposit (double amount);

    double getBalance();
}
