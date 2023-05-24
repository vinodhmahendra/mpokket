package com.simplilearn.repository;

import com.simplilearn.model.Customer;

import java.util.List;

public interface CustomerRepository {

    void addCustomer(Customer customer);
    List<Customer> getAllCustomers();

    boolean updateCustomer(Customer updateCustomer);

    long getCustomerCount();
    boolean deleteCustomer(Long id);
}
