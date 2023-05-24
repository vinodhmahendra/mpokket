package com.simplilearn.event;

import com.simplilearn.model.Customer;
import org.springframework.context.ApplicationEvent;

public class CustomerAddEvent extends ApplicationEvent {
    public CustomerAddEvent(Customer customer) {
        super(customer);
    }

    public Customer getCustomer(){
        return (Customer)getSource();
    }
}
