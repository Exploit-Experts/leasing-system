package main.java.com.locadora.repository;

import main.java.com.locadora.models.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VeiculoRepository{

    private static List<Veiculo> veiculos = new ArrayList<>();

    // Adicionar um veículo
    public static void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    // Listar todos os veículos
    public static List<Veiculo> listarTodos() {
        return veiculos;
    }

    // Listar veículos disponíveis
    public static List<Veiculo> listarDisponiveis() {
        return veiculos.stream()
                       .filter(Veiculo::getDisponivel)
                       .collect(Collectors.toList());
    }

    // Atualizar a disponibilidade de um veículo
    public static void atualizarDisponibilidade(String placa, boolean disponivel) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                veiculo.setDisponivel(disponivel);
                break;
            }
        }
    }

	public static Veiculo buscarPorPlaca(String placaVeiculo) {
		for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placaVeiculo)) {
                veiculo.setDisponivel(false);
                return veiculo;
            }
        }
		return null;
	}

}
