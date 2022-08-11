package entities;

import java.time.LocalDate;

public class ha_cliente {
	
	int idHAC;
	int idHA;
	int idCliente; 
	LocalDate fechaRegistro;
	LocalDate fechaBaja;
	
	public ha_cliente (int idHAC,int idHA,int idCliente, LocalDate fechaRegistro,LocalDate fechaBaja) {
	this.idHAC = idHAC;
	this.idHA = idHA;
	this.idCliente = idCliente;
	this.fechaRegistro = fechaRegistro;
	this.fechaBaja = fechaBaja;
	}
	
	public ha_cliente () {
		
	}

	public int getIdHAC() {
		return idHAC;
	}

	public void setIdHAC(int idHAC) {
		this.idHAC = idHAC;
	}

	public int getIdHA() {
		return idHA;
	}

	public void setIdHA(int idHA) {
		this.idHA = idHA;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public LocalDate getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	

}
