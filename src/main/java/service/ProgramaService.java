/*
 * Autor: Juan Felipe Rocha 
 */
package service;

import java.util.List;

import model.ProgramaAcademico;
import repository.ProgramaRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class ProgramaService {

	@Inject
	private ProgramaRepository programaRepository;

	public void registrarPrograma(ProgramaAcademico nuevo) {
		validarNombre(nuevo);
		if (programaRepository.findByNombre(nuevo.getNombre()).isPresent()) {
			throw new IllegalArgumentException("Ya existe un programa con ese nombre.");
		}
		programaRepository.save(nuevo);
	}

	public void actualizarPrograma(ProgramaAcademico editado) {
		validarNombre(editado);
		ProgramaAcademico existente = programaRepository.findByNombre(editado.getNombre()).orElse(null);
		if (existente != null && existente.getId() != editado.getId()) {
			throw new IllegalArgumentException("Ya existe un programa con ese nombre.");
		}
		programaRepository.update(editado);
	}

	public void eliminarPrograma(int id) {
		programaRepository.delete(id);
	}

	public List<ProgramaAcademico> listarProgramas() {
		return programaRepository.findAll();
	}

	private void validarNombre(ProgramaAcademico p) {
		if (p == null || p.getNombre() == null || p.getNombre().isBlank()) {
			throw new IllegalArgumentException("El nombre del programa es obligatorio.");
		}
		p.setNombre(p.getNombre().trim());
	}

}
