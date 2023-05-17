package com.simplilearn.repository;

import com.simplilearn.model.Account;
import com.simplilearn.model.Transaction;

import java.sql.SQLException;

public interface TransactionRepository {
    void createTransaction(Transaction transaction) throws SQLException;

    void updateTransaction(Transaction transaction) throws SQLException;

    void deleteTransaction(String transactionId) throws SQLException;

    Transaction getTransaction(String transactionId) throws SQLException;
}
