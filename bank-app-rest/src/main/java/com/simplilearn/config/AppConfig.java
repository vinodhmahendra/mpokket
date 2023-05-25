package com.simplilearn.config;

import com.simplilearn.repository.CustomerRepository;
import com.simplilearn.repository.CustomerRepositoryImpl;
import com.simplilearn.service.CustomerService;
import com.simplilearn.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.simplilearn")
public class AppConfig {

}
