/*
 * Autor: [Nombre completo del estudiante]
 */
package model;

import java.io.Serializable;
import java.util.Objects;

public class Aspirante implements Serializable {

	private static final long serialVersionUID = 1L;

	private String identificacion;
	private String nombres;
	private String apellidos;
	private String correo;
	private String telefono;
	private String programa;

	public Aspirante() {

	}

	public Aspirante(String identificacion, String nombres, String apellidos, String correo, String telefono,
			String programa) {
		super();
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.telefono = telefono;
		this.programa = programa;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, correo, identificacion, nombres, programa, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aspirante other = (Aspirante) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(correo, other.correo)
				&& Objects.equals(identificacion, other.identificacion) && Objects.equals(nombres, other.nombres)
				&& Objects.equals(programa, other.programa) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Aspirante [identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", correo=" + correo + ", telefono=" + telefono + ", programa=" + programa + "]";
	}

}
