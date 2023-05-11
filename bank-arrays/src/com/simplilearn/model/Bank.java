package com.simplilearn.model;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomers;

    public Bank() {
        customers = new Customer[10]; // default size of customers
        numberOfCustomers = 0 ;
    }

    public void addCustomer ( String f, String l) {
        int i = numberOfCustomers ++;
        customers[i] = new Customer(f,l);
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public  Customer getCustomer ( int customer_index){
        return customers[customer_index];
    }
}
