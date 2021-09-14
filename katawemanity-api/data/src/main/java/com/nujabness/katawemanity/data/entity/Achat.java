package com.nujabness.katawemanity.data.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Achat")
public class Achat {

  @EmbeddedId
  private AchatKey id;

  @ManyToOne
  @MapsId("id_cli")
  @JoinColumn(name = "id_cli")
  private Client id_cli;

  @ManyToOne
  @MapsId("id_prod")
  @JoinColumn(name = "id_prod")
  private Produit id_prod;

  @Column(name = "quantite")
  private Integer quantite;
}
