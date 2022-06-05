package com.ritika.springboot.assignment.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name =  "users")
public @Data class User {
    @Id
    @Column(name = "username")
    private String username;

    @NotNull(message = "is Required")
    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private int enabled = 1;

    @OneToMany(mappedBy = "user",
            cascade = { CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Authority> authorities;

    public User() {

    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
