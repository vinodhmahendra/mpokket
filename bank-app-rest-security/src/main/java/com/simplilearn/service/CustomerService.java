package com.simplilearn.service;

import com.simplilearn.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {


    Customer addCustomer(Customer customer);
    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer updateCustomer);


    void deleteCustomer(Long id);

    Optional<Customer> getCustomerById(Long id);
}
