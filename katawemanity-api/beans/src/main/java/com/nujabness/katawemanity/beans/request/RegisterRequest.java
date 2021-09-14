package com.nujabness.katawemanity.beans.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterRequest {

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("prenom")
    private String prenom;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

}
