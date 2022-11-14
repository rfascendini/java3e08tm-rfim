package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;

public class DataActividad {

	
	
	
	public LinkedList<actividad> listarActividades() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<actividad> Actividades = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().conectar().createStatement();
			rs = stmt.executeQuery("select * from actividades where eliminado = 0");
			if (rs != null) {
				while (rs.next()) {
					actividad r = new actividad();

					r.setIdActividad(rs.getInt("idActividad"));
					r.setNombre(rs.getString("nombre"));
					r.setDescripcion(rs.getString("descripcion"));

					Actividades.add(r);
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

		return Actividades;
	}
	
	
	
	
	

	public actividad seleccionarPorID(actividad ActividadBuscado) {
		actividad a = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().conectar()
					.prepareStatement("SELECT * FROM actividades WHERE idActividad=? AND eliminado=0");
			stmt.setInt(1, ActividadBuscado.getIdActividad());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				a = new actividad();
				a.setIdActividad(rs.getInt("idActividad"));
				a.setNombre(rs.getString("nombre"));
				a.setDescripcion(rs.getString("descripcion"));
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

		return a;
	}

	public int nuevoActividad(actividad newActividad) {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = DbConnector.getInstancia().conectar().prepareStatement("insert into actividades (nombre, descripcion) "+ "values(?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, newActividad.getNombre());
			stmt.setString(2, newActividad.getDescripcion());

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

	public int eliminarActividad(actividad delActividad) {
		PreparedStatement stmt = null;

		try {
			stmt = DbConnector.getInstancia().conectar().prepareStatement("update actividades "+ "set eliminado = 1 " + "where idActividad = ?");
			stmt.setInt(1, delActividad.getIdActividad());

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

	public int editarActividad(actividad updActividad) {
		PreparedStatement stmt = null;

		try {
			stmt = DbConnector.getInstancia().conectar().prepareStatement("update actividades "+ "set nombre = ?, descripcion = ? " + "where idActividad = ?");
			stmt.setString(1, updActividad.getNombre());
			stmt.setString(2, updActividad.getDescripcion());
			stmt.setInt(3, updActividad.getIdActividad());

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