package entities;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ha_cliente {
	
	int idHAC;
	public horarioActividad ha;
	public usuario usuario; 
	LocalDateTime fechaRegistro;
	LocalDateTime fechaBaja;
	
	public ha_cliente (int idHAC,int idHA,int idUsuario, LocalDateTime fechaRegistro,LocalDateTime fechaBaja) {
	this.idHAC = idHAC;
	this.ha.setIdHA(idHA);
	this.usuario.setIdUsuario(idUsuario);
	this.fechaRegistro = fechaRegistro;
	this.fechaBaja = fechaBaja;
	}
	
	public ha_cliente (int idHAC, horarioActividad ha, usuario usu, LocalDateTime fechaRegistro,LocalDateTime fechaBaja) {
		this.idHAC = idHAC;
		this.ha = ha;
		this.usuario = usu;
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

	public horarioActividad getHA() {
		return ha;
	}

	public void setHA(horarioActividad ha) {
		this.ha = ha;
	}

	public usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public LocalDateTime getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(LocalDateTime fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	

}
