<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="main.java.com.locadora.models.Reserva" %>
<%@ page import="main.java.com.locadora.models.Cliente" %>
<%@ page import="main.java.com.locadora.models.Veiculo" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Reservas</title>
</head>
<body>
    <h1>Lista de Reservas</h1>
    
    <table border="1">
        <tr>
            <th>Nome do Cliente</th>
            <th>Endereço</th>
            <th>Email</th>
            <th>Telefone</th>
            <th>Marca do Veículo</th>
            <th>Modelo do Veículo</th>
            <th>Ano do Veículo</th>
            <th>Cor do Veículo</th>
            <th>Placa do Veículo</th>
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
    
    <br>
    <a href="${pageContext.request.contextPath}/index.jsp">Voltar para a Página Inicial</a>
</body>
</html>
