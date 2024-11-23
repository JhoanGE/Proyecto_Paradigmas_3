package co.edu.poli.Proyecto_3.Modelo;

import java.io.Serializable;
import java.util.Date;

public class Imforme implements Serializable {
	private String contenido;
    private Date fechaGeneracion;
    private Arbol arbol;
    
    public Imforme(String contenido, Date fechaGeneracion, Arbol arbol) {
		super();
		this.contenido = contenido;
		this.fechaGeneracion = fechaGeneracion;
		this.arbol = arbol;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public Arbol getArbol() {
		return arbol;
	}

	public void setArbol(Arbol arbol) {
		this.arbol = arbol;
	}

	@Override
	public String toString() {
		return "Imforme [contenido=" + contenido + ", fechaGeneracion=" + fechaGeneracion + ", arbol=" + arbol + "]";
	}
	
}