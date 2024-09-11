<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="main.java.com.locadora.models.Veiculo" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Veículos</title>
</head>
<body>
    <h1>Lista de Veículos Cadastrados</h1>
    <table border="1">
        <tr>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Ano</th>
            <th>Cor</th>
            <th>Placa</th>
            <th>Disponível</th>
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
    <br>
    <a href="${pageContext.request.contextPath}/cadastrarVeiculo">Cadastrar Novo Veículo</a>
    <a href="${pageContext.request.contextPath}/index.jsp">Voltar</a>
</body>
</html>


