package entities;

public class actividad {

	int idActividad;
	String nombre;
	int idEmpleado;
	String descripcion;
	
	public actividad (int idActividad, String nombre, int idEmpleado, String descripcion) {
		this.idActividad = idActividad;
		this.nombre = nombre;
		this.idEmpleado = idEmpleado;
		this.descripcion = descripcion;
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

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
