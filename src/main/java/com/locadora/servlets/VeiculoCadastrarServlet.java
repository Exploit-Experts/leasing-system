package com.locadora.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.locadora.models.Veiculo;
import com.locadora.repository.VeiculoRepository;
import java.io.IOException;

@WebServlet("/cadastrarVeiculo")
public class VeiculoCadastrarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request.getRequestDispatcher("/WEB-INF/pages/cadastrarVeiculo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        int ano = Integer.parseInt(request.getParameter("ano"));
        String cor = request.getParameter("cor");
        String placa = request.getParameter("placa");
        
        Veiculo veiculo = new Veiculo(marca, modelo, ano, cor, placa);
        VeiculoRepository.adicionarVeiculo(veiculo);

        response.sendRedirect(request.getContextPath() + "/verVeiculos");
    }
}

