package co.edu.poli.Proyecto_3.Modelo;
import java.io.Serializable;
import java.util.Date;
public class Arbol implements Serializable  {
	 	private String id;
	    private String especie;
	    private String ubicacion;
	    private boolean estadoSalud;
	    private String fechaPlantacion;
	    
	    

	    public Arbol(String id, String especie, String ubicacion, boolean estadoSalud, String fechaPlantacion) {
	        this.id = id;
	        this.especie = especie;
	        this.ubicacion = ubicacion;
	        this.estadoSalud = estadoSalud;
	        this.fechaPlantacion = fechaPlantacion;
	    }

		public Arbol() {
			
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getEspecie() {
			return especie;
		}

		public void setEspecie(String especie) {
			this.especie = especie;
		}

		public String getUbicacion() {
			return ubicacion;
		}

		public void setUbicacion(String ubicacion) {
			this.ubicacion = ubicacion;
		}

		public boolean getEstadoSalud() {
			return estadoSalud;
		}

		public void setEstadoSalud(boolean estadoSalud) {
			this.estadoSalud = estadoSalud;
		}

		public String getFechaPlantacion() {
			return fechaPlantacion;
		}

		public void setFechaPlantacion(String fechaPlantacion) {
			this.fechaPlantacion = fechaPlantacion;
		}

		@Override
		public String toString() {
			return "Arbol [id=" + id + ", especie=" + especie + ", ubicacion=" + ubicacion + ", estadoSalud="
					+ estadoSalud + ", fechaPlantacion=" + fechaPlantacion + "]";
		}
	    
	}


