<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.locadora.models.Veiculo" %>
    <%@ page import="java.util.List" %>
     <%@ page import="com.locadora.models.Alugar" %>
    
<%@ page import="com.locadora.models.Alugar" %>
<!DOCTYPE html>
<html lang= "pt-br">
<head>
<meta charset="UTF-8">

<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
 
  <title>Aluguel de veiculos</title>
 
 <body>
 <header>
 
 <% out.printl("Faça a escolha dos seu veiculo aqui!"); %>
 
 
 <section class="container">
		<div class="container-table">
		
		    <h1>Lista de Veículos disponiveis</h1>
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
 
 
 
 </header>
 



  </table>
		</div>
	    <a href="${pageContext.request.contextPath}/index.jsp">Voltar</a>
    </section>
</body>
</html>