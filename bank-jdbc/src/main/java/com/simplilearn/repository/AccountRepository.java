package com.simplilearn.repository;

import com.simplilearn.model.Account;

import java.sql.SQLException;

public interface AccountRepository {
    void createAccount(Account account) throws SQLException;

    void updateAccount(Account account) throws SQLException;

    void deleteAccount(String accountId) throws SQLException;

    Account getAccount(String accountId) throws SQLException;
}
