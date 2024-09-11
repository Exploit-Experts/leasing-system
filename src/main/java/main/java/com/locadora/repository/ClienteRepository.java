package main.java.com.locadora.repository;

import java.util.ArrayList;
import java.util.List;

import main.java.com.locadora.models.Cliente;

public class ClienteRepository {

    private static List<Cliente> clientes = new ArrayList<>();

    public static void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }
}