package co.edu.poli.Proyecto_3.Servicio;

import java.util.List;

import co.edu.poli.Proyecto_3.Modelo.Arbol;

public interface Operacion {
	public String crearArbol(Arbol arbol);
	public Arbol read(String id);
	public Arbol[] readall();
	public String update(String id, Arbol y);
	public Arbol delete(String id);
	public String serializar(Arbol[] arboles, String path, String name);
	public Arbol[] deserializar(String path, String name);
}
