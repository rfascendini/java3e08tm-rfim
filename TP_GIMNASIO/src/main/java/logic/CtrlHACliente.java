package logic;

import java.util.LinkedList;
import data.DataHACliente;
import entities.ha_cliente;

public class CtrlHACliente {

	private DataHACliente dhac = new DataHACliente();

	public LinkedList<ha_cliente> listarHAC() {
		
		LinkedList<ha_cliente> listaHACes = new LinkedList<ha_cliente>();
		
		listaHACes = dhac.listarHAC();
		
		return listaHACes;
			
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
	
	
}
