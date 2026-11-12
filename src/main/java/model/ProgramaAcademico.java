/*
 * Autor: Juan Felipe Rocha 
 */
package model;

import java.io.Serializable;
import java.util.Objects;

public class ProgramaAcademico implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nombre;

	public ProgramaAcademico() {

	}

	public ProgramaAcademico(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProgramaAcademico other = (ProgramaAcademico) obj;
		return id == other.id && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "ProgramaAcademico [id=" + id + ", nombre=" + nombre + "]";
	}

}
