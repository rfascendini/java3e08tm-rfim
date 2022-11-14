package entities;


import java.time.LocalDateTime;


public class cliente_cuota {

	int idCuotaCliente; 
	public usuario usuario;
	public cuota cuota; 
	LocalDateTime fechaPago;
	float montoAbonado;
	
	public cliente_cuota(int idCuotaCliente, int idCuota, int idCliente, LocalDateTime fechaPago, float montoAbonado) {
		this.idCuotaCliente = idCuotaCliente;
		this.cuota.setIdCuota(idCuota);
		this.usuario.setIdUsuario(idCliente);
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


	public usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(usuario usuario) {
		this.usuario = usuario;
	}

	public cuota getCuota() {
		return cuota;
	}

	public void setCuota(cuota cuota) {
		this.cuota = cuota;
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}


	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}


	public float getMontoAbonado() {
		return montoAbonado;
	}


	public void setMontoAbonado(float montoAbonado) {
		this.montoAbonado = montoAbonado;
	}
	

	
	
	
	
	
}
