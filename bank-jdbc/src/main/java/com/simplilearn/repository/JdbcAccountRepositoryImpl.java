package com.simplilearn.repository;

import com.simplilearn.model.Account;
import com.simplilearn.model.CheckingAccount;
import com.simplilearn.model.SavingsAccount;
import com.simplilearn.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcAccountRepositoryImpl implements AccountRepository {
    private ConnectionFactory connectionFactory;

    public JdbcAccountRepositoryImpl(){
        this.connectionFactory = ConnectionFactory.getInstance();
    }


    @Override
    public void createAccount(Account account) throws SQLException {
        String sql  = "INSERT INTO Accounts (ID,Balance) VALUES (?,?)";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, account.getID());
            ps.setDouble(2,account.getBalance());

            ps.executeUpdate();
        }
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        String sql  = "UPDATE Accounts SET Balance = ? WHERE ID = ? ";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setDouble(1,account.getBalance());
            ps.setString(2, account.getID());


            ps.executeUpdate();
        }
    }

    @Override
    public void deleteAccount(String accountId) throws SQLException {
        String sql  = "DELETE FROM Accounts WHERE ID = ? ";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, accountId);
            ps.executeUpdate();
        }
    }



    @Override
    public Account getAccount(String accountId) throws SQLException {
        String sql = "SELECT * FROM Accounts WHERE ID=?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, accountId);

            ResultSet rs = ps.executeQuery();

            if ( rs.next()) {
                double balance  = rs.getDouble("Balance");

                // check a type
                String accountType = rs.getString("TYPE");

                if ( "SAVINGS".equalsIgnoreCase(accountType)){
                    double interestRate = rs.getDouble("InterestRate");
                    Account account = new SavingsAccount(balance,interestRate);
                    account.setID(accountId);
                    return account;
                }else if ( "CHECKING".equalsIgnoreCase(accountType)){
                    double overdraftAmount = rs.getDouble("OverdraftAmount");
                    Account account = new CheckingAccount(balance,overdraftAmount);
                    account.setID(accountId);
                    return account;
                }else {
                    return null;
                }

            }else {
                return  null;
            }
        }
    }
}
