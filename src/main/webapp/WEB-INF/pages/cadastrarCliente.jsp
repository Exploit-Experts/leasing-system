<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.locadora.models.Veiculo" %>
<%@ page import="java.time.LocalDate" %>


<!DOCTYPE html>
<html>
<head>
    <title>Cadastrar Cliente e Reservar Veículo</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
	    <h1>Bem-vindo à Locadora</h1>
		<nav>
			<a href="./cadastrarVeiculo">
		    	<input type="button" value="Adicionar Veículo">
		   	</a>
		   	
		  	<a href="./verVeiculos">
		    	<input type="button" value="Ver Todos os Veículos">
		   	</a>
		   	
		   	<a href="./cadastrarCliente">
		    	<input type="button" value="Alugar Veículo">
		   	</a>
		   	
		   	<a href="./verReservas">
		    	<input type="button" value="Ver Reservas">
		   	</a>
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
		        
		        <input type="submit" value="Reservar Veículo">
		    </form>
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
		   
		    <a href="${pageContext.request.contextPath}/index.jsp">Voltar para a Página Inicial</a>
	</section>
</body>
</html>

