package com.simplilearn.service;

import com.simplilearn.model.Customer;
import com.simplilearn.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements  CustomerService{
    private  CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        System.out.println("spring container called constructor to inject 'customerRepository' bean!");
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
