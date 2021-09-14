package com.nujabness.katawemanity.beans.commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName(value="achat")
public class AchatBean {

  @JsonProperty("id_cli")
  private Integer id_cli;

  @JsonProperty("id_prod")
  private Integer id_prod;

  @JsonProperty("libelle")
  private String libelleProduit;

  @JsonProperty("nom")
  private String nomClient;

  @JsonProperty("quantite")
  private Integer quantite;
}
