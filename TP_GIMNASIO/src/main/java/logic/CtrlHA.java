package logic;

import logic.*;
import entities.*;
import data.*;

import java.util.Arrays;
import java.util.LinkedList;

public class CtrlHA {

	private DataHA da = new DataHA();

	public LinkedList<horarioActividad> listarHA() {
		
		LinkedList<horarioActividad> listaActividades = new LinkedList<horarioActividad>();
		
		listaActividades = da.listarHA();
		
		return listaActividades;
			
	}
	
	
	public horarioActividad getActividad(int idActividad) {

		horarioActividad ha = new horarioActividad();

		ha.setIdHA(idActividad);

		horarioActividad a2 = new horarioActividad();

		a2 = da.seleccionarPorID(ha);


		if (a2 != null) {
			return a2;
		} else {
			return null;
		}
	}

	public int nuevoActividad(horarioActividad ha) {

		int nuevoActividad = da.nuevoHA(ha);

		return nuevoActividad;

	}
	

	public int editarActividad(horarioActividad ha) {

		int editarActividad = da.editarHA(ha);

		return editarActividad;

	}

	public int eliminarActividad(horarioActividad ha) {

		int eliminarActividad = da.eliminarHA(ha);

		return eliminarActividad;

	}

}