package com.simplilearn.repository;

import com.simplilearn.model.Customer;

import java.sql.SQLException;

public interface CustomerRepository {
    void createCustomer(Customer customer) throws SQLException;

    void updateCustomer(Customer customer) throws SQLException;

    void deleteCustomer(Integer customerId) throws SQLException;

    Customer getCustomer(Integer customerId) throws SQLException;
}
