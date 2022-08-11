package entities;

public class cuota {

	int idCuota;
	String mes;
	int anio;
	double monto;
	
	public cuota (int idCuota, String mes, int anio, double monto) {
		this.idCuota = idCuota;
		this.mes = mes;
		this.anio = anio;
		this.monto = monto;
	}
	
	public cuota () {
		
	}

	public int getIdCuota() {
		return idCuota;
	}

	public void setIdCuota(int idCuota) {
		this.idCuota = idCuota;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
}
