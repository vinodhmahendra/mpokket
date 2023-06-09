package com.simplilearn.service;

import com.simplilearn.model.Customer;
import com.simplilearn.repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements  CustomerService{
    private  CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public boolean updateCustomer(Customer updateCustomer) {
        return customerRepository.updateCustomer(updateCustomer);
    }

    @Override
    public boolean deleteCustomer(Long id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public long getCustomerCount() {
        return customerRepository.getCustomerCount();
    }
}
