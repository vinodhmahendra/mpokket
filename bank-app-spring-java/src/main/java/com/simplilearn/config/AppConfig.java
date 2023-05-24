package com.simplilearn.config;

import com.simplilearn.repository.CustomerRepository;
import com.simplilearn.repository.CustomerRepositoryImpl;
import com.simplilearn.service.CustomerService;
import com.simplilearn.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "customerRepository")
    public CustomerRepository customerRepository() {
        return new CustomerRepositoryImpl();
    }

    @Bean(name = "customerService")
    public CustomerService customerService() {
        CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository());
        return  customerService;
    }
}
