package com.nujabness.katawemanity.data.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Client")
public class Client {

  @Id
  @Column(name = "id_cli")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id_cli;

  @Column(name = "nom")
  private String nom;

  @Column(name = "prenom")
  private String prenom;

  @Column(name = "adresse")
  private String adresse;
}
