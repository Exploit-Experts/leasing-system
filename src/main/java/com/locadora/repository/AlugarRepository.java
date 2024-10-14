package com.locadora.repository;

import java.util.ArrayList;
import java.util.List;

import com.locadora.models.Alugar;

public class AlugarRepository {
	
	
	 private static List<Alugar> aluguel = new ArrayList<>();

	    public static void adicionarAlugar(Alugar alugar) {
	        alugar.add(alugar);
	    }

	    public static List<Alugar> listaraluguel() {
	        return new ArrayList<>(aluguel);
	    }

}
