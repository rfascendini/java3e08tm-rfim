package entities;

import java.sql.Time;
import java.time.LocalTime;

public class horarioActividad {

	int idHA;
	int idActividad;
	int idUsuario;
	String dia;
	Time horaComienzo;
	Time horaFin;
	int cuposDisponibles;
	
	public horarioActividad (int idHA, int idActividad, int idUsuario, String dia,Time horaComienzo,Time horaFin,int cuposDisponibles) {
	this.idHA = idHA;
	this.idActividad = idActividad;
	this.idUsuario = idUsuario;
	this.dia = dia;
	this.horaComienzo = horaComienzo;
	this.horaFin = horaFin;
	this.cuposDisponibles = cuposDisponibles;
	}
	
	public horarioActividad() {
	}

	public int getIdHA() {
		return idHA;
	}

	public void setIdHA(int idHA) {
		this.idHA = idHA;
	}

	public String getDia() {
		return dia;
	}

	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Time getHoraComienzo() {
		return horaComienzo;
	}

	public void setHoraComienzo(Time horaComienzo) {
		this.horaComienzo = horaComienzo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public int getCuposDisponibles() {
		return cuposDisponibles;
	}

	public void setCuposDisponibles(int cuposDisponibles) {
		this.cuposDisponibles = cuposDisponibles;
	}
	
	
}
