package com.leasing.services;

import com.leasing.models.Cliente;
import com.leasing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

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
        return true;

    }

    public boolean loginUser(String email, String password) {
        logger.info("Attempting to log in user with email: {}", email);
        Optional<Cliente> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            Cliente user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                logger.info("User authenticated successfully");
                return true;
            } else {
                logger.warn("Password does not match for user with email: {}", email);
            }
        } else {
            logger.warn("No user found with email: {}", email);
        }
        return false;
    }

}
