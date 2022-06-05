package com.ritika.springboot.assignment.controller;

import com.ritika.springboot.assignment.entity.Authority;
import com.ritika.springboot.assignment.entity.User;
import com.ritika.springboot.assignment.service.UserService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/showMyRegistrationForm")
    public String register(Model model){
        User user = new User();
        model.addAttribute("users",user);
        return "registration";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("users") User user){
        List<Authority> authorityList = new ArrayList<>();
        authorityList.add(new Authority(user,"ROLE_USER"));
        String password = user.getPassword();
        String hashPassword = "{bcrypt}" + BCrypt.hashpw(password, BCrypt.gensalt());
        user.setPassword(hashPassword);
        user.setAuthorities(authorityList);
        userService.save(user);
        return "redirect:/showMyLoginPage";
    }
}
