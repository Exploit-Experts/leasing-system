package main.java.com.locadora.servlets;

import main.java.com.locadora.models.Cliente;
import main.java.com.locadora.models.Reserva;
import main.java.com.locadora.models.Veiculo;
import main.java.com.locadora.repository.ClienteRepository;
import main.java.com.locadora.repository.ReservaRepository;
import main.java.com.locadora.repository.VeiculoRepository;

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obter a lista de veículos disponíveis
        List<Veiculo> veiculos = VeiculoRepository.listarDisponiveis();

        // Adicionar a lista de veículos como atributo da requisição
        request.setAttribute("veiculos", veiculos);

        // Exibir o formulário de aluguel de veículo
        request.getRequestDispatcher("/WEB-INF/pages/alugarVeiculo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Receber os dados do cliente e do veículo do formulário
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String placa = request.getParameter("placa");
        String dataDevolucaoStr = request.getParameter("dataDevolucao");

        // Criar um novo cliente e adicionar ao repositório
        Cliente cliente = new Cliente(nome, endereco, email, telefone);
        ClienteRepository.adicionarCliente(cliente);

        // Obter o veículo selecionado
        Veiculo veiculo = VeiculoRepository.buscarPorPlaca(placa);

        // Atualizar a disponibilidade do veículo
        if (veiculo != null) {
            
	        // Converter a data de devolução
	        LocalDate dataDevolucao = LocalDate.parse(dataDevolucaoStr);
	
	        // Aqui você pode salvar o aluguel no repositório de aluguéis ou onde for necessário
	
	        // Exibir uma página de sucesso ou confirmação
	        response.sendRedirect(request.getContextPath() + "/confirmacaoAluguel");
        }
    }
}

