package com.leasing.services;

import com.leasing.models.Cliente;
import com.leasing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean createUser(Cliente cliente, Model model) {
        if (cliente.getEmail() == null || cliente.getEmail().isEmpty() ||
            cliente.getPassword() == null || cliente.getPassword().isEmpty() ||
            cliente.getName() == null || cliente.getName().isEmpty() ||
            cliente.getPhone() == null || cliente.getPhone().isEmpty()) {
                model.addAttribute("errorMessage", "Preencha todos os campos.");
                return false;
        }

        Cliente user = userRepository.findByEmail(cliente.getEmail()).orElse(null);
        if (user != null) {
            model.addAttribute("errorMessage", "Email já cadastrado.");
            return false;
        }
        userRepository.save(cliente);
        return cliente.getId() != null;
    }

    public boolean loginUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).isPresent();
    }

}
