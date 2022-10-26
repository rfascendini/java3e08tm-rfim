package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import entities.*;

public class DataHACliente {

	public LinkedList<ha_cliente> listarHAC() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<ha_cliente> ha_clientes = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().conectar().createStatement();
			rs = stmt.executeQuery(
					"SELECT hac.*, "
					+ "CONCAT(u.apellido,', ',u.nombre) as 'apeNomUsuario', "
					+ "a.nombre as 'nombreActividad', "
					+ "ha.horaComienzo as 'horaComienzo', "
					+ "ha.horaFin as 'horaFin', "
					+ "ha.dia as 'dia' "
					+ "FROM ha_clientes hac "
					+ "INNER JOIN horariosactividades ha ON ha.idHA = hac.idHA "
					+ "INNER JOIN actividades a ON a.idActividad = ha.idActividad "
					+ "INNER JOIN usuarios u ON u.idUsuario = hac.idUsuario "
					+ "WHERE fechaBaja is null");
			if (rs != null) {
				while (rs.next()) {
					ha_cliente hac = new ha_cliente();
					
					hac.setHA(new horarioActividad());
					hac.setUsuario(new usuario());
					
					hac.setIdHAC(rs.getInt("idHAC"));
					
					hac.getHA().setIdHA(rs.getInt("idHA"));
					hac.getHA().setHoraComienzo(rs.getObject("horaComienzo",LocalTime.class));
					hac.getHA().setHoraFin(rs.getObject("horaFin",LocalTime.class));
					hac.getHA().setDia(rs.getString("dia"));
					
					hac.getUsuario().setNombre(rs.getString("apeNomUsuario"));
					
					hac.getHA().getActividad().setNombre(rs.getString("nombreActividad"));
					
					hac.setFechaRegistro(rs.getObject("fechaRegistro",LocalDateTime.class));
					hac.setFechaBaja(rs.getObject("fechaBaja",LocalDateTime.class));
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

		return ha_clientes;
	}

	public ha_cliente seleccionarPorID(ha_cliente HABuscado) {
		ha_cliente ha = null;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().conectar()
					.prepareStatement("SELECT * FROM horariosactividades WHERE idHA = ? and eliminado=0");
			stmt.setInt(1, HABuscado.getIdHAC());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				ha = new ha_cliente();
				ha.setHA(new horarioActividad());
				ha.setUsuario(new usuario());
				ha.setIdHAC(rs.getInt("idHAC"));
				ha.getHA().setIdHA(rs.getInt("idHA"));
				ha.getUsuario().setIdUsuario(rs.getInt("idUsuario"));
				ha.setFechaRegistro(rs.getObject("fechaRegistro",LocalDateTime.class));
				ha.setFechaBaja(rs.getObject("fechaBaja",LocalDateTime.class));

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

	public int nuevoHAC(ha_cliente newHAC) {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = DbConnector.getInstancia().conectar().prepareStatement(
					"insert into horariosactividades (idActividad, idUsuario, fechaRegistro) "
							+ "values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, newHAC.getHA().getIdHA());
			stmt.setInt(2, newHAC.getUsuario().getIdUsuario());
			stmt.setObject(3, newHAC.getFechaRegistro());

			
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

	public int eliminarHAC(ha_cliente delHA) {
		PreparedStatement stmt = null;

		try {
			stmt = DbConnector.getInstancia().conectar()
					.prepareStatement("UPDATE ha_clientes " + "SET eliminado = 1 " + "WHERE idHAC = ?");
			stmt.setInt(1, delHA.getIdHAC());

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

	public int editarHAC(ha_cliente updHAC) {
		PreparedStatement stmt = null;

		try {
			stmt = DbConnector.getInstancia().conectar().prepareStatement("UPDATE horariosactividades "
					+ "SET idHA = ?, idUsuario = ?, fechaRegistro = ?, fechaBaja = ? "
					+ "WHERE idHAC = ?");
			stmt.setInt(1, updHAC.getHA().getIdHA());
			stmt.setInt(2, updHAC.getUsuario().getIdUsuario());
			stmt.setObject(3, updHAC.getFechaRegistro());
			stmt.setObject(4, updHAC.getFechaBaja());		
			stmt.setInt(5, updHAC.getIdHAC());

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
