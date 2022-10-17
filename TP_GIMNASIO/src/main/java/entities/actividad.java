package entities;

public class actividad {

	int idActividad;
	String nombre;
	String descripcion;
	int eliminado;
	
	
	public actividad (int idActividad, String nombre, String descripcion, int eliminado) {
		this.idActividad = idActividad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.eliminado = eliminado;
	}
	
	public actividad () {
		
	}

	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public int getEliminado() {
		return eliminado;
	}

	public void setEliminado(int eliminado) {
		this.eliminado = eliminado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
