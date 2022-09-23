package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.CtrlLogin;
import logic.CtrlUsuario;

import java.io.IOException;

import entities.usuario;

/**
 * Servlet implementation class UserServlet
 */
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

			// 	CtrlUsuario ctrlUsuario = new CtrlUsuario();
			//
			// 	usuario user = ctrlUsuario.getUsuario(idUsuario);
			//		
			// 	int id = user.getIdUsuario();

			request.getSession().setAttribute("usuario_a_editar", idUsuario);

			// SI EL USUARIO ES CORRECTO, REDIRECCIONA A EDITAR.JSP
			response.sendRedirect("./editar.jsp");

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
	}

}
