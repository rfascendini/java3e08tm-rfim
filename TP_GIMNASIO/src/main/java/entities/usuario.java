package entities;

import java.time.LocalDate;

public class usuario {

	int idUsuario;
	String nombre;
	String apellido;
	LocalDate fechaNacimiento;
	int dni;
	char sexo;  
	String domicilio;
	String password;
	String email;
	String telefono;
	int habilitado; 
	int eliminado;
	
	public usuario (int idUsuario, String nombre,String apellido,LocalDate fechaNacimiento,int dni,char sexo, String domicilio,String password, String email, String telefono,int habilitado, int eliminado) {
	this.idUsuario = idUsuario;
	this.nombre = nombre;
	this.apellido = apellido;
	this.fechaNacimiento = fechaNacimiento;
	this.dni = dni;
	this.sexo = sexo;  
	this.domicilio = domicilio;
	this.password = password;
	this.email = email;
	this.telefono = telefono;
	this.habilitado = habilitado; 
	this.eliminado = eliminado;
	
	}
	
	public usuario() {
	
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(int habilitado) {
		this.habilitado = habilitado;
	}

	public int getEliminado() {
		return eliminado;
	}

	public void setEliminado(int eliminado) {
		this.eliminado = eliminado;
	}
	
	
	
	
}
	
	

