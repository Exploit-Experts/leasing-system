package com.locadora.servlets;

import com.locadora.models.Cliente;
import com.locadora.models.Veiculo;

import com.locadora.models.Veiculo;
import com.locadora.repository.ClienteRepository;
import com.locadora.repository.VeiculoRepository;

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
    //criando para listar os dados do cliente 
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
            
           

            
            response.sendRedirect(request.getContextPath() + "/alugarVeiculo.jsp");
        }
        
        
        
       
        protected void doPost2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            String veiculoId = request.getParameter("veiculoId");
            String nomeCliente = request.getParameter("nomeCliente"); 
            Cliente cliente = new Cliente(nomeCliente); 
            
         
            Veiculo veiculo = VeiculoRepository.buscarPorPlaca(veiculoId);

            if (veiculo != null && veiculo.getDisponivel()) {
                
                VeiculoRepository.atualizarDisponibilidade(veiculoId, false);
                
              
                veiculo.setClienteAtual(cliente);

               
                response.sendRedirect("alugarVeiculo");
            } else {
               
                response.getWriter().write("Veículo não encontrado ou indisponível.");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST); 
            }
        }
     
    
      //mostrar nome placa e da de devolucao para o cliente
    
         public void doGet1(HttpServletRequest request, HttpServletResponse response) {
        	  String nome = request.getParameter("nome");
        	  String placa = request.getParameter("placa");
        	  String data = request.getParameter("DataDevolucao" + "sua data de devolução é" + nome);
        	  
        	  System.out.print("Seu nome é " + nome +  "e o seu carro é ");
        	 
        	   request.getRequestDispatcher("/WEB-INF/pages/alugarVeiculo.jsp").forward(request, response)
        		
	}
         
         //pega os veiculos disponiveis e lista 
         public void doGet2 (HttpServletRequest request, HttpServletResponse response) {
         
         List<Veiculo> veiculos = VeiculoRepository.listarDisponiveis();

         request.setAttribute("veiculos", veiculos);
         
         request.getRequestDispatcher("/WEB-INF/pages/alugarVeiculo.jsp").forward(request, response)

         }
         
         
         
         
         
// metodos de pagamento

         public void doPost4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	  
        	    String metodoPagamento1 = request.getParameter("Cartao") + " Cebito" + "Credito";
        	    String metodoPagamento2 = request.getParameter("Pix");
        	    String metodoPagamento3 = request.getParameter("Debito");
        	    String metodoPagamento4 = request.getParameter("Dinheiro");
        	    
        	    
        	    
 

        	   
        	    request.getRequestDispatcher("/WEB-INF/pages/alugarVeiculo.jsp").forward(request, response);
        	}




}

