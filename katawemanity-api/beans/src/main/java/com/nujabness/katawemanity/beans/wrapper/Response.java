package com.nujabness.katawemanity.beans.wrapper;

import lombok.Data;

@Data
public class Response<T> {

	// Flag indiquant si la requête http a été bien déroulé
	private boolean success;

	// Message à retourner en cas d’erreur
	private String message;

	// Si le résultat de la requête est un objet
	private T result;
}
