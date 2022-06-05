package com.ritika.springboot.assignment.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer")
public @Data class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @NotNull(message = "is Required")
    @Size(min = 2, message = "min length of the name should be greater than 2")
    @Pattern(regexp="^[a-zA-Z]", message="only chars")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "is Required")
    @Size(min = 2, message = "min length of the name should be greater than 2")
    @Pattern(regexp="^[a-zA-Z]", message="only chars")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "Email field should not be empty")
    @Email(regexp = "^(.+)@(.+)$", message = "Invalid email address")
    @Column(name = "email")
    private String email;


    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            mappedBy = "customers")
    private List<Item> items = new ArrayList<>();

    public Customer(int id,String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Customer() {
    }

    @Override
    public String toString() {

        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", items =  "+items.toString()+
                '}';
    }

}
