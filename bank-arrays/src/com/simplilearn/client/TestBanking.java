package com.simplilearn.client;

import com.simplilearn.model.Account;
import com.simplilearn.model.Bank;
import com.simplilearn.model.Customer;

public class TestBanking {
    public static void main(String[] args) {

        Bank simplilearnBank = new Bank();
        simplilearnBank.addCustomer("Samarth","vishnu");
        simplilearnBank.addCustomer("chushruth", "vinodh");
        simplilearnBank.addCustomer("vinodh","mahendra");

        Customer customer = simplilearnBank.getCustomer(1);
//        customer.setAccount();
        System.out.println("Customer  [ "+customer.getFirstName() + " , " + customer.getLastName() + " ] "  );


    }
}
