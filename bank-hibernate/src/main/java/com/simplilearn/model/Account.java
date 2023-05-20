package com.simplilearn.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Accounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Account_Type")
public abstract class Account implements AccountOperations{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer ID;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    @Column(name = "balance")
    protected double balance;

    @ManyToOne
    @JoinColumn(name = "customer_id",insertable = false,updatable = false)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToMany(mappedBy = "account" , cascade = CascadeType.ALL, orphanRemoval = true)
    protected Set<AccountTransaction> accountTransactions = new HashSet<>();


    //constructor : name == class name
    protected Account(double initBalance) {
        balance = initBalance;
    }

    public double getBalance(){
        return balance;
    }

    protected  void addTransaction (String type, double amount){
        String transactionId  = UUID.randomUUID().toString();
        accountTransactions.add(new AccountTransaction(transactionId,type,amount));
    }

    public Set<AccountTransaction> getTransactions() {
        return accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(ID, account.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

//    public abstract boolean withdraw(double amount) ;

//    public abstract boolean deposit(double amount );
}
