package com.leasing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leasing.repository.UserRepository;
import com.leasing.repository.VehicleRepository;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("store")
    public String store() {
        return "store";
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("admin")
    public String admin(Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("cars", vehicleRepository.findAll());
        return "admin";
    }
}
