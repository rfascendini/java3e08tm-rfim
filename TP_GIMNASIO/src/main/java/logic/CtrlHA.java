package logic;

import entities.*;
import data.*;
import java.util.LinkedList;

public class CtrlHA {

	private DataHA dha = new DataHA();

	public LinkedList<horarioActividad> listarHA() {

		LinkedList<horarioActividad> listaActividades = new LinkedList<horarioActividad>();

		listaActividades = dha.listarHA();

		return listaActividades;

	}

	public LinkedList<horarioActividad> listarHAporProfesor(int idDocente) {

		LinkedList<horarioActividad> listaActividades = new LinkedList<horarioActividad>();

		listaActividades = dha.listarHAporProfesor(idDocente);

		return listaActividades;

	}

	public LinkedList<horarioActividad> listarHAporActividad(int idActividad) {

		LinkedList<horarioActividad> listaActividades = new LinkedList<horarioActividad>();

		listaActividades = dha.listarHAporActividad(idActividad);

		return listaActividades;

	}

	public horarioActividad getHA(int idHA) {

		horarioActividad ha = new horarioActividad();

		ha.setIdHA(idHA);

		horarioActividad a2 = new horarioActividad();

		a2 = dha.seleccionarPorID(ha);

		if (a2 != null) {
			return a2;
		} else {
			return null;
		}
	}

	public int nuevoHA(horarioActividad ha) {

		int nuevoActividad = dha.nuevoHA(ha);

		return nuevoActividad;

	}

	public int editarHA(horarioActividad ha) {

		int editarActividad = dha.editarHA(ha);

		return editarActividad;

	}

	public int eliminarHA(horarioActividad ha) {

		int eliminarHA = dha.eliminarHA(ha);

		return eliminarHA;

	}

}