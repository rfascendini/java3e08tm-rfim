package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;

public class DataUsuario {

	public LinkedList<usuario> listarUsuarios(String tipoUsuario) {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<usuario> usuarios = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().conectar().createStatement();
			rs = stmt.executeQuery("select * from usuarios where tipoUsuario LIKE '"+tipoUsuario+"' AND eliminado = 0");
			if (rs != null) {
				while (rs.next()) {
					usuario r = new usuario();

					r.setIdUsuario(rs.getInt("idUsuario"));
					r.setNombre(rs.getString("nombre"));
					r.setApellido(rs.getString("apellido"));
					r.setTipoUsuario(rs.getString("tipoUsuario"));
					// r.setFechaNacimiento(rs.getDate("fechaNacimiento"));
					r.setSexo(rs.getString("sexo"));
					r.setDomicilio(rs.getString("domicilio"));
					r.setPassword(rs.getString("password"));
					r.setEmail(rs.getString("email"));
					r.setTelefono(rs.getString("telefono"));
					r.setHabilitado(rs.getInt("habilitado"));
					r.setEliminado(rs.getInt("eliminado"));

					usuarios.add(r);
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

		return usuarios;
	}

	public usuario seleccionarPorUsuario(usuario usuarioBuscado) {
		usuario u = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().conectar()
					.prepareStatement("SELECT * FROM usuarios WHERE dni=? AND password=? AND eliminado=0");
			stmt.setInt(1, usuarioBuscado.getDni());
			stmt.setString(2, usuarioBuscado.getPassword());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				u = new usuario();
				u.setIdUsuario(rs.getInt("idUsuario"));
				u.setPassword(rs.getString("password"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setTipoUsuario(rs.getString("tipoUsuario"));
				u.setDni(rs.getInt("dni"));
				u.setSexo(rs.getString("sexo"));
				u.setDomicilio(rs.getString("domicilio"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setTelefono(rs.getString("telefono"));
				u.setHabilitado(rs.getInt("habilitado"));
				u.setEliminado(rs.getInt("eliminado"));
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

		return u;
	}

	public usuario seleccionarPorID(usuario usuarioBuscado) {
		usuario u = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().conectar()
					.prepareStatement("SELECT * FROM usuarios WHERE idUsuario=? AND eliminado=0");
			stmt.setInt(1, usuarioBuscado.getIdUsuario());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				u = new usuario();
				u.setIdUsuario(rs.getInt("idUsuario"));
				u.setPassword(rs.getString("password"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setDni(rs.getInt("dni"));
				u.setTipoUsuario(rs.getString("tipoUsuario"));
				u.setSexo(rs.getString("sexo"));
				u.setDomicilio(rs.getString("domicilio"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setTelefono(rs.getString("telefono"));
				u.setHabilitado(rs.getInt("habilitado"));
				u.setEliminado(rs.getInt("eliminado"));
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

		return u;
	}

	public int nuevoUsuario(usuario newUsuario) {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = DbConnector.getInstancia().conectar().prepareStatement("insert into usuarios (nombre, apellido, dni, sexo, domicilio, password, email, tipoUsuario telefono, habilitado, eliminado) "+ "values(?,?,?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, newUsuario.getNombre());
			stmt.setString(2, newUsuario.getApellido());
			stmt.setInt(3, newUsuario.getDni());
			stmt.setString(4, newUsuario.getSexo());
			stmt.setString(5, newUsuario.getDomicilio());
			stmt.setString(6, newUsuario.getPassword());
			stmt.setString(7, newUsuario.getEmail());
			stmt.setString(8, newUsuario.getTipoUsuario());
			stmt.setString(9, newUsuario.getTelefono());
			stmt.setInt(10, newUsuario.getHabilitado());
			stmt.setInt(11, newUsuario.getEliminado());

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

	public int eliminarUsuario(usuario delUsuario) {
		PreparedStatement stmt = null;

		try {
			stmt = DbConnector.getInstancia().conectar().prepareStatement("update usuarios "+ "set eliminado = 1 " + "where idUsuario = ?");
			stmt.setInt(1, delUsuario.getIdUsuario());

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

	public int editarUsuario(usuario updUsuario) {
		PreparedStatement stmt = null;

		try {
			stmt = DbConnector.getInstancia().conectar().prepareStatement("update usuarios "+ "set nombre = ?, apellido = ?, dni = ?, sexo = ?, domicilio = ?, password = ?, email = ?, tipoUsuario = ?, telefono = ?, habilitado = ? " + "where idUsuario = ?");
			stmt.setString(1, updUsuario.getNombre());
			stmt.setString(2, updUsuario.getApellido());
			stmt.setInt(3, updUsuario.getDni());
			stmt.setString(4, updUsuario.getSexo());
			stmt.setString(5, updUsuario.getDomicilio());
			stmt.setString(6, updUsuario.getPassword());
			stmt.setString(7, updUsuario.getEmail());
			stmt.setString(8, updUsuario.getTipoUsuario());
			stmt.setString(9, updUsuario.getTelefono());
			stmt.setInt(10, updUsuario.getHabilitado());
			stmt.setInt(11, updUsuario.getIdUsuario());
			
			

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
