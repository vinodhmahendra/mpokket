package com.simplilearn.repository;

import com.simplilearn.model.AccountTransaction;

public interface TransactionRepository {
    void createTransaction(AccountTransaction accountTransaction);

    void updateTransaction(AccountTransaction accountTransaction) ;

    void deleteTransaction(String transactionId) ;

    AccountTransaction getTransaction(String transactionId) ;
}
