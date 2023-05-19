package com.simplilearn.repository;

import com.simplilearn.model.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class CustomerRepositoryImpl implements  CustomerRepository{

    private Session session;

    public  CustomerRepositoryImpl(Session session){
        this.session = session;
    }
    @Override
    public void createCustomer(Customer customer)  {
        Transaction tx = session.beginTransaction(); // provide by hibernate
        session.save(customer);
        tx.commit();
    }

    @Override
    public void updateCustomer(Customer customer) {
        Transaction tx = session.beginTransaction(); // provide by hibernate
        session.update(customer);
        tx.commit();
    }

    @Override
    public void deleteCustomer(Integer customerId)  {
        Transaction tx = session.beginTransaction(); // provide by hibernate
        Customer loadedCusomer = getCustomer(customerId);
        session.delete(loadedCusomer);
        tx.commit();
    }

    @Override
    public Customer getCustomer(Integer customerId)  {
        return session.get(Customer.class,customerId);
    }
}
