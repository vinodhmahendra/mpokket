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

		//retrieve a bean from container
		CustomerService customerService = context.getBean("customerService",CustomerService.class);


//		CustomerService customerService1 =
//				context.getBean("customerService",CustomerService.class);
//		CustomerService customerService2 =
//				context.getBean("customerService",CustomerService.class);

		Customer newCustomer =
				new Customer(5L, "Vrushali", "vrushali@gmail.com", "gold", LocalDate.of(1987, 7, 18));

		customerService.addCustomer(newCustomer);

		System.out.println("All Customers");
		for (Customer customer : customerService.getAllCustomers()) {
			System.out.println(customer.getEmail());
		}
	}

}
