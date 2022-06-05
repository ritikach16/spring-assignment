package com.ritika.springboot.assignment.controller;

import com.ritika.springboot.assignment.entity.Item;
import com.ritika.springboot.assignment.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private ItemService itemsService;
    private List<Item> cartList = new ArrayList<>();


    public CustomerController(ItemService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/list")
    public String listItems(Model model){

        List<Item> itemList = itemsService.findAll();

        model.addAttribute("items",itemList);

        return "customer/customer-items-list";
    }
    @GetMapping("/buy")
    public String buy(@RequestParam("itemId") int item_id,
                      Model model){

        Item item = itemsService.findById(item_id);
        model.addAttribute("item",item);

        return "customer/customer-conformation";
    }

    @GetMapping("/items/list/addCart")
    public String buyItems(@RequestParam("itemId") int item_id,
                           Model model){

        Item item = itemsService.findById(item_id);
        cartList.add(item);
        model.addAttribute("carts",cartList);

        if(item == null || item_id < 0){
            throw new RuntimeException("item id not found -"+item_id);
        }
        return "carts";
    }

}
