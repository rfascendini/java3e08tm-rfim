package entities;

import java.time.LocalDate;

public class historialVisita {

	int idHV;
	LocalDate fechaIngreso;
	LocalDate fechaEgreso;
	private int idUsuario;
	
	public historialVisita (int idHV, LocalDate fechaIngreso, LocalDate fechaEgreso, int idUsuario) {
		this.idHV = idHV;
		this.fechaIngreso = fechaIngreso;
		this.fechaEgreso = fechaEgreso;
		this.idUsuario = idUsuario;
	}

	public int getIdHV() {
		return idHV;
	}

	public void setIdHV(int idHV) {
		this.idHV = idHV;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(LocalDate fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
