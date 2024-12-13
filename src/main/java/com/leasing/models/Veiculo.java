package com.leasing.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class Veiculo {
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false,unique = true)
  private String placa;
  @Column(nullable = false)
  private String marca;
  @Column(nullable = false)
  private String modelo;
  @Column(nullable = false)
  private int ano;
  @Column(nullable = false)
  private String cor;
  @Column(nullable = false)  
  private Boolean disponivel;
}
