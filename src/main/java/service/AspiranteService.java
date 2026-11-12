/*
 * Autor: [Nombre completo del estudiante]
 */
package service;

import java.util.List;

import model.Aspirante;
import repository.AspiranteRepository;
import repository.ProgramaRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class AspiranteService {

	@Inject
	private AspiranteRepository aspiranteRepository;

	@Inject
	private ProgramaRepository programaRepository;

	public void registrarAspirante(Aspirante nuevo) {
		nuevo.setIdentificacion(nuevo.getIdentificacion().trim());
		nuevo.setNombres(nuevo.getNombres().trim());
		nuevo.setApellidos(nuevo.getApellidos().trim());
		nuevo.setCorreo(nuevo.getCorreo().trim().toLowerCase());
		nuevo.setTelefono(nuevo.getTelefono().trim());

		if (aspiranteRepository.existsByIdentificacion(nuevo.getIdentificacion())) {
			throw new IllegalArgumentException("Ya hay un aspirante registrado con esa identificación.");
		}
		if (aspiranteRepository.existsByCorreo(nuevo.getCorreo())) {
			throw new IllegalArgumentException("Ya hay un aspirante registrado con ese correo.");
		}
		if (programaRepository.findByNombre(nuevo.getPrograma()).isEmpty()) {
			throw new IllegalArgumentException("El programa académico seleccionado ya no existe.");
		}

		aspiranteRepository.save(nuevo);
	}

	public List<Aspirante> listarAspirantes() {
		return aspiranteRepository.findAll();
	}

}
