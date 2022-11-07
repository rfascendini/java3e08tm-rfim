package logic;

import java.util.LinkedList;
import data.DataHACliente;
import entities.ha_cliente;

public class CtrlHACliente {

	private DataHACliente dhac = new DataHACliente();

	public LinkedList<ha_cliente> listarHAC() {
		
		LinkedList<ha_cliente> listaHAC = new LinkedList<ha_cliente>();
		
		listaHAC = dhac.listarHAC();
		
		return listaHAC;
			
	}
	
	public LinkedList<ha_cliente> listarHACporActividad(int idActividad) {
		
		LinkedList<ha_cliente> listaHAC = new LinkedList<ha_cliente>();
		
		listaHAC = dhac.listarHACporActividad(idActividad);
		
		return listaHAC;
	}
	
	public LinkedList<ha_cliente> listarHACporCliente(int idCliente) {
		
		LinkedList<ha_cliente> listaHAC = new LinkedList<ha_cliente>();
		
		listaHAC = dhac.listarHACporCliente(idCliente);
		
		return listaHAC;
			
	}
	
	
	public ha_cliente getHAC(int idHAC) {

		ha_cliente hac = new ha_cliente();

		hac.setIdHAC(idHAC);

		ha_cliente hac2 = new ha_cliente();

		hac2 = dhac.seleccionarPorID(hac);


		if (hac2 != null) {
			return hac2;
		} else {
			return null;
		}
	}

	public int nuevoHAC(ha_cliente hac) {

		int nuevoHAC = dhac.nuevoHAC(hac);

		return nuevoHAC;

	}
	

	public int editarHAC(ha_cliente hac) {

		int editarHAC = dhac.editarHAC(hac);

		return editarHAC;

	}

	public int eliminarHAC(ha_cliente hac) {

		int eliminarHAC = dhac.eliminarHAC(hac);

		return eliminarHAC;

	}
	
	public int darDeBajaHAC(ha_cliente hac) {

		int darDeBajaHAC = dhac.darDeBajaHAC(hac);

		return darDeBajaHAC;

	}


	
	
}
