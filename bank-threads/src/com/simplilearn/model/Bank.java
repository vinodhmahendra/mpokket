package com.simplilearn.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
//    private static Customer[] customers; old code
    private static List<Customer> customers;


    static {
//        customers = new Customer[10]; // default size of customers old code
        customers = new ArrayList<>();
    }

    private Bank() {
//    this constructore should never be called
    }


    public static void addCustomer ( String f, String l) {
      customers.add(new Customer(f,l));
    }

    public static int getNumberOfCustomers() {
        return customers.size();
    }

    public  static Customer getCustomer ( int customer_index){
        return customers.get(customer_index);
    }
}
