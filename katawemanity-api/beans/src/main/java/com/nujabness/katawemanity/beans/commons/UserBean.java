package com.nujabness.katawemanity.beans.commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName(value="user")
public class UserBean {

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("nom")
  private String nom;

  @JsonProperty("prenom")
  private String prenom;

  @JsonProperty("email")
  private String email;

  @JsonProperty("password")
  private String password;

}
