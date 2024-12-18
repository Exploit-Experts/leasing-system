package com.leasing.controller;

import com.leasing.models.Cliente;
import com.leasing.models.Veiculo;
import com.leasing.repository.ClienteRepository;
import com.leasing.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private ClienteRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @DeleteMapping("/api/user/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) {
        try {
            Cliente user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            if (!user.getReservas().isEmpty()) {
                return ResponseEntity.badRequest()
                    .body("Não é possível excluir usuário com reservas ativas");
            }

            userRepository.delete(user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body("Erro ao deletar usuário: " + e.getMessage());
        }
    }

    @DeleteMapping("/api/car/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        try {
            Veiculo car = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

            if (!car.getReservas().isEmpty()) {
                return ResponseEntity.badRequest()
                    .body("Não é possível excluir veículo com reservas ativas");
            }

            vehicleRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body("Erro ao deletar veículo: " + e.getMessage());
        }
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
