package main.java.com.locadora.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.com.locadora.models.Veiculo;
import main.java.com.locadora.repository.VeiculoRepository;
import java.io.IOException;

@WebServlet("/cadastrarVeiculo")
public class VeiculoCadastrarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Exibir o formulário para cadastrar um novo veículo
        request.getRequestDispatcher("/WEB-INF/pages/cadastrarVeiculo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Receber os dados do veículo do formulário
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        int ano = Integer.parseInt(request.getParameter("ano"));
        String cor = request.getParameter("cor");
        String placa = request.getParameter("placa");

        // Criar um novo veículo e adicionar ao repositório
        Veiculo veiculo = new Veiculo(marca, modelo, ano, cor, placa);
        VeiculoRepository.adicionarVeiculo(veiculo);

        // Redirecionar para a página inicial (index.jsp)
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}

