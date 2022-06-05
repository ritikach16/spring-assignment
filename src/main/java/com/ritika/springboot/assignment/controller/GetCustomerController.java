package com.ritika.springboot.assignment.controller;

import com.ritika.springboot.assignment.entity.Customer;
import com.ritika.springboot.assignment.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/get")
public class GetCustomerController {
    private CustomerService customerService;

    public GetCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String customersList(Model model){

        List<Customer> customers = customerService.findAll();

        model.addAttribute("customers",customers);
        return "customer/customer-list";
    }

    @Override
    public String toString() {
        return "GetCustomersController{" +
                "customerService=" + customerService +
                '}';
    }
}
