package servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import logic.CtrlCuotaCliente;


import java.io.IOException;
import java.util.LinkedList;

import entities.cliente_cuota;
import entities.cuota;

import entities.usuario;

/**
 * Servlet implementation class CuotaClienteServlet
 */
public class CuotaClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CuotaClienteServlet() {
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
		
		request.getSession().setAttribute("listado_de_cuotas_por_cliente", null);
		request.getSession().setAttribute("listado_de_clientes_por_cuota", null);

		if (request.getHttpServletMapping().getMatchValue().endsWith("/listar")) {
			response.sendRedirect("./listar.jsp");
		}
		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/pagarCuotaDesdeCliente")) {
			
			cuota cuota = new cuota();
			usuario cliente = new usuario();
			
			cuota.setIdCuota(Integer.parseInt(request.getParameter("idCuota")));
			cuota.setMonto(Integer.parseInt(request.getParameter("monto")));
			cliente.setIdUsuario(Integer.parseInt(request.getParameter("idCliente")));
			
			CtrlCuotaCliente ctrlCC = new CtrlCuotaCliente();
			
			int sinError = ctrlCC.nuevoCC(cuota, cliente);
			if (sinError == 1) {
				request.getSession().setAttribute("action_result_status", "1");
				request.getSession().setAttribute("action_result_message", "Se ha cobrado la Cuota Correctamente!");
			} else {
				request.getSession().setAttribute("action_result_status", "0");
				request.getSession().setAttribute("action_result_message", "Hubo un error al cobrar la Cuota.");
			}
			
			CtrlCuotaCliente ctrlCuotaCliente = new CtrlCuotaCliente();
			LinkedList<cliente_cuota> cuotas = ctrlCuotaCliente.listarCuotasPorCliente(cliente);
			request.getSession().setAttribute("listado_de_cuotas_por_cliente", cuotas);
			response.sendRedirect("./listar.jsp");
			
		}
		
		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/pagarCuotaDesdeCuota")) {
			
			cuota cuota = new cuota();
			usuario cliente = new usuario();
			
			cuota.setIdCuota(Integer.parseInt(request.getParameter("idCuota")));
			cuota.setMonto(Integer.parseInt(request.getParameter("monto")));
			cliente.setIdUsuario(Integer.parseInt(request.getParameter("idCliente")));
			
			CtrlCuotaCliente ctrlCC = new CtrlCuotaCliente();
			
			int sinError = ctrlCC.nuevoCC(cuota, cliente);
			if (sinError == 1) {
				request.getSession().setAttribute("action_result_status", "1");
				request.getSession().setAttribute("action_result_message", "Se ha cobrado la Cuota Correctamente!");
			} else {
				request.getSession().setAttribute("action_result_status", "0");
				request.getSession().setAttribute("action_result_message", "Hubo un error al cobrar la Cuota.");
			}
			
			CtrlCuotaCliente ctrlCuotaCliente = new CtrlCuotaCliente();
			LinkedList<cliente_cuota> clientes = ctrlCuotaCliente.listarClientesPorCuota(cuota);
			request.getSession().setAttribute("listado_de_clientes_por_cuota", clientes);
			response.sendRedirect("./listar.jsp");
			
		}
		
		
		if (request.getHttpServletMapping().getMatchValue().endsWith("/listarCuotasPorCliente")) {
			usuario cliente = new usuario();
			CtrlCuotaCliente ctrlCuotaCliente = new CtrlCuotaCliente();
			cliente.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
			LinkedList<cliente_cuota> cuotas = ctrlCuotaCliente.listarCuotasPorCliente(cliente);
			request.getSession().setAttribute("listado_de_cuotas_por_cliente", cuotas);
			
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
		CtrlCuotaCliente ctrlCuotaCliente = new CtrlCuotaCliente();
		request.getSession().setAttribute("listado_de_cuotas_por_cliente", null);
		request.getSession().setAttribute("listado_de_clientes_por_cuota", null);

		if (accion.equals("listarCuotasPorCliente")) {
			usuario cliente = new usuario();
			cliente.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
			LinkedList<cliente_cuota> cuotas = ctrlCuotaCliente.listarCuotasPorCliente(cliente);
			request.getSession().setAttribute("listado_de_cuotas_por_cliente", cuotas);
			
			response.sendRedirect("./listar.jsp");
		}

		else if (accion.equals("listarClientesPorCuota"))

		{
			cuota cuota = new cuota();
			cuota.setIdCuota(Integer.parseInt(request.getParameter("idCuota")));
			LinkedList<cliente_cuota> clientes = ctrlCuotaCliente.listarClientesPorCuota(cuota);
			request.getSession().setAttribute("listado_de_clientes_por_cuota", clientes);
			response.sendRedirect("./listar.jsp");
		}

	}

}
