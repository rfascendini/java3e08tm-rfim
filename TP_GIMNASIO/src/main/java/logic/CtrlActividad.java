package logic;


import entities.*;
import data.*;

import java.util.LinkedList;

public class CtrlActividad {

	private DataActividad da = new DataActividad();

	public LinkedList<actividad> listarActividades() {
		
		LinkedList<actividad> listaActividades = new LinkedList<actividad>();
		
		listaActividades = da.listarActividades();
		
		return listaActividades;
			
	}
	
	
	public actividad getActividad(int idActividad) {

		actividad a = new actividad();

		a.setIdActividad(idActividad);

		actividad a2 = new actividad();

		a2 = da.seleccionarPorID(a);


		if (a2 != null) {
			return a2;
		} else {
			return null;
		}
	}

	public int nuevoActividad(actividad a) {

		int nuevoActividad = da.nuevoActividad(a);

		return nuevoActividad;

	}
	

	public int editarActividad(actividad a) {

		int editarActividad = da.editarActividad(a);

		return editarActividad;

	}

	public int eliminarActividad(actividad a) {

		int eliminarActividad = da.eliminarActividad(a);

		return eliminarActividad;

	}

}