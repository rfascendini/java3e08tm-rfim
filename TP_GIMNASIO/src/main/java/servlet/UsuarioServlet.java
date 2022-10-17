package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.CtrlLogin;
import logic.CtrlUsuario;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;

import entities.usuario;

/**
 * Servlet implementation class UserServlet
 */

@WebServlet("/UsuarioServlet")

public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioServlet() {
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

		if (request.getHttpServletMapping().getMatchValue().endsWith("/editar")) {

			int idUsuario = Integer.parseInt(request.getParameter("id"));

			CtrlUsuario ctrlUsuario = new CtrlUsuario();

			usuario user = ctrlUsuario.getUsuario(idUsuario);

			if (user != null) {

				request.getSession().setAttribute("usuario_a_editar", user);

				// SI EL USUARIO ES CORRECTO, REDIRECCIONA A EDITAR.JSP

				// request.getRequestDispatcher("./editar.jsp").forward(request, response);
				// <----- ESTA LINEA REDIRECCIONA CON URL CON PARAMETRO

				response.sendRedirect("./editar.jsp"); // <----- ESTA LINEA REDIRECCIONA A LA URL ESCRITA SIN PARAMETROS (TRABAJAR SOLO CON SESSION)

			} else {

			}

		}

		if (request.getHttpServletMapping().getMatchValue().endsWith("/nuevo")) {
			response.sendRedirect("./nuevo.jsp");
		}

		if (request.getHttpServletMapping().getMatchValue().endsWith("/eliminar")) {
			System.out.println("eliminar");
			// TODO baja
		
			int idUsuario = Integer.parseInt(request.getParameter("id"));
			
			usuario u = new usuario();

			// EN LOS REGISTROS NUEVOS NO SE PONE EL ID AUTOINCREMENTAL

			u.setIdUsuario(idUsuario);
			u.setEliminado(1);

			CtrlUsuario ctrlUsuario = new CtrlUsuario();

			int sinError = ctrlUsuario.eliminarUsuario(u);

			if (sinError == 1) {
				request.getSession().setAttribute("status_nuevoUsuario", 1);
				System.out.println("SE ELIMINO EL USUARIO CORRECTAMENTE!");
			} else {
				request.getSession().setAttribute("status_nuevoUsuario", 0);
				System.out.println("ERROR, NO SE PUDO ELIMINAR  AL USUARIO");
			}
			
			// TODO redirigir
			response.sendRedirect("listar"); // SE REDIRECCIONA A LISTAR DEL SERVLET PARA QUE VUELVA A REALIZAR LA CONSULTA ACTUALIZADA Y ACTUALICE EL OBJETO LINKEDLIST DE USUARIOS LISTADOS
			
		}

		if (request.getHttpServletMapping().getMatchValue().endsWith("/listar")) {
			CtrlUsuario ctrlUsuario = new CtrlUsuario();
			LinkedList<usuario> usuarios = ctrlUsuario.listarUsuarios("%");
			request.getSession().setAttribute("listado_de_usuarios", usuarios);
			response.sendRedirect("./listar.jsp");
		}
		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/listarUsuarios")) {
			CtrlUsuario ctrlUsuario = new CtrlUsuario();
			LinkedList<usuario> usuarios = ctrlUsuario.listarUsuarios("Admin");
			request.getSession().setAttribute("listado_de_usuarios", usuarios);
			response.sendRedirect("./listar.jsp");
		}
		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/listarClientes")) {
			CtrlUsuario ctrlUsuario = new CtrlUsuario();
			LinkedList<usuario> usuarios = ctrlUsuario.listarUsuarios("Cliente");
			request.getSession().setAttribute("listado_de_usuarios", usuarios);
			response.sendRedirect("./listar.jsp");
		}
		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/listarProfesores")) {
			CtrlUsuario ctrlUsuario = new CtrlUsuario();
			LinkedList<usuario> usuarios = ctrlUsuario.listarUsuarios("Profesor");
			request.getSession().setAttribute("listado_de_usuarios", usuarios);
			response.sendRedirect("./listar.jsp");
		}
		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/listarAdministrativos")) {
			CtrlUsuario ctrlUsuario = new CtrlUsuario();
			LinkedList<usuario> usuarios = ctrlUsuario.listarUsuarios("Administrativo");
			request.getSession().setAttribute("listado_de_usuarios", usuarios);
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

		if (accion.equals("nuevo")) {

			usuario u = new usuario();

			// EN LOS REGISTROS NUEVOS NO SE PONE EL ID AUTOINCREMENTAL

			u.setNombre(request.getParameter("nombre"));
			u.setApellido(request.getParameter("apellido"));
			u.setDni(Integer.parseInt(request.getParameter("dni")));
			u.setSexo(request.getParameter("sexo"));
			u.setDomicilio(request.getParameter("domicilio"));
			u.setPassword(request.getParameter("password"));
			u.setEmail(request.getParameter("email"));
			u.setTipoUsuario(request.getParameter("tipoUsuario"));
			u.setTelefono(request.getParameter("telefono"));
			u.setHabilitado(1);
			u.setEliminado(0);

			CtrlUsuario ctrlUsuario = new CtrlUsuario();

			int sinError = ctrlUsuario.nuevoUsuario(u);

			if (sinError == 1) {
				request.getSession().setAttribute("status_nuevoUsuario", 1);
				System.out.println("SE AGREGO UN NUEVO USUARIO");
			} else {
				request.getSession().setAttribute("status_nuevoUsuario", 0);
				System.out.println("ERROR, NO SE PUDO AGREGAR  EL USUARIO");
			}

			response.sendRedirect("listar");

		}

		else if (accion.equals("editar")) {

			usuario u = new usuario();

			u.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
			u.setNombre(request.getParameter("nombre"));
			u.setApellido(request.getParameter("apellido"));
			u.setDni(Integer.parseInt(request.getParameter("dni")));
			u.setSexo(request.getParameter("sexo"));
			u.setDomicilio(request.getParameter("domicilio"));
			u.setPassword(request.getParameter("password"));
			u.setEmail(request.getParameter("email"));
			u.setTipoUsuario(request.getParameter("tipoUsuario"));
			u.setTelefono(request.getParameter("telefono"));
			u.setHabilitado(1);

			CtrlUsuario ctrlUsuario = new CtrlUsuario();

			int sinError = ctrlUsuario.editarUsuario(u);

			if (sinError == 1) {
				request.getSession().setAttribute("status_nuevoUsuario", 1);
				System.out.println("SE EDITO EL USUARIO CORRECTAMENTE");
			} else {
				request.getSession().setAttribute("status_nuevoUsuario", 0);
				System.out.println("ERROR, NO SE PUDO EDITAR EL USUARIO");
			}

			response.sendRedirect("listar");

		}

	}

}
