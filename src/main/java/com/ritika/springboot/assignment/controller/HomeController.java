package com.ritika.springboot.assignment.controller;

import com.ritika.springboot.assignment.entity.Item;
import com.ritika.springboot.assignment.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private ItemService itemsService;

    public HomeController(ItemService itemsService){
        this.itemsService = itemsService;
    }

    @GetMapping("/")
    public String showHome(Model model){

        List<Item> itemList = itemsService.findAll();

        model.addAttribute("items",itemList);

        return "customer/customer-items-list";
    }

}
