package com.simplilearn.listener;

import com.simplilearn.event.CustomerAddEvent;
import com.simplilearn.event.CustomerRemoveEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CustomerEventListener {


    @EventListener
    public void handleCustomerAddEvent(CustomerAddEvent event)
    {
        System.out.println("Added a new customer: "+event.getCustomer().getName());
    }

    @EventListener
    public void handleCustomerRemoveEvent(CustomerRemoveEvent event) {
        System.out.println("Removed customer with id: " + event.getCustomerId());
    }
}
