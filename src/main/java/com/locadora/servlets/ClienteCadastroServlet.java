package com.locadora.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.locadora.models.Cliente;
import com.locadora.models.Reserva;
import com.locadora.models.Veiculo;
import com.locadora.repository.ClienteRepository;
import com.locadora.repository.ReservaRepository;
import com.locadora.repository.VeiculoRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/cadastrarCliente")
public class ClienteCadastroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	List<Veiculo> veiculosDisponiveis = VeiculoRepository.listarDisponiveis();

        request.setAttribute("veiculos", veiculosDisponiveis);
        
        request.getRequestDispatcher("/WEB-INF/pages/cadastrarCliente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String placa = request.getParameter("placa");
        LocalDate dataDevolucao = LocalDate.parse(request.getParameter("dataDevolucao"));

        Cliente cliente = new Cliente(nome, endereco, email, telefone);
        ClienteRepository.adicionarCliente(cliente);

        Veiculo veiculo = VeiculoRepository.buscarPorPlaca(placa);
        if(veiculo != null && veiculo.getPlaca().equalsIgnoreCase(placa)) {
            Reserva reserva = new Reserva(cliente, veiculo, LocalDate.now(), dataDevolucao);
            ReservaRepository.adicionar(reserva);
            
            System.out.println(reserva);
            
            VeiculoRepository.atualizarDisponibilidade(placa, false);
        }

        
        response.sendRedirect(request.getContextPath() + "/verReservas");
    }
}