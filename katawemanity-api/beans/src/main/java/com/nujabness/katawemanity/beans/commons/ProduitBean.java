package com.nujabness.katawemanity.beans.commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName(value="client")
public class ProduitBean {

  @JsonProperty("id_prod")
  private Integer id;

  @JsonProperty("libelle")
  private String libelle;

  @JsonProperty("prix")
  private Integer prix;

  @JsonProperty("quantite")
  private Integer quantite;
}
