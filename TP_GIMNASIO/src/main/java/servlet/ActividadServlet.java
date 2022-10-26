package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.CtrlActividad;
import java.io.IOException;
import java.util.LinkedList;
import entities.actividad;


/**
 * Servlet implementation class ActividadServlet
 */
public class ActividadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActividadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/editar")) {
			int idActividad = Integer.parseInt(request.getParameter("id"));
			CtrlActividad ctrlActividad = new CtrlActividad();
			actividad act = ctrlActividad.getActividad(idActividad);
			if (act != null) {
				request.getSession().setAttribute("actividad_a_editar", act);
				response.sendRedirect("./editar.jsp"); 
			} else {
				System.out.println("NO ESTA SELECCIONANDO UNA ACTIVIDAD");
			}
		}
		
		


		if (request.getHttpServletMapping().getMatchValue().endsWith("/nuevo")) {
			response.sendRedirect("./nuevo.jsp");
		}

		
	
		
		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/eliminar")) {
			System.out.println("eliminar");
			int idActividad = Integer.parseInt(request.getParameter("id"));
			actividad a = new actividad();
			a.setIdActividad(idActividad);
			CtrlActividad ctrlActividad = new CtrlActividad();
			int sinError = ctrlActividad.eliminarActividad(a);
			if (sinError == 1) {
				request.getSession().setAttribute("action_result_status", "1");
				request.getSession().setAttribute("action_result_message", "Se ha eliminado la Actividad Correctamente!");
			} else {
				request.getSession().setAttribute("action_result_status", "0");
				request.getSession().setAttribute("action_result_message", "Hubo un error al eliminar la Actividad.");
			}
			response.sendRedirect("listar"); // SE REDIRECCIONA A LISTAR DEL SERVLET PARA QUE VUELVA A REALIZAR LA CONSULTA ACTUALIZADA Y ACTUALICE EL OBJETO LINKEDLIST DE USUARIOS LISTADOS
			
		}


		
		
		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/listar")) {
			CtrlActividad ctrlActividad = new CtrlActividad();
			LinkedList<actividad> actividades = ctrlActividad.listarActividades();
			request.getSession().setAttribute("listado_de_actividades", actividades);
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
		actividad a = new actividad();
		CtrlActividad ctrlActividad = new CtrlActividad();

		
		
		
		if (accion.equals("nuevo")) {
			a.setNombre(request.getParameter("nombre"));
			a.setDescripcion(request.getParameter("descripcion"));
			a.setEliminado(0);
			int sinError = ctrlActividad.nuevoActividad(a);
			if (sinError == 1) {
				request.getSession().setAttribute("action_result_status", "1");
				request.getSession().setAttribute("action_result_message", "Se ha creado una Actividad Correctamente!");
			} else {
				request.getSession().setAttribute("action_result_status", "0");
				request.getSession().setAttribute("action_result_message", "Hubo un error al crear una Actividad.");
			}
			response.sendRedirect("listar");
		}

		
		
		
		
		else if (accion.equals("editar")) {
			a.setIdActividad(Integer.parseInt(request.getParameter("idActividad")));
			a.setNombre(request.getParameter("nombre"));
			a.setDescripcion(request.getParameter("descripcion"));
			a.setEliminado(0);
			int sinError = ctrlActividad.editarActividad(a);
			if (sinError == 1) {
				request.getSession().setAttribute("action_result_status", "1");
				request.getSession().setAttribute("action_result_message", "Se ha editado la Actividad Correctamente!");
			} else {
				request.getSession().setAttribute("action_result_status", "0");
				request.getSession().setAttribute("action_result_message", "Hubo un error al editar la Actividad.");
			}
			response.sendRedirect("listar");
		}
		
		
		
	}

	
	
}
