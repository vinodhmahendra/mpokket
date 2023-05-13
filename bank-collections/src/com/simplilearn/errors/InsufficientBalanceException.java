package com.simplilearn.errors;

public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String errorMessage){
        super(errorMessage);
    }
}
