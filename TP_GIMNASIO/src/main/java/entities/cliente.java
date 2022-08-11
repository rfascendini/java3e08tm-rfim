package entities;

import java.time.LocalDate;

public class cliente extends usuario {

	public cliente(int idUsuario, String nombre, String apellido, LocalDate fechaNacimiento, int dni, char sexo, String domicilio, String password,String email, String telefono, int habilitado, int eliminado) {
		super(idUsuario, nombre, apellido, fechaNacimiento, dni, sexo, domicilio, password,email,telefono, habilitado, eliminado);
		
	}
	
}
