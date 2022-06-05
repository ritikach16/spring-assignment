package com.ritika.springboot.assignment.service;

import com.ritika.springboot.assignment.dao.CustomerRepository;
import com.ritika.springboot.assignment.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository theCustomerRepository) {
        this.customerRepository = theCustomerRepository;
    }


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
