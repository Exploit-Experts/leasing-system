package com.leasing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.leasing.models.Veiculo;
import com.leasing.repository.VehicleRepository;

@RestController
@RequestMapping("/api/car")
public class CarController {

  @Autowired
  private VehicleRepository vehicleRepository;

  @PutMapping("/{id}")
  public ResponseEntity<?> updateCar(@PathVariable Long id, @RequestBody Veiculo updatedCar) {
    return vehicleRepository.findById(id)
        .map(car -> {
          car.setModelo(updatedCar.getModelo());
          car.setMarca(updatedCar.getMarca());
          car.setAno(updatedCar.getAno());
          car.setPlaca(updatedCar.getPlaca());
          car.setCor(updatedCar.getCor());
          car.setDisponivel(updatedCar.getDisponivel());

          try {
            Veiculo savedCar = vehicleRepository.save(car);
            return ResponseEntity.ok(savedCar);
          } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body("Erro ao atualizar: " + e.getMessage());
          }
        })
        .orElse(ResponseEntity.notFound().build());
  }
}
