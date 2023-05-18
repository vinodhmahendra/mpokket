package com.simplilearn.client;

import com.simplilearn.model.Customer;
import com.simplilearn.util.HiberanateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

public class TestHibernate {

    private static final Logger logger = LogManager.getLogger(TestHibernate.class);
    public static void main(String[] args) {
        Session session = HiberanateUtil.getSessionFactory().openSession();
        logger.error("configuration works");

        session.beginTransaction();
        Customer customer = new Customer("Vinodh","Kumar");

        session.save(customer);

        session.getTransaction().commit();
        session.close();

    }
}
