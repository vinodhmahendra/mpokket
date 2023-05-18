package com.simplilearn.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Accounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Account_Type")
public abstract class Account implements AccountOperations{

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2" , strategy = "uuid2")
    @Column (name = "id" , columnDefinition = "VARCHAR(255)")
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Column(name = "balance")
    protected double balance;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToMany(mappedBy = "account" , cascade = CascadeType.ALL, orphanRemoval = true)
    protected Set<Transaction> transactions = new HashSet<>();


    //constructor : name == class name
    protected Account(double initBalance) {
        balance = initBalance;
    }

    public double getBalance(){
        return balance;
    }

    protected  void addTransaction (String type, double amount){
        String transactionId  = UUID.randomUUID().toString();
        transactions.add(new Transaction(transactionId,type,amount));
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    //    public abstract boolean withdraw(double amount) ;

//    public abstract boolean deposit(double amount );
}
