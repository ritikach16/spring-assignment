package com.ritika.springboot.assignment.service;

import com.ritika.springboot.assignment.entity.Item;

import java.util.List;

public interface ItemService {
    public List<Item> findAll();

    public Item findById(int theId);

    public void save(Item theItem);

    public void deleteById(int theId);
}
