package com.simplilearn.repository;

import com.simplilearn.model.Customer;
import com.simplilearn.model.Transaction;
import com.simplilearn.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTransactionRepositoryImpl implements TransactionRepository {
    private ConnectionFactory connectionFactory;

    public JdbcTransactionRepositoryImpl(){
        this.connectionFactory = ConnectionFactory.getInstance();
    }


    @Override
    public void createTransaction(Transaction transaction) throws SQLException {
        String sql  = "INSERT INTO Transactions (ID, Type, Amount) VALUES (?,?,?)";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, transaction.getTransactionId());
            ps.setString(2,transaction.getType());
            ps.setDouble(3,transaction.getAmount());

            ps.executeUpdate();
        }
    }

    @Override
    public void updateTransaction(Transaction transaction) throws SQLException {
        String sql  = "UPDATE Transactions SET Type = ?, Amount = ? WHERE ID = ? ";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1,transaction.getType());
            ps.setDouble(2, transaction.getAmount());
            ps.setString(3,transaction.getTransactionId());

            ps.executeUpdate();
        }
    }

    @Override
    public void deleteTransaction(String transactionId) throws SQLException {
        String sql  = "DELETE FROM Transactions WHERE ID = ? ";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, transactionId);
            ps.executeUpdate();
        }
    }



    @Override
    public Transaction getTransaction(String transactionId)  throws SQLException {
        String sql = "SELECT * FROM Transactions WHERE ID=?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, transactionId);

            ResultSet rs = ps.executeQuery();

            if ( rs.next()) {
                String type = rs.getString("Type");
                double amount = rs.getDouble("Amount");

                Transaction transaction = new Transaction(transactionId,type,amount);
                return transaction;
            }else {
                return  null;
            }
        }
    }
}
