package com.simplilearn;

import com.simplilearn.model.Customer;
import com.simplilearn.repository.CustomerRepository;
import com.simplilearn.repository.CustomerRepositoryImpl;
import com.simplilearn.service.CustomerService;
import com.simplilearn.service.CustomerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class Driver {

    public static void main(String[] args) {

        //spring container
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");


        //retrieve a bean from container
        CustomerService customerService = context.getBean("customerService",CustomerService.class);


        Customer newCustomer =
                new Customer(5L, "Vrushali", "vrushali@gmail.com", "gold", LocalDate.of(1987, 7, 18));

        customerService.addCustomer(newCustomer);

        System.out.println("All Customers");
        for (Customer customer : customerService.getAllCustomers()){
            System.out.println(customer.getEmail());
        }


        Customer updatedCustomer =
                new Customer(1L,"vinodh","vinodh.mahendra@gmail.com","Platinum", LocalDate.of(1981,6,17));
        customerService.updateCustomer(updatedCustomer);

        customerService.deleteCustomer(2L);

        System.out.println("Number of customers:" + customerService.getCustomerCount());

    }
}
