<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.locadora.models.Veiculo" %>
<%@ page import="com.locadora.models.Cliente" %>

<!DOCTYPE html>
<html>
<head>
    <title>Cadastro</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
	    <h1>Bem-vindo à Locadora Lieasing System</h1>
		<nav>
			<a href="./cadastrarVeiculo">
		    	<input type="button" value="Adicionar Veículo">
		   	</a>
		   	
		  	<a href="./verVeiculos">
		    	<input type="button" value="Ver Todos os Veículos">
		   	</a>
		   	
		   	<a href="./cadastrarCliente">
		    	<input type="button" value="cadastro">
		   	</a>
		   		   	
		   	
		   	<a href="./verReservas">
		    	<input type="button" value="Ver Reservas">
		     </a>	
		    	 
			   
			 
			   
			
		    	 <a href="/">
		    	 <input type="button" value="contato">
			   </a>
			   
			    <a href="./sobreNos.html">
		    	 <input type="button" value="Quem somos">
			   </a>
			   
			   <a href="./telaInicial.html">
		    	 <input type="button" value="Tela Inicial">
			   </a>
			   
			   </form>
		   
		</nav>
	</header>
	
	
 
	
		<section class="container">
			<div class="container-form">		    
			    <form action="${pageContext.request.contextPath}/cadastrarCliente" method="post" class="form-styles">
				    <h1>Cadastrar Cliente e Reservar Veículo</h1>
			    	<div class="input-group">
				        <label for="nome">Nome:</label>
				        <input type="text" id="nome" name="nome" required>
			    	</div>
			    	
			        <div class="input-group">
				        <label for="endereco">Endereço:</label>
				        <input type="text" id="endereco" name="endereco" required>
				    </div>
			        
			        <div class="input-group">
				        <label for="email">Email:</label>
				        <input type="email" id="email" name="email" required>
			        </div>
			        
			        <div class="input-group">
				        <label for="telefone">Telefone:</label>
				        <input type="text" id="telefone" name="telefone" required>
			        </div>
			        
			        <div class="input-group">
				        <label for="placa">Placa do Veículo:</label>
				        <input type="text" id="placa" name="placa" required>
			        </div>
			        
			        <div class="input-group">
				        <label for="dataDevolucao">Data de Devolução:</label>
						<input type="date" id="dataDevolucao" name="dataDevolucao" required min="<%= LocalDate.now() %>">
			        </div>
			        
			   
			</div>
			    
		    <div class="container-table" style="margin-top: 2em;">		    
			    <h2>Veículos Disponíveis</h2>
			    <table class="table">	
			        <tr>
			            <th>Marca</th>
			            <th>Modelo</th>
			            <th>Ano</th>
			            <th>Cor</th>
			            <th>Placa</th>
			        </tr>
			        <% 
			            List<Veiculo> veiculos = (List<Veiculo>) request.getAttribute("veiculos");
			            
			            if (veiculos == null || veiculos.isEmpty()) {
			        %>
			        <tr>
			            <td colspan="5">Nenhum veículo disponível.</td>
			        </tr>
			        <% 
			            } else {
			                for (Veiculo veiculo : veiculos) {
			        %>
			        <tr>
			            <td><%= veiculo.getMarca() %></td>
			            <td><%= veiculo.getModelo() %></td>
			            <td><%= veiculo.getAno() %></td>
			            <td><%= veiculo.getCor() %></td>
			            <td><%= veiculo.getPlaca() %></td>
			        </tr>
			        <% 
			                }
			            }
			        %>
		    </table>
	    </div>
	</section>
	
	
	
<footer>
    <p>&copy; 2024 Leasing System. Todos os direitos reservados.</p>
</footer>
	
</body>
</html>
