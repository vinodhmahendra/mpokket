package com.simplilearn.repository;

import com.simplilearn.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
//    List<Customer> findByName(String name);
//
//    Customer findByNameAndEmail(String name,String email);

//    @Query("SELECT c FROM Customer c WHERE c.name = :name")
//    List<Customer> findCustomerWithName(@Param("name") String name);

    @Query(value = "SELECT  FROM customers  WHERE name = :name",nativeQuery = true)
    List<Customer> findCustomerWithName(@Param("name") String name);
}
