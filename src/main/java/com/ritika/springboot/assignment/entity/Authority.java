package com.ritika.springboot.assignment.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public @Data class Authority {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "authority")
    private String role = "ROLE_USER";
    public Authority() {

    }

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "username")
    private User user;


    public Authority(User user, String role) {
        this.user = user;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", user=" + user +
                '}';
    }
}

