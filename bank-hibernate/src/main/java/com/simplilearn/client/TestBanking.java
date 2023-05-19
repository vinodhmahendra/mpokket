package com.simplilearn.client;

import com.simplilearn.model.Account;
import com.simplilearn.model.CheckingAccount;
import com.simplilearn.model.Customer;
import com.simplilearn.model.SavingsAccount;
import com.simplilearn.repository.AccountRepository;
import com.simplilearn.repository.AccountRepositoryImpl;
import com.simplilearn.repository.CustomerRepository;
import com.simplilearn.repository.CustomerRepositoryImpl;
import com.simplilearn.util.HiberanateUtil;
import org.hibernate.Session;

import java.util.Map;

public class TestBanking {
    public static void main(String[] args) {

        Session session = HiberanateUtil.getSessionFactory().openSession();
        CustomerRepository customerRepository =
                new CustomerRepositoryImpl(session);
        AccountRepository accountRepository =
                new AccountRepositoryImpl(session);


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

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
             session.close();
             HiberanateUtil.shutDown();
        }
        }
    }