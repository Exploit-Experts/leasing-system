<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Página Inicial</title>
</head>
<body>
    <h1>Bem-vindo à Locadora</h1>
    
    <!-- Botão para adicionar um novo veículo -->
    <form action="${pageContext.request.contextPath}/cadastrarVeiculo" method="get">
        <input type="submit" value="Adicionar Veículo">
    </form>
    
    <!-- Botão para ver todos os veículos -->
    <form action="${pageContext.request.contextPath}/verVeiculos" method="get">
        <input type="submit" value="Ver Todos os Veículos">
    </form>
    
    <!-- Botão para cadastrar cliente e reservar veículo -->
    <form action="${pageContext.request.contextPath}/cadastrarCliente" method="get">
        <input type="submit" value="Alugar Veículo">
    </form>
    
</body>
</html>
