/*
 * Autor: [Nombre completo del estudiante]
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import model.ProgramaAcademico;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProgramaRepository {

	private final List<ProgramaAcademico> baseDatos = new CopyOnWriteArrayList<ProgramaAcademico>();
	private final AtomicInteger contador = new AtomicInteger(0);

	@PostConstruct
	public void cargarProgramasIniciales() {
		save(new ProgramaAcademico(0, "Ingeniería de Sistemas"));
		save(new ProgramaAcademico(0, "Ingeniería Industrial"));
		save(new ProgramaAcademico(0, "Matemática"));
		save(new ProgramaAcademico(0, "Administración de Empresas"));
		save(new ProgramaAcademico(0, "Derecho"));
		save(new ProgramaAcademico(0, "Ingeniería Temática"));
	}

	public void save(ProgramaAcademico nuevo) {
		nuevo.setId(contador.incrementAndGet());
		baseDatos.add(new ProgramaAcademico(nuevo.getId(), nuevo.getNombre()));
	}

	public void update(ProgramaAcademico editado) {
		for (ProgramaAcademico p : baseDatos) {
			if (p.getId() == editado.getId()) {
				p.setNombre(editado.getNombre());
			}
		}
	}

	public void delete(int id) {
		baseDatos.removeIf(p -> p.getId() == id);
	}

	// devuelve copias para que editar en la tabla no cambie el original sin validar
	public List<ProgramaAcademico> findAll() {
		List<ProgramaAcademico> copia = new ArrayList<ProgramaAcademico>();
		for (ProgramaAcademico p : baseDatos) {
			copia.add(new ProgramaAcademico(p.getId(), p.getNombre()));
		}
		return copia;
	}

	public Optional<ProgramaAcademico> findByNombre(String nombre) {
		return baseDatos.stream().filter(p -> p.getNombre().equalsIgnoreCase(nombre)).findFirst();
	}

}
