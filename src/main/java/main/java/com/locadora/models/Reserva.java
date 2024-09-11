package main.java.com.locadora.models;
import java.time.LocalDate;

public class Reserva {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Reserva( Cliente cliente, Veiculo veiculo, LocalDate dataInicio, LocalDate dataFim) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo(){
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public boolean estaDentroDoPeriodo(LocalDate data) {
        return !data.isBefore(dataInicio) && !data.isAfter(dataFim);
    }

}





