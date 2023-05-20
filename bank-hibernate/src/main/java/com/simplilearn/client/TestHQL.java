package com.simplilearn.client;

import com.simplilearn.model.Customer;
import com.simplilearn.util.HiberanateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class TestHQL {
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
//        String hql = "FROM Customer";
//        String hql = "FROM Customer C WHERE C.id = 1";
//        String hql = "select C.fistName,C.lastName From Customer C WHERE C.id = :customerId";
        String hql = "UPDATE Customer set firstName= :firstName WHERE id=:customerId";
        Query query = session.createQuery(hql);
        query.setParameter("firstName","Bhavya");
        query.setParameter("customerId",1);

        int result = query.executeUpdate();

//        List<Customer> results = query.getResultList();
//        results.forEach(c-> System.out.println(c.getFirstName()));
        tx.commit();

    }

}
