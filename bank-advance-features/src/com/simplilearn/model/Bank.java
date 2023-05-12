package com.simplilearn.model;

public class Bank {
    private static Customer[] customers;
    private static int numberOfCustomers;

    static {
        customers = new Customer[10]; // default size of customers
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
