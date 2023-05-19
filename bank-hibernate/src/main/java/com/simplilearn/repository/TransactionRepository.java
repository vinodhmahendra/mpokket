package com.simplilearn.repository;

import com.simplilearn.model.Account;
import com.simplilearn.model.Transaction;

import java.sql.SQLException;

public interface TransactionRepository {
    void createTransaction(Transaction transaction);

    void updateTransaction(Transaction transaction) ;

    void deleteTransaction(String transactionId) ;

    Transaction getTransaction(String transactionId) throws SQLException;
}
