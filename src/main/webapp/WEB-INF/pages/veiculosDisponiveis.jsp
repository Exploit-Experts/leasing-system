<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="main.java.com.locadora.models.Veiculo" %>
<%@ page import="main.java.com.locadora.models.Cliente" %>

<!DOCTYPE html>
<html>
<head>
    <title>Veículos Disponíveis</title>
</head>
<body>
    <h1>Escolha um Veículo para Alugar</h1>
    <form action="alugarVeiculo" method="post">
        Data de Devolução: <input type="date" name="dataDevolucao" required><br>
        <table border="1">
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
    <a href="index.jsp">Voltar</a>
</body>
</html>
