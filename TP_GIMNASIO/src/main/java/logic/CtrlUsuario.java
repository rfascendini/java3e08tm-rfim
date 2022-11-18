package logic;


import entities.*;
import data.*;


import java.util.LinkedList;

public class CtrlUsuario {

	private DataUsuario du = new DataUsuario();

	public LinkedList<usuario> listarUsuarios(String tipoUsuario) {
		
		LinkedList<usuario> listaUsuarios = new LinkedList<usuario>();
		
		listaUsuarios = du.listarUsuarios(tipoUsuario);
		
		return listaUsuarios;
			
	}
	
	
	
	
	public usuario getUsuario(int idUsuario) {

		usuario u = new usuario();

		u.setIdUsuario(idUsuario);

		usuario u2 = new usuario();

		u2 = du.seleccionarPorID(u);

		if (u2 != null) {
			return u2;
		} else {
			return null;
		}
	}

	public int nuevoUsuario(usuario u) {

		int nuevoUsuario = du.nuevoUsuario(u);

		return nuevoUsuario;

	}
	

	public int editarUsuario(usuario u) {

		int editarUsuario = du.editarUsuario(u);

		return editarUsuario;

	}

	public int eliminarUsuario(usuario u) {

		int eliminarUsuario = du.eliminarUsuario(u);

		return eliminarUsuario;

	}

}
