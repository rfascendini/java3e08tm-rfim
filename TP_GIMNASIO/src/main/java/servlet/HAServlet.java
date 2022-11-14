package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import logic.CtrlHA;


import java.io.IOException;

import java.time.LocalTime;

import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import entities.actividad;
import entities.horarioActividad;
import entities.usuario;

/**
 * Servlet implementation class HAServlet
 */
public class HAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/editar")) {
			int idHA = Integer.parseInt(request.getParameter("id"));
			CtrlHA ctrlHA = new CtrlHA();
			horarioActividad ha = ctrlHA.getHA(idHA);
			if (ha != null) {
				request.getSession().setAttribute("ha_a_editar", ha);
				response.sendRedirect("./editar.jsp"); 
			} else {
				System.out.println("NO ESTA SELECCIONANDO UNA HA");
			}
		}

		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/nuevo")) {
			response.sendRedirect("./nuevo.jsp");
		}
		

		if (request.getHttpServletMapping().getMatchValue().endsWith("/eliminar")) {
			int idHA = Integer.parseInt(request.getParameter("id"));
			horarioActividad ha = new horarioActividad();
			ha.setIdHA(idHA);
			CtrlHA ctrlHA = new CtrlHA();
			int sinError = ctrlHA.eliminarHA(ha);
			if (sinError == 1) {
				request.getSession().setAttribute("action_result_status", "1");
				request.getSession().setAttribute("action_result_message", "Se ha eliminado el HA Correctamente!");
			} else {
				request.getSession().setAttribute("action_result_status", "0");
				request.getSession().setAttribute("action_result_message", "Hubo un error al eliminar el HA.");
			}
			response.sendRedirect("listar"); // SE REDIRECCIONA A LISTAR DEL SERVLET PARA QUE VUELVA A REALIZAR LA CONSULTA ACTUALIZADA Y ACTUALICE EL OBJETO LINKEDLIST DE USUARIOS LISTADOS
		}

		
		
		
		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/listar")) {
			CtrlHA ctrlHA = new CtrlHA();
			LinkedList<horarioActividad> ha = ctrlHA.listarHA();
			request.getSession().setAttribute("listado_de_ha", ha);
			response.sendRedirect("./listar.jsp");
		}
		
		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/listarPorProfesor")) {
			int idProfesor = Integer.parseInt(request.getParameter("id"));
			CtrlHA ctrlHA = new CtrlHA();
			LinkedList<horarioActividad> ha = ctrlHA.listarHAporProfesor(idProfesor);
			request.getSession().setAttribute("listado_de_ha", ha);
			response.sendRedirect("./listar.jsp");
		}
		
		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/listarPorActividad")) {
			int idActividad = Integer.parseInt(request.getParameter("id"));
			CtrlHA ctrlHA = new CtrlHA();
			LinkedList<horarioActividad> ha = ctrlHA.listarHAporActividad(idActividad);
			request.getSession().setAttribute("listado_de_ha", ha);
			response.sendRedirect("./listar.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		

		String accion = request.getParameter("accion");
		String timeFormat = "HH:mm";
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern(timeFormat);
		horarioActividad ha = new horarioActividad();
		CtrlHA ctrlHA = new CtrlHA();
		
		
		if (accion.equals("nuevo")) {
			ha.setActividad(new actividad());
			ha.setUsuario(new usuario());
			ha.getUsuario().setIdUsuario((Integer.parseInt(request.getParameter("idUsuario"))));
			ha.getActividad().setIdActividad((Integer.parseInt(request.getParameter("idActividad"))));
			ha.setDia(request.getParameter("dia"));
			ha.setHoraComienzo(LocalTime.parse(request.getParameter("horaComienzo"), dtFormat).minusHours(3));
			ha.setHoraFin(LocalTime.parse(request.getParameter("horaFin"), dtFormat).minusHours(3));
			ha.setCuposDisponibles(Integer.parseInt(request.getParameter("cuposDisponibles")));
			int sinError = ctrlHA.nuevoHA(ha);
			if (sinError == 1) {
				request.getSession().setAttribute("action_result_status", "1");
				request.getSession().setAttribute("action_result_message", "Se ha creado el HA Correctamente!");
			} else {
				request.getSession().setAttribute("action_result_status", "0");
				request.getSession().setAttribute("action_result_message", "Hubo un error al crear la HA.");
			}
			response.sendRedirect("listar");
		}

		

		else if (accion.equals("editar")) {
			ha.setActividad(new actividad());
			ha.setUsuario(new usuario());
			ha.setIdHA(Integer.parseInt(request.getParameter("idHA")));
			ha.getUsuario().setIdUsuario((Integer.parseInt(request.getParameter("idUsuario"))));
			ha.getActividad().setIdActividad((Integer.parseInt(request.getParameter("idActividad"))));
			ha.setDia(request.getParameter("dia"));
			ha.setHoraComienzo(LocalTime.parse(request.getParameter("horaComienzo"), dtFormat).minusHours(3));
			ha.setHoraFin(LocalTime.parse(request.getParameter("horaFin"), dtFormat).minusHours(3));
			ha.setCuposDisponibles(Integer.parseInt(request.getParameter("cuposDisponibles")));
			int sinError = ctrlHA.editarHA(ha);
			if (sinError == 1) {
				request.getSession().setAttribute("action_result_status", "1");
				request.getSession().setAttribute("action_result_message", "Se ha editado el HA Correctamente!");
			} else {
				request.getSession().setAttribute("action_result_status", "0");
				request.getSession().setAttribute("action_result_message", "Hubo un error al editar el HA.");
			}
			response.sendRedirect("listar");
		}
		
		
		
	}

}
