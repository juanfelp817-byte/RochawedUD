/*
 * Autor: [Nombre completo del estudiante]
 */
package controller;

import java.io.Serializable;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import model.Aspirante;
import service.AspiranteService;

// esto es un bean

@Named("aspBean")
@ViewScoped
public class AspiranteController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AspiranteService aspiranteService;

	private Aspirante nuevoAspirante;
	private List<Aspirante> listaA;

	@PostConstruct
	public void init() {
		nuevoAspirante = new Aspirante();
		cargarAspirantes();
	}

	public AspiranteController() {

	}

	public Aspirante getNuevoAspirante() {
		return nuevoAspirante;
	}

	public void setNuevoAspirante(Aspirante nuevoAspirante) {
		this.nuevoAspirante = nuevoAspirante;
	}

	public List<Aspirante> getListaA() {
		return listaA;
	}

	public void setListaA(List<Aspirante> listaA) {
		this.listaA = listaA;
	}

	public void registrar() {
		try {
			aspiranteService.registrarAspirante(nuevoAspirante);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Registro exitoso", "Tus datos de contacto fueron guardados correctamente."));
			nuevoAspirante = new Aspirante();
			cargarAspirantes();
		} catch (IllegalArgumentException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "No se pudo registrar", e.getMessage()));
		}
	}

	public void cargarAspirantes() {
		listaA = aspiranteService.listarAspirantes();
	}

}
