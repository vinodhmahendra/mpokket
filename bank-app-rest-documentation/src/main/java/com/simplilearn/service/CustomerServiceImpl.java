package com.simplilearn.service;

import com.simplilearn.exception.CustomerNotFoundException;
import com.simplilearn.model.Customer;
import com.simplilearn.repository.CustomerRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service(value = "customerService")
//@Scope(value = "session")
public class CustomerServiceImpl implements  CustomerService{
    private final  CustomerRepository customerRepository;



    public CustomerServiceImpl(CustomerRepository customerRepository) {
        System.out.println("spring container called constructor to inject 'customerRepository' bean!");
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer updateCustomer) {
        return customerRepository.save(updateCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
         customerRepository.deleteById(id);
    }





    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
}
