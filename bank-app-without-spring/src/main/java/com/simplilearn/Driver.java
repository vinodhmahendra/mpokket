package com.simplilearn;

import com.simplilearn.model.Customer;
import com.simplilearn.repository.CustomerRepository;
import com.simplilearn.repository.CustomerRepositoryImpl;
import com.simplilearn.service.CustomerService;
import com.simplilearn.service.CustomerServiceImpl;

import java.time.LocalDate;

public class Driver {

    public static void main(String[] args) {
        CustomerRepository customerRepository =
                new CustomerRepositoryImpl();

        CustomerService customerService =
                new CustomerServiceImpl(customerRepository);

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
