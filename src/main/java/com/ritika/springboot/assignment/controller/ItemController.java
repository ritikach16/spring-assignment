package com.ritika.springboot.assignment.controller;

import com.ritika.springboot.assignment.entity.Item;
import com.ritika.springboot.assignment.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    private ItemService itemsService;

    private String form = "items/items-form";

    public ItemController(ItemService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/list")
    public String listItems(Model model){

        List<Item> itemList = itemsService.findAll();

        model.addAttribute("items",itemList);
        return "items/items-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Item item = new Item();
        model.addAttribute("item",item);
        return form;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("item") Item item,
                       BindingResult bindingResult,Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("item",item);
            return form;
        }

            itemsService.save(item);
            return "redirect:/items/list";

    }

    @GetMapping("/showFromForUpdate")
    public String showFromForUpdate(@RequestParam("itemId") int id,
                                    Model model){
        Item item = itemsService.findById(id);
        model.addAttribute("item",item);
        return form;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("itemId") int id){
        itemsService.deleteById(id);

        return "redirect:/items/list";
    }
}
