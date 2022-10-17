package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;

public class DataHA {

	
	
	
	public LinkedList<horarioActividad> listarHA() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<horarioActividad> HorariosHAes = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().conectar().createStatement();
			rs = stmt.executeQuery("select * from horariosactividades");
			if (rs != null) {
				while (rs.next()) {
					horarioActividad r = new horarioActividad();

					r.setIdHA(rs.getInt("idHA"));
					r.setIdActividad(rs.getInt("idActividad"));
					r.setIdUsuario(rs.getInt("idUsuario"));
					r.setDia(rs.getString("dia"));
					r.setHoraComienzo(rs.getTime("horaComienzo"));
					r.setHoraFin(rs.getTime("horaFin"));
					r.setCuposDisponibles(rs.getInt("cuposDisponibles"));

					HorariosHAes.add(r);
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

		return HorariosHAes;
	}
	
	

	public horarioActividad seleccionarPorID(horarioActividad HABuscado) {
		horarioActividad ha = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().conectar()
					.prepareStatement("SELECT * FROM horarioActividades WHERE idHA=? AND eliminado=0");
			stmt.setInt(1, HABuscado.getIdHA());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				ha = new horarioActividad();
				ha.setIdHA(rs.getInt("idHA"));
				ha.setDia(rs.getString("nombre"));
				ha.setHoraComienzo(rs.getTime("descripcion"));
				ha.setHoraFin(rs.getTime("descripcion"));
				ha.setCuposDisponibles(rs.getInt("descripcion"));
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

		return ha;
	}

	public int nuevoHA(horarioActividad newHA) {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = DbConnector.getInstancia().conectar().prepareStatement("insert into horariosactividades (idActividad, idUsuario, dia, horaComienzo, horaFin, cuposDisponibles) "+ "values(?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, newHA.getIdActividad());
			stmt.setInt(2, newHA.getIdUsuario());
			stmt.setString(3, newHA.getDia());
			stmt.setTime(4, newHA.getHoraComienzo());
			stmt.setTime(5, newHA.getHoraFin());
			stmt.setInt(6, newHA.getCuposDisponibles());

			stmt.executeUpdate();
			
			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
			
			return 0;
			
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public int eliminarHA(horarioActividad delHA) {
		PreparedStatement stmt = null;

		try {
			stmt = DbConnector.getInstancia().conectar().prepareStatement("update horariosactividades "+ "set eliminado = 1 " + "where idHA = ?");
			stmt.setInt(1, delHA.getIdHA());

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

	public int editarHA(horarioActividad updHA) {
		PreparedStatement stmt = null;

		try {
			stmt = DbConnector.getInstancia().conectar().prepareStatement("update horariosactividades "+ "set idActividad = ?, idUsuario = ?, dia = ?, horaComienzo = ?, horaFin = ?, cuposDisponibles = ? " + "where idHA = ?");
			stmt.setInt(1, updHA.getIdActividad());
			stmt.setInt(2, updHA.getIdUsuario());
			stmt.setString(3, updHA.getDia());
			stmt.setTime(4, updHA.getHoraComienzo());
			stmt.setTime(5, updHA.getHoraFin());
			stmt.setInt(6, updHA.getCuposDisponibles());
			stmt.setInt(7, updHA.getIdHA());

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
	
}

