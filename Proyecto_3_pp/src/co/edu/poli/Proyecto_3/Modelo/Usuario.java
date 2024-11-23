package co.edu.poli.Proyecto_3.Modelo;

import java.io.Serializable;
import java.util.Arrays;

public class Usuario implements Serializable {
	  private int id;
	  private String nombre;
	  private String rol;
	  private String correo;
	  private int telefono;
	  private Arbol[] arbol;
	  
	  public Usuario(int id, String nombre, String rol, String correo, int telefono, Arbol[] arbol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rol = rol;
		this.correo = correo;
		this.telefono = telefono;
		this.arbol = arbol;
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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Arbol[] getArbol() {
		return arbol;
	}

	public void setArbol(Arbol[] arbol) {
		this.arbol = arbol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", rol=" + rol + ", correo=" + correo + ", telefono="
				+ telefono + ", arbol=" + Arrays.toString(arbol) + "]";
	}
	
}

