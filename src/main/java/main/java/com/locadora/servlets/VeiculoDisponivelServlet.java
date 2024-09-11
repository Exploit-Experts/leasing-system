package main.java.com.locadora.servlets;

import main.java.com.locadora.models.Cliente;
import main.java.com.locadora.models.Veiculo;
import main.java.com.locadora.repository.ClienteRepository;
import main.java.com.locadora.repository.VeiculoRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/veiculoDisponivel")
public class VeiculoDisponivelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Receber os dados do cliente do formulário
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");

        // Criar um novo cliente
        Cliente cliente = new Cliente(nome, endereco, email, telefone);
        
        // Salvar o cliente na sessão
        request.getSession().setAttribute("cliente", cliente);

        // Obter a lista de veículos disponíveis
        List<Veiculo> veiculos = VeiculoRepository.listarDisponiveis();

        // Adicionar a lista de veículos como atributo da requisição
        request.setAttribute("veiculos", veiculos);

        // Exibir o formulário para selecionar a data de devolução e listar os veículos disponíveis
        request.getRequestDispatcher("/WEB-INF/pages/veiculosDisponiveis.jsp").forward(request, response);
    }
}

