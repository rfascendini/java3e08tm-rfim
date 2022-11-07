package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.LinkedList;
import entities.*;

public class DataHA {

	public LinkedList<horarioActividad> listarHA() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<horarioActividad> HorariosHAes = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().conectar().createStatement();
			rs = stmt.executeQuery("SELECT ha.*," + "CONCAT(u.apellido,', ',u.nombre) as 'apeNomUsuario', "
					+ "a.nombre as 'nombreActividad' " + "FROM horariosactividades ha "
					+ "INNER JOIN actividades a ON a.idActividad = ha.idActividad "
					+ "INNER JOIN usuarios u ON u.idUsuario = ha.idUsuario "
					+ "WHERE ha.eliminado = 0");
			if (rs != null) {
				while (rs.next()) {
					horarioActividad ha = new horarioActividad();
					ha.setActividad(new actividad());
					ha.setUsuario(new usuario());
					ha.setIdHA(rs.getInt("idHA"));
					ha.getActividad().setIdActividad(rs.getInt("idActividad"));
					ha.getActividad().setNombre(rs.getString("nombreActividad")); 								
					ha.getUsuario().setIdUsuario(rs.getInt("idUsuario"));
					ha.getUsuario().setNombre(rs.getString("apeNomUsuario"));
					ha.setDia(rs.getString("dia"));
					ha.setHoraComienzo(rs.getObject("horaComienzo",LocalTime.class));
					ha.setHoraFin(rs.getObject("horaFin",LocalTime.class));
					ha.setCuposDisponibles(rs.getInt("cuposDisponibles"));
					HorariosHAes.add(ha);
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
	
	
	public LinkedList<horarioActividad> listarHAporProfesor(int idProfesor) {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<horarioActividad> HorariosHAes = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().conectar().createStatement();
			rs = stmt.executeQuery("SELECT ha.*," + "CONCAT(u.apellido,', ',u.nombre) as 'apeNomUsuario', "
					+ "a.nombre as 'nombreActividad' " + "FROM horariosactividades ha "
					+ "INNER JOIN actividades a ON a.idActividad = ha.idActividad "
					+ "INNER JOIN usuarios u ON u.idUsuario = ha.idUsuario "
					+ "WHERE ha.eliminado = 0 AND ha.idUsuario = "+idProfesor);
			if (rs != null) {
				while (rs.next()) {
					horarioActividad ha = new horarioActividad();
					ha.setActividad(new actividad());
					ha.setUsuario(new usuario());
					ha.setIdHA(rs.getInt("idHA"));
					ha.getActividad().setIdActividad(rs.getInt("idActividad"));
					ha.getActividad().setNombre(rs.getString("nombreActividad")); 								
					ha.getUsuario().setIdUsuario(rs.getInt("idUsuario"));
					ha.getUsuario().setNombre(rs.getString("apeNomUsuario"));
					ha.setDia(rs.getString("dia"));
					ha.setHoraComienzo(rs.getObject("horaComienzo",LocalTime.class));
					ha.setHoraFin(rs.getObject("horaFin",LocalTime.class));
					ha.setCuposDisponibles(rs.getInt("cuposDisponibles"));
					HorariosHAes.add(ha);
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
	
	
	public LinkedList<horarioActividad> listarHAporActividad(int idActividad) {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<horarioActividad> HorariosHAes = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().conectar().createStatement();
			rs = stmt.executeQuery("SELECT ha.*," + "CONCAT(u.apellido,', ',u.nombre) as 'apeNomUsuario', "
					+ "a.nombre as 'nombreActividad' " + "FROM horariosactividades ha "
					+ "INNER JOIN actividades a ON a.idActividad = ha.idActividad "
					+ "INNER JOIN usuarios u ON u.idUsuario = ha.idUsuario "
					+ "WHERE ha.eliminado = 0 AND ha.idActividad = "+idActividad);
			if (rs != null) {
				while (rs.next()) {
					horarioActividad ha = new horarioActividad();
					ha.setActividad(new actividad());
					ha.setUsuario(new usuario());
					ha.setIdHA(rs.getInt("idHA"));
					ha.getActividad().setIdActividad(rs.getInt("idActividad"));
					ha.getActividad().setNombre(rs.getString("nombreActividad")); 								
					ha.getUsuario().setIdUsuario(rs.getInt("idUsuario"));
					ha.getUsuario().setNombre(rs.getString("apeNomUsuario"));
					ha.setDia(rs.getString("dia"));
					ha.setHoraComienzo(rs.getObject("horaComienzo",LocalTime.class));
					ha.setHoraFin(rs.getObject("horaFin",LocalTime.class));
					ha.setCuposDisponibles(rs.getInt("cuposDisponibles"));
					HorariosHAes.add(ha);
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
					.prepareStatement("SELECT * FROM horariosactividades WHERE idHA = ? and eliminado=0");
			stmt.setInt(1, HABuscado.getIdHA());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				ha = new horarioActividad();
				ha.setActividad(new actividad());
				ha.setUsuario(new usuario());
				ha.setIdHA(rs.getInt("idHA"));
				ha.getActividad().setIdActividad(rs.getInt("idActividad"));
				ha.getUsuario().setIdUsuario(rs.getInt("idUsuario"));
				ha.setDia(rs.getString("dia"));
				ha.setHoraComienzo(rs.getObject("horaComienzo",LocalTime.class));
				ha.setHoraFin(rs.getObject("horaFin",LocalTime.class));

				
				ha.setCuposDisponibles(rs.getInt("cuposDisponibles"));
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
			stmt = DbConnector.getInstancia().conectar().prepareStatement(
					"insert into horariosactividades (idActividad, idUsuario, dia, horaComienzo, horaFin, cuposDisponibles) "
							+ "values(?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, newHA.getActividad().getIdActividad());
			stmt.setInt(2, newHA.getUsuario().getIdUsuario());
			stmt.setString(3, newHA.getDia());
			
			stmt.setObject(4, newHA.getHoraComienzo());
			stmt.setObject(5, newHA.getHoraFin());

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
			stmt = DbConnector.getInstancia().conectar()
					.prepareStatement("UPDATE horariosactividades " + "SET eliminado = 1 " + "WHERE idHA = ?");
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
			stmt = DbConnector.getInstancia().conectar().prepareStatement("UPDATE horariosactividades "
					+ "SET idActividad = ?, idUsuario = ?, dia = ?, horaComienzo = ?, horaFin = ?, cuposDisponibles = ? "
					+ "WHERE idHA = ?");
			stmt.setInt(1, updHA.getActividad().getIdActividad());
			stmt.setInt(2, updHA.getUsuario().getIdUsuario());
			stmt.setString(3, updHA.getDia());
			stmt.setObject(4, updHA.getHoraComienzo());
			stmt.setObject(5, updHA.getHoraFin());
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
