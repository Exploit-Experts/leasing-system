<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastrar Veículo</title>
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
		   		<a href="./AlugarVeiculo">
		    	<input type="button" value="Alugar">
		   	</a>
		</nav>
	</header>
	<section class="container">
		<div class="container-form">	
		    <form action="${pageContext.request.contextPath}/cadastrarVeiculo" method="post" class="form-styles">
		    	<h1>Cadastrar Novo Veículo</h1>
		    	<div class="input-group">
			        <label for="marca">Marca:</label>
			        <input type="text" id="marca" name="marca" required>
		       	</div>
		       	
		       	<div class="input-group">
			        <label for="modelo">Modelo:</label>
			        <input type="text" id="modelo" name="modelo" required>
        		</div>
        		
        		<div class="input-group">
			        <label for="ano">Ano:</label>
					<input type="text" id="ano" name="ano" required pattern="\d{4}" title="Digite um ano válido com 4 dígitos" maxlength="4">
				</div>
				
				<div class="input-group">
			        <label for="cor">Cor:</label>
			        <input type="text" id="cor" name="cor" required>
		       </div>
		       
		       <div class="input-group">
			        <label for="placa">Placa:</label>
			        <input type="text" id="placa" name="placa" required>
			   </div>  
			      
		        <input type="submit" value="Cadastrar Veículo">
		    </form>
	  	</div>		    
	  	
	    <a href="${pageContext.request.contextPath}/index.jsp">Voltar para a Página Inicial</a>
   </section>
</body>
</html>
