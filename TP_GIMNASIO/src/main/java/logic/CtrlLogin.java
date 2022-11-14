package logic;


import entities.*;
import data.*;





public class CtrlLogin {
	
	private DataUsuario du = new DataUsuario();
	

	public usuario validar(String dni, String password) {
		
		usuario u = new usuario();
		
		u.setDni(Integer.parseInt(dni));
		u.setPassword(password);
		
		usuario u2 = new usuario();
		
		u2 = du.seleccionarPorUsuario(u);
		
		if(u2 != null) {
			return u2;
		} else {
			return null;
		}
	}
	
	
}
