package com.locadora.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.locadora.models.Reserva;
import com.locadora.repository.ReservaRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/verReservas")
public class ListarReservasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	List<Reserva> reservas = ReservaRepository.listarReservas();
        
        request.setAttribute("reservas", reservas);
        
        System.out.println("Reservas passadas para a página: " + reservas);
        
        request.getRequestDispatcher("/WEB-INF/pages/verReservas.jsp").forward(request, response);
    }
}
