package co.edu.poli.Proyecto_3.Servicio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import co.edu.poli.Proyecto_3.Modelo.*;
import co.edu.poli.Proyecto_3.Servicio.*;

public class ImplemetacionOperaciones {
	 private Arbol[] arboles;
	    private int tamano = 1;
	    private int ultimo = 0;

	    public ImplemetacionOperaciones() {
	        arboles = new Arbol[tamano];
	    }
	    public void setArboles(Arbol[] arboles) {
	        this.arboles = arboles;
	    }
	    public int getTamano() {
			return tamano;
		}
		public int getUltimo() {
			return ultimo;
		}
	public String crearArbol(Arbol arbol) {
		arboles[ultimo] = arbol;
        ultimo++;
        if (tamano == ultimo) {
            Arbol[] auxiliar = arboles;
            arboles = new Arbol[(tamano) + 1];
            System.arraycopy(auxiliar, 0, arboles, 0, tamano);
            tamano += 1;
        }
        return "Objeto creado con éxito";
    }

	 public Arbol read(String id) {
	        for (int i = 0; i < this.getTamano(); i++) {
	            if (arboles[i] != null && arboles[i].getId().equals(id)) {
	                return arboles[i];
	            }
	        }
	        return null;
	    }

	    public Arbol[] readall() {
	        return Arrays.copyOf(arboles, ultimo);
	    }

	    public String update(String id, Arbol y) {
	        for (int i = 0; i < this.getTamano(); i++) {
	            if (arboles[i] != null && arboles[i].getId().equals(id)) {
	                arboles[i] = y;
	                return "Objeto actualizado con éxito: " + id;
	            }
	        }
	        return "Objeto no encontrado: " + id;
	    }
	    public Arbol delete(String id) {
	        for (int i = 0; i < this.getTamano(); i++) {
	            if (arboles[i] != null && arboles[i].getId().equals(id)) {
	                Arbol eliminado = arboles[i];
	                arboles[i] = null;
	                return eliminado;
	            }
	        }
	        return null;
	    }


	    public String serializar(Arbol[] arboles, String path, String name) {
	        try {
	            FileOutputStream fos = new FileOutputStream(path + name);
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(arboles);
	            oos.close();
	            fos.close();
	            return "File create!!";
	        } catch (IOException ioe) {
	            return "Error file " + ioe.getMessage();
	        }
	    }

	    public Arbol[] deserializar(String path, String name) {
	        Arbol[] a = null;
	        try {
	            FileInputStream fis = new FileInputStream(path + name);
	            ObjectInputStream ois = new ObjectInputStream(fis);

	            a = (Arbol[]) ois.readObject();

	            ois.close();
	            fis.close();
	        } catch (IOException ioe) {
	            System.err.println(ioe.getMessage());
	        } catch (ClassNotFoundException c) {
	            System.err.println(c.getMessage());
	        }
	        return a;
	    }

	}