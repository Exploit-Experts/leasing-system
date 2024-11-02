<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.locadora.models.Cliente" %>
<%@ page import="com.locadora.models.Veiculo"%>
<%@ page import= "com.locadora.repository.VeiculoRepository" %>
 
<!DOCTYPE html>
<html>
<head>

 	
		    	

<meta charset="UTF-8">
<title>Alugar Veículos</title>
 <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<header>
	    <h1>Bem-vindo</h1>
		<nav>
			<a href="./CadastrarCliente">
		    	<input type="button" value="cadastro">
		   	</a>
		   	
		  	<a href="./verVeiculos">
		    	<input type="button" value="Veiculos">
		   	</a>
		   	
		   	<a href=".">
		    	<input type="button" value="tipo">
		   	</a>
		   	
		   	<a href="./verReservas">
		    	<input type="button" value="Ver Reservas">
		   	</a>
		   	
		   	  <a href="./telaInicial.html">
		    	 <input type="button" value="Tela Inicial">
			   </a>
		</nav>
	</header>


<%  out.println("Seja bem vindo!");   %>  




<P> Escolha seu veiculo agora mesmo agradecemos a preferencia <P/>  


    <h1>Seus dados cadastrados são:</h1>
    <p>Nome do Cliente: <%= request.getParameter("nome") %></p>
    <p>Email: <%= request.getParameter("email") %></p>
    <p>Telefone: <%= request.getParameter("telefone") %></p>
    <p>Placa do Veículo: <%= request.getParameter("placa") %></p>
    <p>Data de Devolução: <%= request.getParameter("DataDevolucao")%><P/> 
    
   
   
    
       
 
              
  
   
   <%   //aluguel veiculo     %> 
 
 
   <head>
    <title>Alugar Veículo</title>
</head>
<body>
   <h2>Veículos Disponíveis para Aluguel</h2>

<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Modelo</th>
            <th>Marca</th>
            <th>Ano</th>
            <th>Preço Diário</th>
            <th>Reserve seu veiculo</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="veiculo" items="${veiculos}">
            <c:if test="${veiculo.disponivel}">
                <tr>
                    <td>${veiculo.id}</td>
                    <td>${veiculo.modelo}</td>
                    <td>${veiculo.marca}</td>
                    <td>${veiculo.ano}</td>
                    <td>${veiculo.precoDiario}</td>
                    <td>
                        <form action="reservarVeiculo" method="post">
                            <input type="hidden" name="idVeiculo" value="${veiculo.id}" />
                           
                            <input type="text" name="nomeCliente" placeholder="Nome do Cliente" required />
                            <button type="submit">Reservar</button>
                        </form>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </tbody>
</table>
   
  

<form action="<%= request.getContextPath() %>/doPost4" method="post">
    <h3>Escolha o método de pagamento:</h3>
    
  
    <label for="cartao">Cartão (Débito):</label>
    <input type="text" name="Cartao" id="cartao" placeholder="Digite o número do cartão"><br>

    <label for="pix">Pix:</label>
    <input type="text" name="Pix" id="pix" placeholder="Digite a chave Pix"><br>

    
    <label for="debito">Débito:</label>
    <input type="text" name="Debito" id="debito" placeholder="Digite o número do cartão de débito"><br>

   
    <label for="dinheiro">Dinheiro:</label>
    <input type="text" name="Dinheiro" id="dinheiro" placeholder="Digite o valor em dinheiro"><br>
    
    
    <button type="submit">Confirmar Pagamento</button>
</form>





<a href="./index.jsp">
<input type="button" value="Voltar para o tela inicial">
</a>


</body>
</html>