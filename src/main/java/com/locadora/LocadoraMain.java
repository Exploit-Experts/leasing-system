package com.locadora;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LocadoraMain extends HttpServlet{

	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html"); 
        PrintWriter out = resp.getWriter();

                out.println("<html>");
        out.println("<head>");
        out.println("<title>Minha Página HTML</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Bem-vindo ao Meu Servlet!</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}