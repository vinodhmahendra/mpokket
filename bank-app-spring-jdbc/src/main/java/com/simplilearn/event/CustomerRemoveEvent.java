package com.simplilearn.event;

import com.simplilearn.model.Customer;
import org.springframework.context.ApplicationEvent;

public class CustomerRemoveEvent extends ApplicationEvent {
    public CustomerRemoveEvent(Long customerId) {
        super(customerId);
    }

    public Long getCustomerId(){
        return (Long)getSource();
    }
}
