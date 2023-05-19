package com.simplilearn.repository;

import com.simplilearn.model.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AccountRepositoryImpl implements AccountRepository{

    private Session session;

    public AccountRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void createAccount(Account account) {
        Transaction tx = session.beginTransaction(); // provide by hibernate
        session.save(account);
        tx.commit();
    }

    @Override
    public void updateAccount(Account account) {
        Transaction tx = session.beginTransaction(); // provide by hibernate
        session.update(account);
        tx.commit();
    }

    @Override
    public void deleteAccount(String accountId) {
        Transaction tx = session.beginTransaction(); // provide by hibernate
        session.save(getAccount(accountId));
        tx.commit();
    }

    @Override
    public Account getAccount(String accountId) {
        return session.get(Account.class,accountId)  ;
    }
}
