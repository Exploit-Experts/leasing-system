package main.java.com.locadora.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.com.locadora.models.Veiculo;
import main.java.com.locadora.repository.VeiculoRepository;
import java.io.IOException;
import java.util.List;

@WebServlet("/verVeiculos")
public class VerVeiculosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Veiculo> veiculos = VeiculoRepository.listarTodos();

        request.setAttribute("veiculos", veiculos);

        request.getRequestDispatcher("/WEB-INF/pages/verVeiculos.jsp").forward(request, response);
    }
}
