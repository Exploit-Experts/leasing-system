package com.leasing.controllers;

import com.leasing.models.Veiculo;
import com.leasing.repository.UserRepository;
import com.leasing.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/car/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        vehicleRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/car/create")
    public ResponseEntity<?> createCar(@RequestBody Veiculo veiculo) {
        try {
            if (vehicleRepository.findByPlaca(veiculo.getPlaca()).isPresent()) {
                return ResponseEntity.badRequest().body("Já existe um veículo com esta placa");
            }
            
            Veiculo saved = vehicleRepository.save(veiculo);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao criar veículo: " + e.getMessage());
        }
    }
}
