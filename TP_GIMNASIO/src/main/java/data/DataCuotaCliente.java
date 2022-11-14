package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.time.LocalDateTime;

import entities.cliente_cuota;
import entities.cuota;

import entities.usuario;

public class DataCuotaCliente {
	
	public LinkedList<cliente_cuota> listarCuotasPorCliente(usuario cliente) {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<cliente_cuota> listaClientesCuota = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().conectar().createStatement();
			rs = stmt.executeQuery(  "select c.idCuota as 'idCuota', c.monto as 'monto', c.nombreMes as 'nombreMes', c.año as 'anioCuota',cc.fechaPago as 'fechaPago',cc.montoAbonado as 'montoAbonado',cc.idUsuario as 'idUsuario' "
					+ "from cuotas c "
					+ "left join clientes_cuotas cc on c.idCuota = cc.idCuota and cc.idUsuario = "+cliente.getIdUsuario()+" "
					+ "left join usuarios u on u.idUsuario = cc.idUsuario "
					+ "where c.monto is not null");
			if (rs != null) {
				while (rs.next()) {
					cliente_cuota cc = new cliente_cuota();
					cc.setCuota(new cuota());
					cc.setUsuario(new usuario());

					cc.getUsuario().setIdUsuario(cliente.getIdUsuario());
					
					cc.getCuota().setIdCuota(rs.getInt("idCuota"));
					cc.getCuota().setNombreMes(rs.getString("nombreMes"));
					cc.getCuota().setAnio(rs.getInt("anioCuota"));
					cc.getCuota().setMonto(rs.getInt("monto"));
					
					cc.setFechaPago(rs.getObject("fechaPago",LocalDateTime.class));
					cc.setMontoAbonado(rs.getInt("montoAbonado"));

					listaClientesCuota.add(cc);
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

		return listaClientesCuota;
	}
	
	
	//
	
	public LinkedList<cliente_cuota> listarClientesPorCuota(cuota cuota) {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<cliente_cuota> listaClientesCuota = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().conectar().createStatement();
			rs = stmt.executeQuery(  "select u.idUsuario,"
													+ "u.apellido as 'apeUsuario', "
													+ "u.nombre as 'nomUsuario', "
													+ "u.idUsuario as 'idUsuario', "
													+ "c.idCuota as 'idCuota', "
													+ "c.monto as 'monto', "
													+ "cc.fechaPago as 'fechaPago', "
													+ "cc.montoAbonado as 'montoAbonado' "
											+ "from usuarios u "
											+ "left join clientes_cuotas cc on u.idUsuario = cc.idUsuario and cc.idCuota = "+cuota.getIdCuota()+" "
											+ "left join cuotas c on c.idCuota = cc.idCuota "
											+ "where u.tipoUsuario = 'Cliente' and u.eliminado = 0");
			if (rs != null) {
				while (rs.next()) {
					cliente_cuota cc = new cliente_cuota();
					cc.setCuota(new cuota());
					cc.setUsuario(new usuario());

					cc.getCuota().setIdCuota(rs.getInt("idCuota"));
					cc.getCuota().setMonto(rs.getInt("monto"));
					
					cc.getUsuario().setIdUsuario(rs.getInt("idUsuario"));
					cc.getUsuario().setApellido(rs.getString("apeUsuario"));
					cc.getUsuario().setNombre(rs.getString("nomUsuario"));
					cc.setFechaPago(rs.getObject("fechaPago",LocalDateTime.class));
					cc.setMontoAbonado(rs.getInt("montoAbonado"));

					listaClientesCuota.add(cc);
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

		return listaClientesCuota;
	}
	
	public int nuevoCC(cuota c, usuario u) {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = DbConnector.getInstancia().conectar().prepareStatement(
					"INSERT INTO clientes_cuotas (idCuota,idUsuario, fechaPago, montoAbonado) VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, c.getIdCuota());
			stmt.setInt(2, u.getIdUsuario());
			stmt.setObject(3, LocalDateTime.now().minusHours(3));
			stmt.setInt(4, c.getMonto());

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
	
	
	
}
