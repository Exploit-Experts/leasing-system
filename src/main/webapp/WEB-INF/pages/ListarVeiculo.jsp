<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="main.java.com.locadora.models.Veiculo" %>

<!DOCTYPE html>
<html>
<head>
    <title>Veículos Disponíveis</title>
</head>
<body>
    <h1>Lista de Veículos Disponíveis</h1>
    <table border="1">
        <tr>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Ano</th>
            <th>Cor</th>
            <th>Placa</th>
        </tr>
        <% 
            List<Veiculo> veiculos = (List<Veiculo>) request.getAttribute("veiculosDisponiveis");
            
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
    <br>
    <a href="index.jsp">Voltar</a>
</body>
</html>
