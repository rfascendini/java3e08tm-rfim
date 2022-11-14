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
		LinkedList<ha_cliente> hac_clientes = new LinkedList<>();

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
					+ "WHERE hac.fechaBaja IS NULL AND hac.eliminado = 0");
			if (rs != null) {
				while (rs.next()) {
					ha_cliente hac = new ha_cliente();
					horarioActividad ha = new horarioActividad();
					
					ha.setActividad(new actividad());
					hac.setHA(ha);
					
					hac.setUsuario(new usuario());
					hac.setIdHAC(rs.getInt("idHAC"));
					hac.getHA().setIdHA(rs.getInt("idHA"));
					hac.getHA().setHoraComienzo(rs.getObject("horaComienzo",LocalTime.class));
					hac.getHA().setHoraFin(rs.getObject("horaFin",LocalTime.class));
					
					hac.getHA().setDia(rs.getString("dia"));
					hac.getUsuario().setNombre(rs.getString("apeNomUsuario"));
					hac.getHA().getActividad().setNombre(rs.getString("nombreActividad"));
					hac.setFechaRegistro(rs.getObject("fechaRegistro",LocalDateTime.class));

					hac_clientes.add(hac);

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

		return hac_clientes;
	}
	
	
	

	
	public LinkedList<ha_cliente> listarHACporCliente(int idCliente) {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<ha_cliente> hac_clientes = new LinkedList<>();
		
		System.out.println(idCliente);

		try {
			stmt = DbConnector.getInstancia().conectar().createStatement();
			rs = stmt.executeQuery(
					"SELECT hac.*, "
					+ "	CONCAT(u.apellido,', ',u.nombre) as 'apeNomUsuario', "
					+ "	a.nombre as 'nombreActividad', "
					+ "	ha.horaComienzo as 'horaComienzo', "
					+ "	ha.horaFin as 'horaFin', "
					+ "	ha.dia as 'dia' "
					+ "FROM ha_clientes hac "
					+ "INNER JOIN horariosactividades ha ON ha.idHA = hac.idHA "
					+ "INNER JOIN actividades a ON a.idActividad = ha.idActividad "
					+ "INNER JOIN usuarios u ON u.idUsuario = hac.idUsuario "
					+ "WHERE hac.fechaBaja IS NULL AND hac.eliminado = 0 AND hac.idUsuario = "+idCliente);
			if (rs != null) {
				while (rs.next()) {
					ha_cliente hac = new ha_cliente();
					horarioActividad ha = new horarioActividad();
					
					ha.setActividad(new actividad());
					hac.setHA(ha);
					
					hac.setUsuario(new usuario());
					hac.setIdHAC(rs.getInt("idHAC"));
					hac.getHA().setIdHA(rs.getInt("idHA"));
					hac.getHA().setHoraComienzo(rs.getObject("horaComienzo",LocalTime.class));
					hac.getHA().setHoraFin(rs.getObject("horaFin",LocalTime.class));
					
					hac.getHA().setDia(rs.getString("dia"));
					hac.getUsuario().setNombre(rs.getString("apeNomUsuario"));
					hac.getHA().getActividad().setNombre(rs.getString("nombreActividad"));
					hac.setFechaRegistro(rs.getObject("fechaRegistro",LocalDateTime.class));

					hac_clientes.add(hac);

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

		return hac_clientes;
	}
	
	
	
	
	public LinkedList<ha_cliente> listarHACporActividad(int idActividad) {

		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<ha_cliente> hac_clientes = new LinkedList<>();

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
					+ "WHERE ha.idActividad = "+idActividad);
			if (rs != null) {
				while (rs.next()) {
					ha_cliente hac = new ha_cliente();
					horarioActividad ha = new horarioActividad();
					
					ha.setActividad(new actividad());
					hac.setHA(ha);
					
					hac.setUsuario(new usuario());
					hac.setIdHAC(rs.getInt("idHAC"));
					hac.getHA().setIdHA(rs.getInt("idHA"));
					hac.getHA().setHoraComienzo(rs.getObject("horaComienzo",LocalTime.class));
					hac.getHA().setHoraFin(rs.getObject("horaFin",LocalTime.class));
					
					hac.getHA().setDia(rs.getString("dia"));
					hac.getUsuario().setNombre(rs.getString("apeNomUsuario"));
					hac.getHA().getActividad().setNombre(rs.getString("nombreActividad"));
					hac.setFechaRegistro(rs.getObject("fechaRegistro",LocalDateTime.class));

					hac_clientes.add(hac);

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

		return hac_clientes;
	}
	
	
	
	
	
	

	public ha_cliente seleccionarPorID(ha_cliente HABuscado) {
		ha_cliente hac = null;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().conectar()
					.prepareStatement("SELECT * FROM horariosactividades WHERE idHA = ? and eliminado=0");
			stmt.setInt(1, HABuscado.getIdHAC());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				hac = new ha_cliente();
				hac.setHA(new horarioActividad());
				hac.setUsuario(new usuario());
				hac.setIdHAC(rs.getInt("idHAC"));
				hac.getHA().setIdHA(rs.getInt("idHA"));
				hac.getUsuario().setIdUsuario(rs.getInt("idUsuario"));
				hac.setFechaRegistro(rs.getObject("fechacRegistro",LocalDateTime.class));
				hac.setFechaBaja(rs.getObject("fechacBaja",LocalDateTime.class));

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

		return hac;
	}

	public int nuevoHAC(ha_cliente newHAC) {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = DbConnector.getInstancia().conectar().prepareStatement(
					"insert into ha_clientes (idHA, idUsuario, fechaRegistro) "
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
	
	public int darDeBajaHAC(ha_cliente ddbHA) {
		PreparedStatement stmt = null;

		try {
			stmt = DbConnector.getInstancia().conectar()
					.prepareStatement("UPDATE ha_clientes " + "SET fechaBaja = ? " + "WHERE idHAC = ?");
			stmt.setObject(1, LocalDateTime.now().minusHours(3));
			stmt.setInt(2, ddbHA.getIdHAC());

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
					+ "SET idHA = ?, idUsuario = ?, fechacRegistro = ?, fechacBaja = ? "
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
