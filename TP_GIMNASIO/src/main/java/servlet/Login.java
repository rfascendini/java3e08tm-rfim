package servlet;

import logic.*;
import entities.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		String dni = request.getParameter("dni");
	    String password = request.getParameter("password");
	    
	    CtrlLogin login = new CtrlLogin();
		
		usuario usuarioEncontrado = login.validar(dni,password); 
		
		if(usuarioEncontrado != null) {
			
			request.setAttribute("nombre",usuarioEncontrado.getNombre());
			request.setAttribute("apellido",usuarioEncontrado.getApellido());
			request.setAttribute("dni",usuarioEncontrado.getDni());
			
			// SI EL USUARIO ES CORRECTO, REDIRECCIONA A MENU.JSP
			request.getRequestDispatcher("index.jsp").forward(request, response); 
		} else {
			
			// DEVOLVER ERROR DE USUARIO NO ENCONTRADO
			request.setAttribute("error","El usuario no fue encontrado");
			
			// REDIRECCIONAMOS AL INDEX.JSP
			request.getRequestDispatcher("index.jsp").forward(request, response); 
		}
		
		
	}



}
