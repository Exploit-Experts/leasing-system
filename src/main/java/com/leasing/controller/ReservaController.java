package com.leasing.controller;

import com.leasing.models.Cliente;
import com.leasing.models.Reserva;
import com.leasing.models.Veiculo;
import com.leasing.repository.ClienteRepository;
import com.leasing.repository.ReservaRepository;
import com.leasing.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ClienteRepository userRepository;

    @Autowired
    private VehicleRepository veiculoRepository;

    @PostMapping("/create")
    public String createReserva(@RequestBody Reserva reserva) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            Cliente cliente = userRepository.findByEmail(userDetails.getUsername()).orElse(null);
            if (cliente != null) {
                reserva.setCliente(cliente);

                Optional<Veiculo> veiculoOpt = veiculoRepository.findByPlaca(reserva.getVeiculo().getPlaca());
                if (veiculoOpt.isPresent() && veiculoOpt.get().getDisponivel()) {
                    Veiculo veiculo = veiculoOpt.get();
                    veiculo.setDisponivel(false);
                    veiculoRepository.save(veiculo); 

                    reserva.setVeiculo(veiculo);
                    reserva.setDataInicio(LocalDate.parse(reserva.getDataInicio().toString()));
                    reserva.setDataFim(LocalDate.parse(reserva.getDataFim().toString()));
                    reservaRepository.save(reserva);
                    return "Reserva realizada com sucesso!";
                } else {
                    return "Veículo não disponível ou não encontrado.";
                }
            }
        }
        return "Usuário não autenticado.";
    }
}
