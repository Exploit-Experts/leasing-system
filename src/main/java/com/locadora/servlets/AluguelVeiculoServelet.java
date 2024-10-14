package com.locadora.servlets;

public class AluguelVeiculoServelet {
	
	
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import com.locadora.models.Veiculo;
	import com.locadora.repository.VeiculoRepository;
	import java.io.IOException;
	import java.util.List;

	@WebServlet("/AlugarVeiculo")
	public class AluguelVeiculosServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        List<Veiculo> veiculos = VeiculoRepository.listarTodos();

	        request.setAttribute("veiculos", veiculos);

	        request.getRequestDispatcher("/WEB-INF/pages/verVeiculos.jsp").forward(request, response);
	    }
	}



}
