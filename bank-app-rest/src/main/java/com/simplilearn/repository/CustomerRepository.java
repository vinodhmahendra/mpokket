package com.simplilearn.repository;

import com.simplilearn.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    void addCustomer(Customer customer);
    List<Customer> getAllCustomers();

    boolean updateCustomer(Customer updateCustomer);

    long getCustomerCount();
    boolean deleteCustomer(Long id);

    Optional<Customer> getCustomerById(Long id);
}
