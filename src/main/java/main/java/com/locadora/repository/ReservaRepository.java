package main.java.com.locadora.repository;


import main.java.com.locadora.models.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaRepository {
    private static final List<Reserva> reservas = new ArrayList<>();

    // Adicionar uma reserva
    public static void adicionar(Reserva reserva) {
        reservas.add(reserva);
    }

    // Listar todas as reservas
    public static List<Reserva> listarTodos() {
        return reservas;
    }
}
