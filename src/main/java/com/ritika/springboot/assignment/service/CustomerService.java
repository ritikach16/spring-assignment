package com.ritika.springboot.assignment.service;

import com.ritika.springboot.assignment.entity.Customer;

import java.util.List;

public interface CustomerService {
//    public void save(Customer customer);
    public List<Customer> findAll();
}
