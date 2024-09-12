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

@WebServlet("/alugarVeiculo")
public class VeiculoAlugarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        List<Veiculo> veiculos = VeiculoRepository.listarDisponiveis();

        request.setAttribute("veiculos", veiculos);

        request.getRequestDispatcher("/WEB-INF/pages/alugarVeiculo.jsp").forward(request, response);
    }

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
	
	
	        response.sendRedirect(request.getContextPath() + "/confirmacaoAluguel");
        }
    }
}

