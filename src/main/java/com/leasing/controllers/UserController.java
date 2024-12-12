package com.leasing.controllers;

import com.leasing.models.Cliente;
import com.leasing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/create")
    public String createUser(@ModelAttribute Cliente cliente, Model model) {
        boolean userCreated = userService.createUser(cliente, model);
        if (userCreated) {
            return "redirect:/store";
        } else {
            return "register";
        }
        
    }

    @PostMapping("/user/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        boolean isUserFound = userService.loginUser(email, password);
        if (isUserFound) {
            return "redirect:/store";
        } else {
            model.addAttribute("errorMessage", "Email ou senha incorretos.");
            return "index";
        }
    }
}
