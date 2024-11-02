<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.locadora.models.Veiculo" %>
<%@ page import="com.locadora.models.Cliente" %>

<!DOCTYPE html>
<html>
<head>
    <title>Veículos Disponíveis</title>
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
		   	
		   	  <a href="./telaInicial.html">
		    	 <input type="button" value="Tela Inicial">
			   </a>
		</nav>
	</header>
	<section class="container">
		<div class="container-table" style="margin-top: 2em;">
		    <form action="alugarVeiculo" method="post">
		    <h1>Escolha um Veículo para Alugar</h1>
		        <label> Data de Devolução: </label> 
		        <input type="date" name="dataDevolucao" required>
		        <table class="table">
		            <tr>
		                <th>Marca</th>
		                <th>Modelo</th>
		                <th>Ano</th>
		                <th>Cor</th>
		                <th>Placa</th>
		                <th>Disponível</th>
		                <th>Ação</th>
		            </tr>
		            <% 
		                List<Veiculo> veiculos = (List<Veiculo>) request.getAttribute("veiculos");
		                for (Veiculo veiculo : veiculos) {
		            %>
		            <tr>
		                <td><%= veiculo.getMarca() %></td>
		                <td><%= veiculo.getModelo() %></td>
		                <td><%= veiculo.getAno() %></td>
		                <td><%= veiculo.getCor() %></td>
		                <td><%= veiculo.getPlaca() %></td>
		                <td><%= veiculo.getDisponivel() ? "Sim" : "Não" %></td>
		                <td>
		                    <button type="submit" name="placaVeiculo" value="<%= veiculo.getPlaca() %>">Alugar</button>
		                </td>
		            </tr>
		            <% 
		                }
		            %>
		        </table>
		    </form>
   		</div>
	   		
	    <a href="index.jsp">Voltar</a>
	  </section>
</body>
</html>
