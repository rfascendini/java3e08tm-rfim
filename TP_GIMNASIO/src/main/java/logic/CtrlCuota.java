package logic;

import java.util.LinkedList;

import data.DataCuota;
import entities.cuota;

public class CtrlCuota {

	private DataCuota da = new DataCuota();

	public LinkedList<cuota> listarCuotas() {
		
		LinkedList<cuota> listaCuotas = new LinkedList<cuota>();
		
		listaCuotas = da.listarCuotas();
		
		return listaCuotas;
			
	}
	
public LinkedList<cuota> listarCuotasDisponibles() {
		
		LinkedList<cuota> listaCuotas = new LinkedList<cuota>();
		
		listaCuotas = da.listarCuotasDisponibles();
		
		return listaCuotas;
			
	}
	
	
	public cuota getCuota(int idCuota) {

		cuota c = new cuota();

		c.setIdCuota(idCuota);

		cuota c2 = new cuota();

		c2 = da.seleccionarPorID(c);


		if (c2 != null) {
			return c2;
		} else {
			return null;
		}
	}

	

	public int editarCuota(cuota a) {

		int editarCuota = da.editarCuota(a);

		return editarCuota;

	}
	
}
