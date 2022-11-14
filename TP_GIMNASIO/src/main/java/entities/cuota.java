package entities;

public class cuota {

	int idCuota;
	int mes;
	String nombreMes;
	int anio;
	int monto;
	
	public cuota (int idCuota, int mes, String nombreMes, int anio, int monto) {
		this.idCuota = idCuota;
		this.mes = mes;
		this.nombreMes = nombreMes;
		this.anio = anio;
		this.monto = monto;
	}
	
	public cuota () {
		
	}

	public int getIdCuota() {
		return idCuota;
	}

	public String getNombreMes() {
		return nombreMes;
	}

	public void setNombreMes(String nombreMes) {
		this.nombreMes = nombreMes;
	}

	public void setIdCuota(int idCuota) {
		this.idCuota = idCuota;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}
	
	
}
