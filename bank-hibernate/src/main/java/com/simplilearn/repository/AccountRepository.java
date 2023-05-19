package com.simplilearn.repository;

import com.simplilearn.model.Account;



public interface AccountRepository {
    void createAccount(Account account) ;

    void updateAccount(Account account) ;

    void deleteAccount(String accountId);

    Account getAccount(String accountId);
}
