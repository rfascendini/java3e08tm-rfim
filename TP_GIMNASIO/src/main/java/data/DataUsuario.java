package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;

public class DataUsuario {

	public LinkedList<usuario> listarUsuarios(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<usuario> usuarios= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().conectar().createStatement();
			rs= stmt.executeQuery("select * from usuario");
			if(rs!=null) {
				while(rs.next()) {
					usuario r=new usuario();
					
					r.setIdUsuario(rs.getInt("idUsuario"));
					r.setNombre(rs.getString("nombre"));
					r.setApellido(rs.getString("apellido"));
					// r.setFechaNacimiento(rs.getDate("fechaNacimiento"));
					// r.setSexo(rs.getString("sexo"));
					r.setDomicilio(rs.getString("domicilio"));
					r.setPassword(rs.getString("password"));
					r.setEmail(rs.getString("email"));
					r.setTelefono(rs.getString("telefono"));
					r.setHabilitado(rs.getInt("eliminado"));
					r.setEliminado(rs.getInt("eliminado"));
				
					usuarios.add(r);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return usuarios;
	}
	

	
	public usuario seleccionarPorUsuario(usuario usuarioBuscado) {
		usuario u=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().conectar().prepareStatement(
					"SELECT * FROM usuarios WHERE dni=? AND password=? AND eliminado=0"
					);
			stmt.setInt(1, usuarioBuscado.getDni());
			stmt.setString(2, usuarioBuscado.getPassword());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				u=new usuario();
				u.setIdUsuario(rs.getInt("idUsuario"));
				u.setPassword(rs.getString("password"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setDni(rs.getInt("dni"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setTelefono(rs.getString("telefono"));
				u.setHabilitado(rs.getInt("eliminado"));
				u.setEliminado(rs.getInt("eliminado"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return u;
	}
	
	
	public usuario seleccionarPorID(usuario usuarioBuscado) {
		usuario u=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().conectar().prepareStatement(
					"SELECT * FROM usuarios WHERE idUsuario=? AND eliminado=0"
					);
			stmt.setInt(1, usuarioBuscado.getIdUsuario());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				u=new usuario();
				u.setIdUsuario(rs.getInt("idUsuario"));
				u.setPassword(rs.getString("password"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setDni(rs.getInt("dni"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setTelefono(rs.getString("telefono"));
				u.setHabilitado(rs.getInt("habilitado"));
				u.setEliminado(rs.getInt("eliminado"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return u;
	}
	
	
}
