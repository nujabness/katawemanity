package com.nujabness.katawemanity.beans.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClientRequest {

    @JsonProperty("id_cli")
    private Integer id ;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("prenom")
    private String prenom;

    @JsonProperty("adresse")
    private String adresse;
}
