package com.simplilearn.model;

import java.util.Scanner;

public class Bank {
    private static Customer[] customers;
    private static int numberOfCustomers;

    static {
//        Scanner scan = new Scanner(System.in);
// java BankApp -D counter = 1
        customers = new Customer[10]; // default size of customers
        System.out.println("Enter the number to track:");
        numberOfCustomers = 0 ;
    }

    private Bank() {
//    this constructore should never be called
    }


    public static void addCustomer ( String f, String l) {
        int i = numberOfCustomers ++;
        customers[i] = new Customer(f,l);
    }

    public static int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public  static Customer getCustomer ( int customer_index){
        return customers[customer_index];
    }
}
