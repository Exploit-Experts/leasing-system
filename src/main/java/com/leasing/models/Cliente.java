package com.leasing.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false,unique = true)
  private String email;
  @Column(nullable = false)
  private String password;
  @Column(nullable = false)
  private String phone;

}
