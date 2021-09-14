package com.nujabness.katawemanity.beans.commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName(value="client")
public class ClientBean {

  @JsonProperty("id_cli")
  private Integer id;

  @JsonProperty("nom")
  private String nom;

  @JsonProperty("prenom")
  private String prenom;

  @JsonProperty("adresse")
  private String adresse;
}
