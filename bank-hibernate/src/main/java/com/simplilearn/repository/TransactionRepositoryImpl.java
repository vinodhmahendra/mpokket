package com.simplilearn.repository;

import com.simplilearn.model.AccountTransaction;
import com.simplilearn.util.HiberanateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionRepositoryImpl implements TransactionRepository {

    private Session session;

    public TransactionRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void createTransaction(AccountTransaction accountTransaction) {
        System.out.println("Create Transaction");
        Session newSession = HiberanateUtil.getSessionFactory().openSession();
        Transaction hibernateTransaction = newSession.beginTransaction();

        newSession.save(accountTransaction);

        System.out.println("save--->");
        hibernateTransaction.commit();
        newSession.close();
//        session.close();
    }

    @Override
    public void updateTransaction(AccountTransaction accountTransaction) {

        Transaction hibernateTransaction = null;

        try (Session session = HiberanateUtil.getSessionFactory().openSession()) {
            hibernateTransaction = session.beginTransaction();
            session.update(accountTransaction);
            hibernateTransaction.commit();
        } catch (Exception e) {
            if (hibernateTransaction != null) {
                hibernateTransaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void deleteTransaction(String transactionId) {
        Transaction hibernateTransaction = null;

        try (Session session = HiberanateUtil.getSessionFactory().openSession()) {
            hibernateTransaction = session.beginTransaction();
            session.delete(getTransaction(transactionId));
            hibernateTransaction.commit();
        } catch (Exception e) {
            if (hibernateTransaction != null) {
                hibernateTransaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public AccountTransaction getTransaction(String transactionId) {
        AccountTransaction transaction = null;
        try (Session session = HiberanateUtil.getSessionFactory().openSession()) {
            transaction = session.get(AccountTransaction.class, transactionId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return transaction;
    }
}
