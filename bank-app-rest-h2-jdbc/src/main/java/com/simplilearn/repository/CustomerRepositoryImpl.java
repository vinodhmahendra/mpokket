package com.simplilearn.repository;

import com.simplilearn.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("customerRepository")
public class CustomerRepositoryImpl implements  CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public CustomerRepositoryImpl(){

    }

    @Override
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customers (id,name,email,MEMBERSHIPSTATUS,DATEOFBIRTH) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql,customer.getId(),customer.getName(),customer.getEmail(),customer.getMembershipStatus(),customer.getDateOfBirth());
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "select * from customers";
        return jdbcTemplate.query(sql,new CustomerRowMapper());
    }

    @Override
    public long getCustomerCount() {
        return this.jdbcTemplate.queryForObject("select count(*) from customers", Long.class);
    }

    @Override
    public boolean updateCustomer(Customer updateCustomer) {
        String sql = "update customers set name = ? where email = ?";
        int result = this.jdbcTemplate.update(sql ,updateCustomer.getName(), updateCustomer.getEmail());
        if ( result > 0 ){
            return  true;
        }
            return false;
    }

       public boolean deleteCustomer(Long id) {
          int result =  this.jdbcTemplate.update(
                   "delete from customers where id = ?",
                   Long.valueOf(id));
          if ( result > 0) {
              return true;
          }else {
              return false;
       }
    }
    private static class CustomerRowMapper implements RowMapper<Customer>{

        @Override
        public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setId(resultSet.getLong("id"));
            customer.setName(resultSet.getString("name"));
            customer.setEmail(resultSet.getString("email"));
            customer.setMembershipStatus(resultSet.getString("MEMBERSHIPSTATUS"));
            customer.setDateOfBirth(resultSet.getDate("DATEOFBIRTH").toLocalDate());
            return customer;
        }
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return Optional.empty();
    }
}
