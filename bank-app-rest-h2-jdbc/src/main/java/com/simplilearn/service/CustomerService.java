package com.simplilearn.service;

import com.simplilearn.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {


    void addCustomer(Customer customer);
    List<Customer> getAllCustomers();

    boolean updateCustomer(Customer updateCustomer);

    long getCustomerCount();
    boolean deleteCustomer(Long id);

    Customer getCustomerById(Long id);
}
