package com.leasing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller(value = "/")
public class indexController {

    public String index() {
        return "index";
    }

    @RequestMapping(value="store", method= RequestMethod.GET)
    public String about() {
        return "store";
    }

    @RequestMapping(value="register", method= RequestMethod.GET)
    public String create() {
        return "register";
    }

}
