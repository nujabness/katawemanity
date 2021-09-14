package com.nujabness.katawemanity.services.authentification;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.nujabness.katawemanity.beans.commons.UserBean;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@Setter
public class CustomUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {

	@JsonProperty(value = "nom")
	private String nom;

	@JsonProperty(value = "prenom")
	private String prenom;

	@JsonProperty(value = "email")
	private String email;

	@JsonProperty(value = "token")
	private String token;

	public CustomUsernamePasswordAuthenticationToken(UserBean userInfo, String token) {
		super(null, null);
		setNom(userInfo.getNom());
		setPrenom(userInfo.getPrenom());
		setEmail(userInfo.getEmail());
		setToken(token);
	}
}
