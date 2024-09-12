package main.java.com.locadora.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.com.locadora.models.Cliente;
import main.java.com.locadora.models.Reserva;
import main.java.com.locadora.models.Veiculo;
import main.java.com.locadora.repository.ClienteRepository;
import main.java.com.locadora.repository.ReservaRepository;
import main.java.com.locadora.repository.VeiculoRepository;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/cadastrarCliente")
public class ClienteCadastroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obter a lista de veículos disponíveis
        List<Veiculo> veiculosDisponiveis = VeiculoRepository.listarDisponiveis();
        
        // Adicionar a lista de veículos disponíveis como atributo da requisição
        request.setAttribute("veiculos", veiculosDisponiveis);
        
        // Exibir o formulário de cadastro de cliente e reserva
        request.getRequestDispatcher("/WEB-INF/pages/cadastrarCliente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Receber os dados do cliente e reserva do formulário
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String placa = request.getParameter("placa");
        LocalDate dataDevolucao = LocalDate.parse(request.getParameter("dataDevolucao"));

        // Criar um novo cliente
        Cliente cliente = new Cliente(nome, endereco, email, telefone);
        ClienteRepository.adicionarCliente(cliente);

        // Encontrar o veículo com a placa fornecida
        Veiculo veiculo = VeiculoRepository.buscarPorPlaca(placa);

        if (veiculo != null && veiculo.getDisponivel()) {
            // Criar uma nova reserva
            Reserva reserva = new Reserva(cliente, veiculo, LocalDate.now(), dataDevolucao);
            ReservaRepository.adicionar(reserva);

            // Atualizar a disponibilidade do veículo
            veiculo.setDisponivel(false);
            VeiculoRepository.atualizarDisponibilidade(placa, false);
        }

        // Redirecionar para a página inicial (index.jsp)
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
