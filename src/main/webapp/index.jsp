<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.locadora.models.Veiculo" %>
<%@ page import="com.locadora.models.Cliente" %>

<!DOCTYPE html>
<html>
<head>
    <title>Página Inicial</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
	    <h1>Bem-vindo à Locadora Lieasing System</h1>
		<nav>
			<a href="./cadastrarVeiculo">
		    	<input type="button" value="Adicionar Veículo">
		   	</a>
		   	
		  	<a href="./verVeiculos">
		    	<input type="button" value="Ver Todos os Veículos">
		   	</a>
		   	
		   	<a href="./cadastrarCliente">
		    	<input type="button" value="cadastro">
		   	</a>
		   		   	
		   	
		   	<a href="./verReservas">
		    	<input type="button" value="Ver Reservas">
		     </a>	
		    	  <a href="/inicial">
		    	 <input type="button" value="Tela inicial">
			   </a>
			   
			    </a>	
		    	  <a href="/">
		    	 <input type="button" value="carros">
			   </a>
			   
			    </a>	
		    	  <a href="/">
		    	 <input type="button" value="sobre">
		    	 
			   </a>
			   
			    	
		    	 <a href="/">
		    	 <input type="button" value="contato">
			   </a>
			   
			   </form>
		   
		</nav>
	</header>
	
	
	
	
<div class="container">
    <div class="hero">
        <h2>Escolha o melehor veiculo de acordo com sua nescessidade</h2>
    </div>
	
	
<p>   A Leasing Sistem é uma locadora de carros que se destaca no mercado por oferecer soluções completas e personalizadas para locação de veículos. Com uma frota diversificada e moderna, a empresa atende tanto clientes corporativos quanto individuais, proporcionando flexibilidade e conveniência na escolha de modelos, prazos e condições de contrato.

Um dos principais diferenciais da Leasing Sistem é seu compromisso com a qualidade do serviço. A empresa investe continuamente na manutenção e renovação de sua frota, garantindo que os veículos estejam sempre em excelentes condições, oferecendo segurança e conforto aos seus clientes. Além disso, oferece pacotes de locação que incluem benefícios como assistência 24 horas, seguro e revisões periódicas, proporcionando tranquilidade total durante o período de uso.

A Leasing Sistem também se destaca pela flexibilidade de seus contratos, que podem ser moldados de acordo com as necessidades específicas de cada cliente. Seja para aluguel diário, semanal, mensal ou contratos de longo prazo, a empresa garante opções que se adequam a cada tipo de demanda, com preços competitivos e condições transparentes.

Além de carros de passeio, a locadora disponibiliza veículos utilitários, SUVs e modelos premium, atendendo desde o cliente que busca praticidade no dia a dia até empresas que precisam de frotas para operações comerciais. Seu atendimento ao cliente é ágil e eficiente, com foco em solucionar as demandas de forma personalizada e rápida.

Com anos de experiência no setor, a Leasing Sistem se consolida como uma referência em locação de veículos, unindo inovação, qualidade e compromisso em cada serviço prestado.


</p>



	
	 
       
 <p>Explore nossa vasta coleção de carros. Alugue online com facilidade e conveniência.</p>
        
        
        
        
  <p>Veja nossos carros</p>
   

<style>
        
        .carrossel {
            width: 80%;
            max-width: 600px;
            position: relative;
        }
        .carrossel img {
            width: 100%;
            border-radius: 10px;
            display: none;
        }
        .carrossel img.active {
            display: block;
        }
        .setas {
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            width: 100%;
            display: flex;
            justify-content: space-between;
        }
        .seta {
            background-color: rgba(0, 0, 0, 0.5);
            color: white;
            border: none;
            padding: 10px;
            cursor: pointer;
        }
        .seta:focus {
            outline: none;
        }
    </style>
	<div class="carrossel">
      
        <img src="imagens/corsa.jpg" alt="Carro 1" class="active">
        <img src="imagens/Bugatti_Veyron.jpg" alt="Carro 2">
        <img src="imagens/Lamborguine.png" alt="Carro 3">
        <img src="imagens/Ferrari.png" alt="Carro 4"> 
        <img src="imagens/fiat Uno.jpg" alt="Carro 5">
        <img src="imagens/Fox.png" alt="Carro 6">
        <img src="imagens/crossfox.png" alt="Carro 7">
        <img src="imagens/S10.png" alt="Carro 8">
        <img src="imagens/Spin.jpg" alt="Carro 9">
        <img src="imagens/Corola.png" alt="Carro 10">
        <img src="imagens/Civic.jpg" alt="Carro 11">
      

        <div class="setas">
            <button class="seta" id="prev">← Anterior</button>
            <button class="seta" id="next">Próximo →</button>
        </div>
    </div>

    <script>
        const images = document.querySelectorAll('.carrossel img');
        let currentIndex = 0;

        document.getElementById('next').addEventListener('click', () => {
            images[currentIndex].classList.remove('active');
            currentIndex = (currentIndex + 1) % images.length;
            images[currentIndex].classList.add('active');
        });

        document.getElementById('prev').addEventListener('click', () => {
            images[currentIndex].classList.remove('active');
            currentIndex = (currentIndex - 1 + images.length) % images.length;
            images[currentIndex].classList.add('active');
        });
	
        </script>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	
		<section class="container">
			<div class="container-form">		    
			    <form action="${pageContext.request.contextPath}/cadastrarCliente" method="post" class="form-styles">
				    <h1>Cadastrar Cliente e Reservar Veículo</h1>
			    	<div class="input-group">
				        <label for="nome">Nome:</label>
				        <input type="text" id="nome" name="nome" required>
			    	</div>
			    	
			        <div class="input-group">
				        <label for="endereco">Endereço:</label>
				        <input type="text" id="endereco" name="endereco" required>
				    </div>
			        
			        <div class="input-group">
				        <label for="email">Email:</label>
				        <input type="email" id="email" name="email" required>
			        </div>
			        
			        <div class="input-group">
				        <label for="telefone">Telefone:</label>
				        <input type="text" id="telefone" name="telefone" required>
			        </div>
			        
			        <div class="input-group">
				        <label for="placa">Placa do Veículo:</label>
				        <input type="text" id="placa" name="placa" required>
			        </div>
			        
			        <div class="input-group">
				        <label for="dataDevolucao">Data de Devolução:</label>
						<input type="date" id="dataDevolucao" name="dataDevolucao" required min="<%= LocalDate.now() %>">
			        </div>
			        
			   
			</div>
			    
		    <div class="container-table" style="margin-top: 2em;">		    
			    <h2>Veículos Disponíveis</h2>
			    <table class="table">	
			        <tr>
			            <th>Marca</th>
			            <th>Modelo</th>
			            <th>Ano</th>
			            <th>Cor</th>
			            <th>Placa</th>
			        </tr>
			        <% 
			            List<Veiculo> veiculos = (List<Veiculo>) request.getAttribute("veiculos");
			            
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
	    </div>
	</section>
	
	
	
<footer>
    <p>&copy; 2024 Leasing System. Todos os direitos reservados.</p>
</footer>
	
</body>
</html>
