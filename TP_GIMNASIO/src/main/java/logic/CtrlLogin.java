package logic;

import logic.*;
import entities.*;
import data.*;

import java.util.LinkedList;



public class CtrlLogin {
	
	private DataUsuario du;
	

	public usuario validar(String dni, String password) {
		
		usuario u = new usuario();
		
		u.setDni(Integer.parseInt(dni));
		u.setPassword(password);
		
		if(du.seleccionarPorUsuario(u) != null) {
			return u;
		} else {
			return null;
		}
	}
	
	public LinkedList<usuario> listarUsuarios() {
		return du.listarUsuarios();
		
	}
	
	
	
}
