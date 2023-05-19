package com.simplilearn.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name ="customers")
public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany ( mappedBy = "customer" , cascade = CascadeType.ALL,orphanRemoval = true)
    @MapKeyColumn(name = "account_key")
    private Map<Integer,Account> accounts = new HashMap<>();

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public Customer (String f, String l) {
        firstName = f;
        lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount(Integer accountId)
    {
        return this.accounts.get(accountId);
    }

   public void addAccount(Integer accountId,Account account){

        this.accounts.put(accountId,account);
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
