package servlet;

import logic.*;
import entities.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String dni = request.getParameter("dni");
		String password = request.getParameter("password");

		CtrlLogin login = new CtrlLogin();

		usuario usuarioEncontrado = login.validar(dni, password);

		if (usuarioEncontrado != null) {

			// SETEAMOS LOS VALORES DEL USUARIO ENCONTRADO EN LA SESION
			request.getSession().setAttribute("tpjava_usuario_idUsuario", usuarioEncontrado.getIdUsuario());
			request.getSession().setAttribute("tpjava_usuario_tipoUsuario", usuarioEncontrado.getTipoUsuario());
			request.getSession().setAttribute("tpjava_usuario_nombre", usuarioEncontrado.getNombre());
			request.getSession().setAttribute("tpjava_usuario_apellido", usuarioEncontrado.getApellido());
			request.getSession().setAttribute("tpjava_usuario_fechaNacimiento", usuarioEncontrado.getFechaNacimiento());
			request.getSession().setAttribute("tpjava_usuario_dni", usuarioEncontrado.getDni());
			request.getSession().setAttribute("tpjava_usuario_sexo", usuarioEncontrado.getSexo());
			request.getSession().setAttribute("tpjava_usuario_domicilio", usuarioEncontrado.getDomicilio());
			request.getSession().setAttribute("tpjava_usuario_password", usuarioEncontrado.getPassword());
			request.getSession().setAttribute("tpjava_usuario_email", usuarioEncontrado.getEmail());
			request.getSession().setAttribute("tpjava_usuario_telefono", usuarioEncontrado.getTelefono());
			request.getSession().setAttribute("tpjava_usuario_habilitado", usuarioEncontrado.getHabilitado());
			request.getSession().setAttribute("tpjava_usuario_eliminado", usuarioEncontrado.getEliminado());
			request.getSession().setAttribute("tpjava_usuario_sesionIniciada", "true");

			// SI EL USUARIO ES CORRECTO, REDIRECCIONA A MENU.JSP
			response.sendRedirect("menu.jsp");

		} else {

			// DEVOLVER ERROR DE USUARIO NO ENCONTRADO
			request.getSession().setAttribute("action_result_status", "0");
			request.getSession().setAttribute("action_result_message", "El usuario no fue encontrado");
			response.sendRedirect("index.jsp");
		}

	}

}
