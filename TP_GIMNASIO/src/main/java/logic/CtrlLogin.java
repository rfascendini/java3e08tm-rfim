package logic;

import logic.*;
import entities.*;
import data.*;

import java.util.Arrays;
import java.util.LinkedList;



public class CtrlLogin {
	
	private DataUsuario du = new DataUsuario();
	

	public usuario validar(String dni, String password) {
		
		usuario u = new usuario();
		
		u.setDni(Integer.parseInt(dni));
		u.setPassword(password);
		
		System.out.println(u.getDni());
		System.out.println(u.getPassword());
		
		usuario u2 = new usuario();
		
		u2 = du.seleccionarPorUsuario(u);
		
		if(u2 != null) {
			return u2;
		} else {
			return null;
		}
	}
	
	public LinkedList<usuario> listarUsuarios() {
		return du.listarUsuarios();
		
	}
	
	
	
}
