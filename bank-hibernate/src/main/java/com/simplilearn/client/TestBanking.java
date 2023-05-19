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
            CheckingAccount checkingAccount = new CheckingAccount(1000);
            savingsAccount.setCustomer(aCustomer);
            checkingAccount.setCustomer(aCustomer);

            aCustomer.addAccount(savingsAccount.getID(),savingsAccount);
//            aCustomer.addAccount(checkingAccount.getID(),checkingAccount);

            Map<String,Account> map = aCustomer.getAccounts();

            System.out.println(" this is map :" +map);

//            customerRepository.createCustomer(aCustomer);
//            accountRepository.createAccount(savingsAccount);
//            accountRepository.createAccount(checkingAccount);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
             session.close();
             HiberanateUtil.shutDown();
        }
        }
    }