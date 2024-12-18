package com.leasing.models;

import lombok.Data;
import java.time.LocalDate;
import jakarta.persistence.*;

@Data
@Entity
public class Reserva {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "veiculo_id", nullable = false)
  private Veiculo veiculo;
  @ManyToOne
  @JoinColumn(name = "cliente_id", nullable = false)
  private Cliente cliente;
  @Column(nullable = false)
  private LocalDate dataInicio;
  @Column(nullable = false)
  private LocalDate dataFim;
}
