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
			// TODO baja
		
			int idActividad = Integer.parseInt(request.getParameter("id"));
			
			actividad a = new actividad();

			// EN LOS REGISTROS NUEVOS NO SE PONE EL ID AUTOINCREMENTAL

			a.setIdActividad(idActividad);
			a.setEliminado(1);

			CtrlActividad ctrlActividad = new CtrlActividad();

			int sinError = ctrlActividad.eliminarActividad(a);

			if (sinError == 1) {
				request.getSession().setAttribute("status_nuevoActividad", 1);
				System.out.println("SE ELIMINO LA ACTIVIDAD CORRECTAMENTE!");
			} else {
				request.getSession().setAttribute("status_nuevoActividad", 0);
				System.out.println("ERROR, NO SE PUDO ELIMINAR LA ACTIVIDAD");
			}
			
			// TODO redirigir
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

		if (accion.equals("nuevo")) {

			actividad a = new actividad();

			// EN LOS REGISTROS NUEVOS NO SE PONE EL ID AUTOINCREMENTAL

			a.setNombre(request.getParameter("nombre"));
			a.setDescripcion(request.getParameter("descripcion"));
			a.setEliminado(0);

			CtrlActividad ctrlActividad = new CtrlActividad();

			int sinError = ctrlActividad.nuevoActividad(a);

			if (sinError == 1) {
				request.getSession().setAttribute("status_nuevoActividad", 1);
				System.out.println("SE AGREGO UN NUEVO USUARIO");
			} else {
				request.getSession().setAttribute("status_nuevoActividad", 0);
				System.out.println("ERROR, NO SE PUDO AGREGAR  EL USUARIO");
			}

			response.sendRedirect("listar");

		}

		else if (accion.equals("editar")) {

			actividad a = new actividad();

			a.setIdActividad(Integer.parseInt(request.getParameter("idActividad")));
			a.setNombre(request.getParameter("nombre"));
			a.setDescripcion(request.getParameter("descripcion"));
			a.setEliminado(0);

			CtrlActividad ctrlActividad = new CtrlActividad();

			int sinError = ctrlActividad.editarActividad(a);

			if (sinError == 1) {
				request.getSession().setAttribute("status_nuevoUsuario", 1);
				System.out.println("SE EDITO LA ACTIVIDAD CORRECTAMENTE");
			} else {
				request.getSession().setAttribute("status_nuevoUsuario", 0);
				System.out.println("ERROR, NO SE PUDO EDITAR LA ACTIVIDAD");
			}

			response.sendRedirect("listar");

		}
		
		
		
	}

	
	
}
