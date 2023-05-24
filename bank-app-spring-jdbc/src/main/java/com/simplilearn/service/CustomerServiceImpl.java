package com.simplilearn.service;

import com.simplilearn.event.CustomerAddEvent;
import com.simplilearn.event.CustomerRemoveEvent;
import com.simplilearn.model.Customer;
import com.simplilearn.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements  CustomerService{
    private  CustomerRepository customerRepository;
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository,ApplicationEventPublisher eventPublisher) {
        System.out.println("spring container called constructor to inject 'customerRepository' bean!");
        this.customerRepository = customerRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
        eventPublisher.publishEvent(new CustomerAddEvent(customer));
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

        boolean result = customerRepository.deleteCustomer(id);
        if (result) {
            eventPublisher.publishEvent(new CustomerRemoveEvent(id));
        }

        return result;
    }

    @Override
    public long getCustomerCount() {
        return customerRepository.getCustomerCount();
    }


}
