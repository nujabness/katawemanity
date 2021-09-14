package com.nujabness.katawemanity.data.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Produit")
public class Produit {

  @Id
  @Column(name = "id_prod")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id_prod;

  @Column(name = "libelle")
  private String libelle;

  @Column(name = "prix")
  private Integer prix;

  @Column(name = "quantite")
  private Integer quantite;
}
