<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastrar Veículo</title>
</head>
<body>
    <h1>Cadastrar Novo Veículo</h1>
    <form action="${pageContext.request.contextPath}/cadastrarVeiculo" method="post">
        <label for="marca">Marca:</label>
        <input type="text" id="marca" name="marca" required><br><br>
        <label for="modelo">Modelo:</label>
        <input type="text" id="modelo" name="modelo" required><br><br>
        <label for="ano">Ano:</label>
        <input type="number" id="ano" name="ano" required><br><br>
        <label for="cor">Cor:</label>
        <input type="text" id="cor" name="cor" required><br><br>
        <label for="placa">Placa:</label>
        <input type="text" id="placa" name="placa" required><br><br>
        <input type="submit" value="Cadastrar Veículo">
    </form>
    <br>
    <a href="${pageContext.request.contextPath}/index.jsp">Voltar para a Página Inicial</a>
</body>
</html>
