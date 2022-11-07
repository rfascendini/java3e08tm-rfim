package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.CtrlCuota;
import logic.CtrlHA;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import entities.actividad;
import entities.cuota;
import entities.horarioActividad;
import entities.usuario;

/**
 * Servlet implementation class CuotaServlet
 */
public class CuotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuotaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/editar")) {
			int idCuota = Integer.parseInt(request.getParameter("id"));
			CtrlCuota ctrlCuota = new CtrlCuota();
			cuota c = ctrlCuota.getCuota(idCuota);
			if (c != null) {
				request.getSession().setAttribute("cuota_a_editar", c);
				response.sendRedirect("./editar.jsp"); 
			} else {
				System.out.println("NO ESTA SELECCIONANDO UNA CUOTA");
			}
		}
		
		
	
		if (request.getHttpServletMapping().getMatchValue().endsWith("/listar")) {
			CtrlCuota ctrlCuota = new CtrlCuota();
			LinkedList<cuota> cuotas = ctrlCuota.listarCuotas();
			request.getSession().setAttribute("listado_de_cuotas", cuotas);
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
		cuota c = new cuota();
		CtrlCuota ctrlCuota = new CtrlCuota();

		if (accion.equals("editar")) {
			c.setIdCuota(Integer.parseInt(request.getParameter("idCuota")));
			c.setMonto(Integer.parseInt(request.getParameter("monto")));
			int sinError = ctrlCuota.editarCuota(c);
			if (sinError == 1) {
				request.getSession().setAttribute("action_result_status", "1");
				request.getSession().setAttribute("action_result_message", "Se ha editado la Cuota Correctamente!");
			} else {
				request.getSession().setAttribute("action_result_status", "0");
				request.getSession().setAttribute("action_result_message", "Hubo un error al editar la Cuota.");
			}
			response.sendRedirect("listar");
		}
		
		
		
		
		
		
	}

}
