package com.locadora.servlets;

import com.locadora.models.Cliente;

import com.locadora.models.Veiculo;

import com.locadora.models.Veiculo;
import com.locadora.repository.ClienteRepository;
import com.locadora.repository.VeiculoRepository;
import com.locadora.servlets.ClienteCadastroServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/alugarVeiculo")
public class VeiculoAlugarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Exibe a página com a lista de veículos disponíveis
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Veiculo> veiculos = VeiculoRepository.listarTodos();
        request.setAttribute("veiculos", veiculos);
        request.getRequestDispatcher("/WEB-INF/pages/alugarVeiculo.jsp").forward(request, response);
    }

    // Processa o aluguel de veículo e exibe os dados do cliente e do veículo selecionado
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String placa = request.getParameter("placa");
        String dataDevolucaoStr = request.getParameter("dataDevolucao");

        Cliente cliente = new Cliente(nome, endereco, email, telefone);
        ClienteRepository.adicionarCliente(cliente);

        Veiculo veiculo = VeiculoRepository.buscarPorPlaca(placa);
        if (veiculo != null) {
            LocalDate dataDevolucao = LocalDate.parse(dataDevolucaoStr);
            veiculo.setDisponivel(false);

            // Atribui os dados ao request para exibir na página JSP
            request.setAttribute("cliente", cliente);
            request.setAttribute("veiculo", veiculo);
            request.setAttribute("dataDevolucao", dataDevolucao);

            request.getRequestDispatcher("/WEB-INF/pages/alugarVeiculo.jsp").forward(request, response);
        } else {
            response.getWriter().write("Veículo não encontrado.");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
