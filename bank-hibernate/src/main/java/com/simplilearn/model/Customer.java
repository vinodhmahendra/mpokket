package com.simplilearn.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name ="customers")
public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
    private Map<String,Account> accounts = new HashMap<>();
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

    public Account getAccount(String accountId)
    {
        return this.accounts.get(accountId);
    }

   public void addAccount(String accountId,Account account){
        this.accounts.put(accountId,account);
   }
}
