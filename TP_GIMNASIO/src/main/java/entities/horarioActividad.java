package entities;


import java.time.LocalTime;


public class horarioActividad {

	int idHA;
	String dia;
	LocalTime horaComienzo;
	LocalTime horaFin;
	int cuposDisponibles;
	int eliminado;
	
	//continuar
	public actividad actividad;
	public usuario usuario;
	

	public horarioActividad (int idHA, int idActividad, int idUsuario, String dia,LocalTime horaComienzo,LocalTime horaFin,int cuposDisponibles, int eliminado) {
	this.idHA = idHA;
	this.actividad.setIdActividad(idActividad);
	this.usuario.setIdUsuario(idUsuario);
	this.dia = dia;
	this.horaComienzo = horaComienzo;
	this.horaFin = horaFin;
	this.cuposDisponibles = cuposDisponibles;
	this.eliminado = eliminado;
	}
	
	public horarioActividad (int idHA, actividad act, usuario usu, String dia,LocalTime horaComienzo,LocalTime horaFin,int cuposDisponibles, int eliminado) {
	this.idHA = idHA;
	this.actividad = act;
	this.usuario = usu;
	this.dia = dia;
	this.horaComienzo = horaComienzo;
	this.horaFin = horaFin;
	this.cuposDisponibles = cuposDisponibles;
	this.eliminado = eliminado;
	}
	
	public horarioActividad() {
	}
	
	public actividad getActividad() {
		return actividad;
	}

	public void setActividad(actividad act) {
		this.actividad = act;
	}

	public usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(usuario usu) {
		this.usuario = usu;
	}

	public int getEliminado() {
		return eliminado;
	}

	public void setEliminado(int eliminado) {
		this.eliminado = eliminado;
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
