package main.java.com.locadora.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import main.java.com.locadora.models.Veiculo;
import main.java.com.locadora.repository.VeiculoRepository;

@WebServlet("/listarVeiculos")
public class VeiculoListarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obter a lista de veículos disponíveis
        List<Veiculo> veiculosDisponiveis = VeiculoRepository.listarDisponiveis();
        
        // Adicionar a lista de veículos como atributo da requisição
        request.setAttribute("veiculosDisponiveis", veiculosDisponiveis);

        // Encaminhar a requisição para o JSP que lista os veículos
        request.getRequestDispatcher("/WEB-INF/pages/listarVeiculos.jsp").forward(request, response);
    }
}
