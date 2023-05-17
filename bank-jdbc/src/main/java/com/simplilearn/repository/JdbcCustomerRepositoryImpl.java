package com.simplilearn.repository;

import com.simplilearn.model.Account;
import com.simplilearn.model.CheckingAccount;
import com.simplilearn.model.Customer;
import com.simplilearn.model.SavingsAccount;
import com.simplilearn.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcCustomerRepositoryImpl implements CustomerRepository {
    private ConnectionFactory connectionFactory;

    public JdbcCustomerRepositoryImpl(){
        this.connectionFactory = ConnectionFactory.getInstance();
    }


    @Override
    public void createCustomer(Customer customer) throws SQLException {
        String sql  = "INSERT INTO Customers (FirstName,LastName) VALUES (?,?)";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, customer.getFirstName());
            ps.setString(2,customer.getLastName());

            ps.executeUpdate();
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        String sql  = "UPDATE Customers SET FirstName = ?, LastName = ? WHERE ID = ? ";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1,customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setInt(3,customer.getId());

            ps.executeUpdate();
        }
    }

    @Override
    public void deleteCustomer(Integer customerId) throws SQLException {
        String sql  = "DELETE FROM Customers WHERE ID = ? ";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, customerId);
            ps.executeUpdate();
        }
    }



    @Override
    public Customer getCustomer(Integer customerId) throws SQLException {
        String sql = "SELECT * FROM Customers WHERE ID=?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();

            if ( rs.next()) {
                Customer customer = new Customer(rs.getString("FirstName"),rs.getString("LastName"));
                customer.setId(rs.getInt("ID"));
                return customer;

            }else {
                return  null;
            }
        }
    }
}
