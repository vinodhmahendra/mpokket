package com.simplilearn.config;

import com.simplilearn.model.Customer;
import com.simplilearn.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository){
        return args -> {

            customerRepository.save(new Customer("vinodh","vinodh.mahendra@gmail.com","gold", LocalDate.of(1981,6,17)));
            customerRepository.save(new Customer("chushruth","chushruth@gmail.com","diamond", LocalDate.of(1981,6,17)));
            customerRepository.save(new Customer("samarth","samarth@gmail.com","ruby", LocalDate.of(1981,6,17)));
            customerRepository.save(new Customer("bhavya","bhavya@gmail.com","gold", LocalDate.of(1981,6,17)));
        };
    }
}
