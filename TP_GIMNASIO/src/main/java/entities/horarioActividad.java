package entities;

import java.time.LocalTime;

public class horarioActividad {

	int idHA;
	String dia;
	LocalTime horaComienzo;
	LocalTime horaFin;
	int cuposDisponibles;
	
	public horarioActividad (int idHA,String dia,LocalTime horaComienzo,LocalTime horaFin,int cuposDisponibles) {
	this.idHA = idHA;
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

	public void setDia(String dia) {
		this.dia = dia;
	}

	public LocalTime getHoraComienzo() {
		return horaComienzo;
	}

	public void setHoraComienzo(LocalTime horaComienzo) {
		this.horaComienzo = horaComienzo;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public int getCuposDisponibles() {
		return cuposDisponibles;
	}

	public void setCuposDisponibles(int cuposDisponibles) {
		this.cuposDisponibles = cuposDisponibles;
	}
	
	
}
