package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.cuota;

public class DataCuotaCliente {

	
	public LinkedList<cuota> listarCuotasClientes() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<cuota> Cuotas = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().conectar().createStatement();
			rs = stmt.executeQuery("SELECT * FROM cuotas_clientes cc INNER JOIN ");
			if (rs != null) {
				while (rs.next()) {
					cuota c = new cuota();

					c.setIdCuota(rs.getInt("idCuota"));
					c.setAnio(rs.getInt("año"));
					c.setMes(rs.getInt("mes"));
					c.setMonto(rs.getInt("monto"));

					Cuotas.add(c);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				DbConnector.getInstancia().desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return Cuotas;
	}
	
	public LinkedList<cuota> listarCuotasPorCliente() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<cuota> Cuotas = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().conectar().createStatement();
			rs = stmt.executeQuery("select * from cuotas where monto is not null");
			if (rs != null) {
				while (rs.next()) {
					cuota c = new cuota();

					c.setIdCuota(rs.getInt("idCuota"));
					c.setAnio(rs.getInt("año"));
					c.setMes(rs.getInt("mes"));
					c.setMonto(rs.getInt("monto"));

					Cuotas.add(c);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				DbConnector.getInstancia().desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return Cuotas;
	}
	
	public LinkedList<cuota> listarCuotasPorCuota(cuota cuota) {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<cuota> Cuotas = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().conectar().createStatement();
			rs = stmt.executeQuery("select * from cuotas where monto is not null");
			if (rs != null) {
				while (rs.next()) {
					cuota c = new cuota();

					c.setIdCuota(rs.getInt("idCuota"));
					c.setAnio(rs.getInt("año"));
					c.setMes(rs.getInt("mes"));
					c.setMonto(rs.getInt("monto"));

					Cuotas.add(c);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				DbConnector.getInstancia().desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return Cuotas;
	}
	
	
	public int editarCuota(cuota updCuota) {
		PreparedStatement stmt = null;

		try {
			stmt = DbConnector.getInstancia().conectar().prepareStatement("update cuotas "+ "set monto = ? " + "where idCuota = ?");
			stmt.setInt(1, updCuota.getMonto());
			stmt.setInt(2, updCuota.getIdCuota());

			stmt.executeUpdate();
			
			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
			
			return 0;
			
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	

	public cuota seleccionarPorID(cuota CuotaBuscado) {
		cuota r = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().conectar()
					.prepareStatement("SELECT * FROM cuotas WHERE idCuota=?");
			stmt.setInt(1, CuotaBuscado.getIdCuota());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				r = new cuota();
				r.setIdCuota(rs.getInt("idCuota"));
				r.setAnio(rs.getInt("año"));
				r.setMes(rs.getInt("mes"));
				r.setMonto(rs.getInt("monto"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				DbConnector.getInstancia().desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return r;
	}
	
	
	
	
}
