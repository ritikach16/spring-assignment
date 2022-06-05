package com.ritika.springboot.assignment.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="employee")
public @Data class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message = "is Required")
    @Size(min = 2, message = "min length of the name should be greater than 2")
    @Column(name="first_name")
    private String firstName;

    @NotNull(message = "is Required")
    @Size(min = 2, message = "min length of the name should be greater than 2")
    @Column(name="last_name")
    private String lastName;

    @NotNull(message = "Email field should not be empty")
    @Email(regexp = "^(.+)@(.+)$", message = "Invalid email address")
    @Column(name="email")
    private String email;

    public Employee() {

    }

    @NotNull(message = "is Required")
    @OneToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "username")
    private User username;

    public Employee(int id, String firstName, String lastName, String email, User username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
    }


    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }

}
