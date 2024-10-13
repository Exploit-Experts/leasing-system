package com.locadora.models;

import com.locadora.models.Veiculo;
import com.locadora.models.Cliente;


public class Alugar {
    private Cliente cliente;
	private Veiculo veiculo;
	
	


	public Alugar(Cliente cliente, Veiculo veiculo) {
        this.veiculo = veiculo;
        this.cliente = cliente;
    }
	
	
	public void mostrarDadosCliente() {
		 System.out.println("Seja bem vindo!: " + cliente.getNome());
			
		
	}
	
	
	public void mostrarDadosVeiculo(){
		System.out.println(" Obrigado pela a sua ecolha, os Veicolos disponiveis no momento São:");
		
		System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Modelo: " + veiculo.getMarca());
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Ano: " + veiculo.getAno());
        System.out.println("Cor: " + veiculo.getCor());
        System.out.println("Diponivel: " + veiculo.getDisponivel());
   
	}
	
	public static void Aluguel(Boolean Queroalugar) {
		System.out.println("Quer fazer o aluguel do veiculo");
		
		if (Queroalugar) {
			System.out.println("certo fique no aguardo");
			
			
		}  else {
			
			System.out.println("Que pena! estamos aqui se precisar");
		
		}
		
		
		
		
	}
	


}
