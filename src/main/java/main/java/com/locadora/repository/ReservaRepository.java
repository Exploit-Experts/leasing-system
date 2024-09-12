package main.java.com.locadora.repository;

import main.java.com.locadora.models.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaRepository {
    private static List<Reserva> reservas = new ArrayList<>();

    
    public static void adicionar(Reserva reserva) {
        reservas.add(reserva);
    }

    public static List<Reserva> listarReservas() {
    	System.out.println("Listando reservas: " + reservas);
        return new ArrayList<>(reservas);
    }
}
