<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.locadora.models.Reserva" %>
<%@ page import="com.locadora.models.Cliente" %>
<%@ page import="com.locadora.models.Veiculo" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Reservas</title>
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
		<div class="container-table" style="margin-top: 2em;">
		    <h1>Lista de Reservas</h1>
		    
		    <table class="table" style="width: 85%">
		        <tr>
		            <th>Cliente</th>
		            <th>Endereço</th>
		            <th>Email</th>
		            <th>Telefone</th>
		            <th>Marca</th>
		            <th>Modelo</th>
		            <th>Ano do Veículo</th>
		            <th>Cor</th>
		            <th>Placa</th>
		            <th>Data de Início</th>
		            <th>Data de Devolução</th>
		        </tr>
		        <% 
		            List<Reserva> reservas = (List<Reserva>) request.getAttribute("reservas");
		            
		            if (reservas == null || reservas.isEmpty()) {
		        %>
		        <tr>
		            <td colspan="11">Nenhuma reserva encontrada.</td>
		        </tr>
		        <% 
		            } else {
		                for (Reserva reserva : reservas) {
		                    Cliente cliente = reserva.getCliente();
		                    Veiculo veiculo = reserva.getVeiculo();
		        %>
		        <tr>
		            <td><%= cliente.getNome() %></td>
		            <td><%= cliente.getEndereco() %></td>
		            <td><%= cliente.getEmail() %></td>
		            <td><%= cliente.getTelefone() %></td>
		            <td><%= veiculo.getMarca() %></td>
		            <td><%= veiculo.getModelo() %></td>
		            <td><%= veiculo.getAno() %></td>
		            <td><%= veiculo.getCor() %></td>
		            <td><%= veiculo.getPlaca() %></td>
		            <td><%= reserva.getDataInicio() %></td>
		            <td><%= reserva.getDataFim() %></td>
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
