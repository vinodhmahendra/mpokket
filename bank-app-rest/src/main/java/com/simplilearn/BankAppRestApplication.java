package com.simplilearn;

import com.simplilearn.model.Customer;
import com.simplilearn.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class BankAppRestApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(BankAppRestApplication.class, args);


	}

}
