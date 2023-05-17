package com.simplilearn.client;

import com.simplilearn.model.Customer;
import com.simplilearn.model.SavingsAccount;
import com.simplilearn.repository.AccountRepository;
import com.simplilearn.repository.CustomerRepository;
import com.simplilearn.repository.JdbcAccountRepositoryImpl;
import com.simplilearn.repository.JdbcCustomerRepositoryImpl;
import com.simplilearn.tasks.TransactionTask;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestBanking {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        CustomerRepository customerRepository =
                new JdbcCustomerRepositoryImpl();

        AccountRepository accountRepository =
                new JdbcAccountRepositoryImpl();

        try {
            System.out.println("creating the customer chushruth vinodh ");
            Customer customer1 = new Customer("chushruth","vinodh");
            customerRepository.createCustomer(customer1);
            SavingsAccount savingsAccount = new SavingsAccount(500.00,0.03);
            savingsAccount.setID("1");
            customer1.addAccount(savingsAccount.getID(),savingsAccount);
            accountRepository.createAccount(savingsAccount);

            Runnable task1 = new TransactionTask(customer1.getAccount(savingsAccount.getID()));
            executorService.submit(task1);

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
