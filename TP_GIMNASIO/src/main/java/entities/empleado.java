package entities;

import java.time.LocalDate;

public class empleado extends usuario {

	int idEmpleado;
	char tipoEmpleado;
	
	public empleado(int idUsuario, String nombre, String apellido, LocalDate fechaNacimiento, int dni, char sexo, String domicilio, String password, String email, String telefono, int habilitado, int eliminado, int idEmpleado,char tipoEmpleado) {
		super(idUsuario, nombre, apellido, fechaNacimiento, dni, sexo, domicilio, password, email, telefono, habilitado, eliminado);
		this.idEmpleado = idEmpleado;
		this.tipoEmpleado = tipoEmpleado;
	}

	public empleado() {
		super();
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public char getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(char tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
	
	
	
	
}
