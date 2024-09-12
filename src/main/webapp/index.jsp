<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Página Inicial</title>
</head>
<body>
    <h1>Bem-vindo à Locadora</h1>
    
    <form action="${pageContext.request.contextPath}/cadastrarVeiculo" method="get">
        <input type="submit" value="Adicionar Veículo">
    </form>
    
    <form action="${pageContext.request.contextPath}/verVeiculos" method="get">
        <input type="submit" value="Ver Todos os Veículos">
    </form>
    
    <form action="${pageContext.request.contextPath}/cadastrarCliente" method="get">
        <input type="submit" value="Alugar Veículo">
    </form>
    
    <form action="${pageContext.request.contextPath}/verReservas" method="get">
        <input type="submit" value="Ver Reservas">
    </form>
</body>
</html>
