package com.leasing.controller;

import com.leasing.models.Cliente;
import com.leasing.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class UserController {

    @Autowired
    private ClienteService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/user/create")
    public String createUser(Cliente cliente, Model model) {
        cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
        boolean userCreated = userService.createUser(cliente, model);
        if (userCreated) {
            return "redirect:/store";
        } else {
            return "register";
        }
    }

    @GetMapping("/user/logout")
    public String logout() {
        return "redirect:/";
    }

}
