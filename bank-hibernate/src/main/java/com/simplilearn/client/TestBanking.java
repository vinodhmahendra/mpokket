package com.simplilearn.client;

import com.simplilearn.model.Account;
import com.simplilearn.model.CheckingAccount;
import com.simplilearn.model.Customer;
import com.simplilearn.model.SavingsAccount;
import com.simplilearn.repository.*;
import com.simplilearn.tasks.TransactionTask;
import com.simplilearn.util.HiberanateUtil;
import org.hibernate.Session;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestBanking {
    public static void main(String[] args) {

        Session session = HiberanateUtil.getSessionFactory().openSession();
        CustomerRepository customerRepository =
                new CustomerRepositoryImpl(session);
        AccountRepository accountRepository =
                new AccountRepositoryImpl(session);

        TransactionRepository transactionRepository =
                new TransactionRepositoryImpl(session);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try{

            Customer aCustomer = new Customer("Chushruth","Vinodh");
            SavingsAccount savingsAccount = new SavingsAccount(500,0.003);

            accountRepository.createAccount(savingsAccount);

            CheckingAccount checkingAccount = new CheckingAccount(1000);
            accountRepository.createAccount(checkingAccount);

            savingsAccount.setCustomer(aCustomer);
            checkingAccount.setCustomer(aCustomer);


            aCustomer.addAccount(savingsAccount.getID(),savingsAccount);
            aCustomer.addAccount(checkingAccount.getID(),checkingAccount);
//
            customerRepository.createCustomer(aCustomer);

            Runnable transactionTask  = new TransactionTask(savingsAccount,transactionRepository);

            Thread thread = new Thread(transactionTask);
            executorService.submit(transactionTask);
            thread.join();


        }catch (Exception e) {
            e.printStackTrace();
        }finally {
//             session.close();
//             HiberanateUtil.shutDown();
             executorService.shutdown();
        }
        }
    }