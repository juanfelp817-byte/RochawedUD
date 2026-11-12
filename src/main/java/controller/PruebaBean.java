/*
 * Autor: Juan Felipe Rocha 
 */
package controller;

import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("ojBean")
@ViewScoped
public class PruebaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public PruebaBean() {

	}

	public String getSaludo() {
		return "Hola Mundo Bean";
	}

}
