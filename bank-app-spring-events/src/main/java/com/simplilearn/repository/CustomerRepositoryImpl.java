package com.simplilearn.repository;

import com.simplilearn.model.Customer;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements  CustomerRepository {
    private List<Customer> customers = new ArrayList<>();
    private long customerCount = 0;

    public CustomerRepositoryImpl(){
        customers.add(new Customer(1L,"vinodh","vinodh.mahendra@gmail.com","gold", LocalDate.of(1981,6,17)));
        customers.add(new Customer(2L,"Chushruth","chushruth@gmail.com","diamond", LocalDate.of(1981,6,17)));
        customers.add(new Customer(3L,"Samarth","samarth@gmail.com","ruby", LocalDate.of(1981,6,17)));
        customers.add(new Customer(4L,"bhavay","bhavya@gmail.com","silver", LocalDate.of(1981,6,17)));
        customerCount = customers.size();
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
        customerCount++;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }

    @Override
    public long getCustomerCount() {
        return customerCount;
    }

    @Override
    public boolean updateCustomer(Customer updateCustomer) {
        for (int  i = 0 ; i < customers.size() ; i++) {
            if ( customers.get(i).getId().equals(updateCustomer.getId())){
                customers.set(i,updateCustomer);
                return true;
            }
        }
            return false;
    }

       public boolean deleteCustomer(Long id) {
        Optional<Customer> customerOptional = customers.stream()
                .filter(customer -> customer.getId().equals(id)).findFirst();
        if ( customerOptional.isPresent() ){
            customers.remove(customerOptional.get());
            customerCount --;
            return true;
        }
        return false;
    }
}
