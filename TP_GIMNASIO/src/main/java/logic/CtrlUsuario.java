package logic;

import logic.*;
import entities.*;
import data.*;

import java.util.Arrays;
import java.util.LinkedList;



public class CtrlUsuario {
	
	private DataUsuario du = new DataUsuario();
	

	public usuario getUsuario(int idUsuario) {
		
		usuario u = new usuario();
		
		u.setIdUsuario(idUsuario);
		
		usuario u2 = new usuario();
		
		u2 = du.seleccionarPorID(u);
		
		if(u2 != null) {
			return u2;
		} else {
			return null;
		}
	}
	
	
}
