package com.ritika.springboot.assignment.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="item")
public @Data class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    @NotNull(message = "is Required")
    @Size(min = 2, message = "min length of the name should be greater than 2")
    @Column(name = "name")
    private String name;

    @NotNull(message = "is Required")
    @Column(name = "price")
    private int price;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "items_customer",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> customers = new ArrayList<>();

    public Item(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Item() {
    }

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
