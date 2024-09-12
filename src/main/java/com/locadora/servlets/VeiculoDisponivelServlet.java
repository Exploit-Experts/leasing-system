package com.locadora.servlets;

import com.locadora.models.Cliente;
import com.locadora.models.Veiculo;
import com.locadora.repository.VeiculoRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/veiculoDisponivel")
public class VeiculoDisponivelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");

        Cliente cliente = new Cliente(nome, endereco, email, telefone);
        
        request.getSession().setAttribute("cliente", cliente);

        List<Veiculo> veiculos = VeiculoRepository.listarDisponiveis();

        request.setAttribute("veiculos", veiculos);

        request.getRequestDispatcher("/WEB-INF/pages/veiculosDisponiveis.jsp").forward(request, response);
    }
}

