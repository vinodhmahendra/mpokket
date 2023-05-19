package com.simplilearn.repository;

import com.simplilearn.model.Customer;



public interface CustomerRepository {
    void createCustomer(Customer customer);

    void updateCustomer(Customer customer) ;

    void deleteCustomer(Integer customerId) ;

    Customer getCustomer(Integer customerId) ;
}
