package entities;

import java.time.LocalDate;

public class cliente_cuota {

	int idCuotaCliente; 
	int idCuota;
	int idCliente;
	LocalDate fechaPago;
	float montoAbonado;
	
	public cliente_cuota(int idCuotaCliente, int idCuota, int idCliente, LocalDate fechaPago, float montoAbonado) {
		this.idCuotaCliente = idCuotaCliente;
		this.idCuota = idCuota;
		this.idCliente = idCliente;
		this.fechaPago = fechaPago;
		this.montoAbonado = montoAbonado;
	}
	
	public cliente_cuota() {
	}

	public int getIdCuotaCliente() {
		return idCuotaCliente;
	}

	public void setIdCuotaCliente(int idCuotaCliente) {
		this.idCuotaCliente = idCuotaCliente;
	}

	public int getIdCuota() {
		return idCuota;
	}


	public void setIdCuota(int idCuota) {
		this.idCuota = idCuota;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public LocalDate getFechaPago() {
		return fechaPago;
	}


	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}


	public float getMontoAbonado() {
		return montoAbonado;
	}


	public void setMontoAbonado(float montoAbonado) {
		this.montoAbonado = montoAbonado;
	}
	

	
	
	
	
	
}
