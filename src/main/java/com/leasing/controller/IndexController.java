package com.leasing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.leasing.models.Cliente;
import com.leasing.models.Veiculo;
import com.leasing.repository.ClienteRepository;
import com.leasing.repository.VehicleRepository;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ClienteRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/store")
    public String store(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            Cliente cliente = userRepository.findByEmail(userDetails.getUsername()).orElse(null);
            if (cliente != null) {
                model.addAttribute("user", cliente);
            }
        }

        List<Veiculo> veiculos = vehicleRepository.findAll();
        model.addAttribute("cars", veiculos);

        return "store";
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @GetMapping("admin")
    public String admin(Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("cars", vehicleRepository.findAll());
        return "admin";
    }
}
