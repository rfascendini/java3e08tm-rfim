package logic;

import java.util.LinkedList;


import data.DataCuotaCliente;
import entities.cliente_cuota;
import entities.cuota;

import entities.usuario;

public class CtrlCuotaCliente {
	
	private DataCuotaCliente da = new DataCuotaCliente();
	

	
	public LinkedList<cliente_cuota> listarClientesPorCuota(cuota cuota) {

		LinkedList<cliente_cuota> lista = new LinkedList<cliente_cuota>();
		
		lista = da.listarClientesPorCuota(cuota);
		
		return lista;

	}

	public LinkedList<cliente_cuota> listarCuotasPorCliente(usuario cliente) {

		LinkedList<cliente_cuota> lista = new LinkedList<cliente_cuota>();
		
		lista = da.listarCuotasPorCliente(cliente);
		
		return lista;

	}
	
	public int nuevoCC(cuota c, usuario u) {

		int nuevoCC = da.nuevoCC(c,u);

		return nuevoCC;

	}
	
}
