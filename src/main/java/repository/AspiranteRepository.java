/*
 * Autor: Juan Felipe Rocha 
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import model.Aspirante;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AspiranteRepository {

	private final List<Aspirante> baseDatos = new CopyOnWriteArrayList<Aspirante>();

	public void save(Aspirante nuevo) {
		baseDatos.add(nuevo);
	}

	public List<Aspirante> findAll() {
		return new ArrayList<Aspirante>(baseDatos);
	}

	public boolean existsByIdentificacion(String identificacion) {
		return baseDatos.stream().anyMatch(a -> a.getIdentificacion().equals(identificacion));
	}

	public boolean existsByCorreo(String correo) {
		return baseDatos.stream().anyMatch(a -> a.getCorreo().equalsIgnoreCase(correo));
	}

}
