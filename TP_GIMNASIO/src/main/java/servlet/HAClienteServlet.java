package servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import logic.CtrlHACliente;

import java.io.IOException;
import java.time.LocalDateTime;

import java.util.LinkedList;

import entities.ha_cliente;
import entities.horarioActividad;
import entities.usuario;

/**
 * Servlet implementation class HACClienteServlet
 */
public class HAClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HAClienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (request.getHttpServletMapping().getMatchValue().endsWith("/nuevo")) {
			response.sendRedirect("./nuevo.jsp");
		}

		if (request.getHttpServletMapping().getMatchValue().endsWith("/eliminar")) {
			int idHAC = Integer.parseInt(request.getParameter("id"));
			ha_cliente hac = new ha_cliente();
			hac.setIdHAC(idHAC);
			CtrlHACliente ctrlHAC = new CtrlHACliente();
			int sinError = ctrlHAC.eliminarHAC(hac);
			if (sinError == 1) {
				request.getSession().setAttribute("action_result_status", "1");
				request.getSession().setAttribute("action_result_message", "Se ha eliminado el HAC Correctamente!");
			} else {
				request.getSession().setAttribute("action_result_status", "0");
				request.getSession().setAttribute("action_result_message", "Hubo un error al eliminar el HAC.");
			}
			response.sendRedirect("listar"); // SE REDIRECCIONA A LISTAR DEL SERVLET PARA QUE VUELVA A REALIZAR LA
												// CONSULTA ACTUALIZADA Y ACTUALICE EL OBJETO LINKEDLIST DE USUARIOS
												// LISTADOS
		}

		if (request.getHttpServletMapping().getMatchValue().endsWith("/darDeBaja")) {
			int idHAC = Integer.parseInt(request.getParameter("id"));
			ha_cliente hac = new ha_cliente();
			hac.setIdHAC(idHAC);
			CtrlHACliente ctrlHAC = new CtrlHACliente();
			int sinError = ctrlHAC.darDeBajaHAC(hac);
			if (sinError == 1) {
				request.getSession().setAttribute("action_result_status", "1");
				request.getSession().setAttribute("action_result_message",
						"Se ha dado la baja del Cliente Correctamente!");
			} else {
				request.getSession().setAttribute("action_result_status", "0");
				request.getSession().setAttribute("action_result_message", "Hubo un error al dar de baja al Cliente.");
			}
			response.sendRedirect("listar"); // SE REDIRECCIONA A LISTAR DEL SERVLET PARA QUE VUELVA A REALIZAR LA
												// CONSULTA ACTUALIZADA Y ACTUALICE EL OBJETO LINKEDLIST DE USUARIOS
												// LISTADOS
		}

		if (request.getHttpServletMapping().getMatchValue().endsWith("/listar")) {
			CtrlHACliente ctrlHAC = new CtrlHACliente();
			LinkedList<ha_cliente> hac = ctrlHAC.listarHAC();
			request.getSession().setAttribute("listado_de_hac", hac);
			response.sendRedirect("./listar.jsp");
		}

		if (request.getHttpServletMapping().getMatchValue().endsWith("/listarPorCliente")) {
			int idCliente = Integer.parseInt(request.getParameter("id"));
			CtrlHACliente ctrlHAC = new CtrlHACliente();
			LinkedList<ha_cliente> hac = ctrlHAC.listarHACporCliente(idCliente);
			request.getSession().setAttribute("listado_de_hac", hac);
			response.sendRedirect("./listar.jsp");
		}

		if (request.getHttpServletMapping().getMatchValue().endsWith("/listarPorActividad")) {
			int idActividad = Integer.parseInt(request.getParameter("id"));
			CtrlHACliente ctrlHAC = new CtrlHACliente();
			LinkedList<ha_cliente> hac = ctrlHAC.listarHACporActividad(idActividad);
			request.getSession().setAttribute("listado_de_hac", hac);
			response.sendRedirect("./listar.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String accion = request.getParameter("accion");
		ha_cliente hac = new ha_cliente();
		CtrlHACliente ctrlHAC = new CtrlHACliente();

		if (accion.equals("nuevo")) {
			hac.setHA(new horarioActividad());
			hac.setUsuario(new usuario());
			hac.getUsuario().setIdUsuario((Integer.parseInt(request.getParameter("idUsuario"))));
			hac.getHA().setIdHA((Integer.parseInt(request.getParameter("idHA"))));

			hac.setFechaRegistro(LocalDateTime.now().minusHours(3)); // LocalDateTime.parse(LocalDateTime.now().toString(),
																		// dtFormat).minusHours(3));

			int sinError = ctrlHAC.nuevoHAC(hac);
			if (sinError == 1) {
				request.getSession().setAttribute("action_result_status", "1");
				request.getSession().setAttribute("action_result_message", "Se ha creado el HAC Correctamente!");
			} else {
				request.getSession().setAttribute("action_result_status", "0");
				request.getSession().setAttribute("action_result_message", "Hubo un error al crear la HAC.");
			}

			if (request.getSession().getAttribute("tpjava_usuario_tipoUsuario").equals("Admin") || request.getSession().getAttribute("tpjava_usuario_tipoUsuario").equals("Administrativo")) {
				response.sendRedirect("listar");
			} else if (request.getSession().getAttribute("tpjava_usuario_tipoUsuario").equals("Cliente")) {
				response.sendRedirect("listar");
			}
		}

	}

}
