package com.leasing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class indexController {

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

    @GetMapping("admin")
    public String admin() {
        return "admin";
    }
    
}
