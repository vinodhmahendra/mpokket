package com.simplilearn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name must not be empty")
    @Size(min = 2,max = 30, message = "Name must be between 2 and 30 characters")
    private String name;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty(message = "Membership Status must not be empty")
    private String membershipStatus;

    @Past(message = "Date of birth should be in the past")
    private LocalDate dateOfBirth;

    //Default Constructor
    public Customer(){
    }

    public Customer(String name, String email, String membershipStatus, LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        this.membershipStatus = membershipStatus;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}