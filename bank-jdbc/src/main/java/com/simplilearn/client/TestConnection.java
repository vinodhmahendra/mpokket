package com.simplilearn.client;

import com.simplilearn.util.ConnectionFactory;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        System.out.println("connected to database!! Bank");
    }
}
