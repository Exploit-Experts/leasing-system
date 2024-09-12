<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.locadora.models.Veiculo" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Veículos</title>
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
		<div class="container-table">
		
		    <h1>Lista de Veículos Cadastrados</h1>
		    <table class="table">
		        <tr>
		            <th scope="col">Marca</th>
		            <th scope="col">Modelo</th>
		            <th scope="col">Ano</th>
		            <th scope="col">Cor</th>
		            <th scope="col">Placa</th>
		            <th scope="col">Disponível</th>
		        </tr>
		        <% 
		            List<Veiculo> veiculos = (List<Veiculo>) request.getAttribute("veiculos");
		            
		            if (veiculos == null || veiculos.isEmpty()) {
		        %>
		        <tr>
		            <td colspan="6">Nenhum veículo encontrado.</td>
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
		            <td><%= veiculo.getDisponivel() ? "Sim" : "Não" %></td>
		        </tr>
		        <% 
		                }
		            }
		        %>
		    </table>
		</div>
	    <a href="${pageContext.request.contextPath}/cadastrarVeiculo">Cadastrar Novo Veículo</a>
	    <a href="${pageContext.request.contextPath}/index.jsp">Voltar</a>
    </section>
</body>
</html>


