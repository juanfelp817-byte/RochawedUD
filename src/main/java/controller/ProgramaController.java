/*
 * Autor: [Nombre completo del estudiante]
 */
package controller;

import java.io.Serializable;
import java.util.List;

import org.primefaces.event.RowEditEvent;

import model.ProgramaAcademico;
import service.ProgramaService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

// esto es un bean

@Named("progBean")
@ViewScoped
public class ProgramaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProgramaService programaService;

	private ProgramaAcademico nuevoPrograma;
	private List<ProgramaAcademico> listaP;

	@PostConstruct
	public void init() {
		nuevoPrograma = new ProgramaAcademico();
		cargarProgramas();
	}

	public ProgramaController() {

	}

	public ProgramaAcademico getNuevoPrograma() {
		return nuevoPrograma;
	}

	public void setNuevoPrograma(ProgramaAcademico nuevoPrograma) {
		this.nuevoPrograma = nuevoPrograma;
	}

	public List<ProgramaAcademico> getListaP() {
		return listaP;
	}

	public void setListaP(List<ProgramaAcademico> listaP) {
		this.listaP = listaP;
	}

	public void agregar() {
		try {
			programaService.registrarPrograma(nuevoPrograma);
			mensaje(FacesMessage.SEVERITY_INFO, "Programa agregado", "El programa se agregó correctamente.");
			nuevoPrograma = new ProgramaAcademico();
		} catch (IllegalArgumentException e) {
			mensaje(FacesMessage.SEVERITY_WARN, "No se pudo agregar", e.getMessage());
		}
		cargarProgramas();
	}

	public void onRowEdit(RowEditEvent<ProgramaAcademico> event) {
		try {
			programaService.actualizarPrograma(event.getObject());
			mensaje(FacesMessage.SEVERITY_INFO, "Programa actualizado", "Los cambios se guardaron.");
		} catch (IllegalArgumentException e) {
			mensaje(FacesMessage.SEVERITY_WARN, "No se pudo actualizar", e.getMessage());
		}
		cargarProgramas();
	}

	public void eliminar(ProgramaAcademico programa) {
		programaService.eliminarPrograma(programa.getId());
		mensaje(FacesMessage.SEVERITY_INFO, "Programa eliminado", "El programa se eliminó de la lista.");
		cargarProgramas();
	}

	public void cargarProgramas() {
		listaP = programaService.listarProgramas();
	}

	private void mensaje(FacesMessage.Severity tipo, String titulo, String detalle) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, titulo, detalle));
	}

}
