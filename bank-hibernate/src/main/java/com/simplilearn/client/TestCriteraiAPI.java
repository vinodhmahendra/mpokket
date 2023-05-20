package com.simplilearn.client;

import com.simplilearn.model.Customer;
import com.simplilearn.util.HiberanateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TestCriteraiAPI {
    public static void main(String[] args) {
        Session session = HiberanateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        Customer customer1 = new Customer("chushruth","vinodh");
        Customer customer2 = new Customer("samarth","vishnu");


        session.save(customer1);
        session.save(customer2);

        tx.commit();
        session.close();


        session = HiberanateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);

        Root<Customer> root = query.from(Customer.class);

        query.select(root).where(builder.equal(root.get("lastName"),"Vinodh"));

        Query<Customer> q = session.createQuery(query);

        List<Customer> customers = q.getResultList();

        tx.commit();
        session.close();

        for ( Customer customer : customers) {
            System.out.println(customer.getFirstName());
        }
    }

}
