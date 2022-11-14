
<%
if (request.getSession().getAttribute("tpjava_usuario_sesionIniciada") == "true") {
%>

<%@ page import="java.util.*"%>
<%@ page import="entities.*"%>
<%@ page import="logic.*"%>
<%@ page import="servlet.*"%>
<%@ page import="data.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/estilos.css">
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<title>Listar Horarios Actividades y Clientes</title>

</head>
<body class="bg-info">

	<%
	if (request.getSession().getAttribute("action_result_status") == "1") {
	%>
	<script>
			Swal.fire({
			  icon: 'success',
			  title: '<%=request.getSession().getAttribute("action_result_message")%>',
			})
		</script>
	<%
	} else if (request.getSession().getAttribute("action_result_status") == "0") {
	%>
	<script>
		Swal.fire({
			icon : 'error',
			title : 'Oops...',
			text : '<%=request.getSession().getAttribute("action_result_message")%>
		',
				})
	</script>
	<%
	}
	request.getSession().setAttribute("action_result_status", null);
	request.getSession().setAttribute("action_result_message", null);
	%>


	<jsp:include page="../header.jsp" />

	<div class="container mt-5">

		<div class="row">

			<div class="col-12 col-md-6">

				<div class="p-5 m-3 bg-light">

					<form action="listarPorCuota" method="post" id="formCuotas">
					
						<input type="hidden" name="accion" value="listarClientesPorCuota">

						<div class="mb-3">
							<label for="" class="form-label fw-bold">SELECCIONE UNA CUOTA</label>
							<%
							LinkedList<cuota> cuotas = new LinkedList<cuota>();
							CtrlCuota ctrlCuota = new CtrlCuota();
							cuotas = ctrlCuota.listarCuotasDisponibles();
							%>
							<select class="form-control" name="idCuota" id="">
								<%
								for (cuota c : cuotas) {
								%>
								<option value="<%=c.getIdCuota()%>"><%=c.getAnio() + " - " + c.getNombreMes()%></option>
								<%
								}
								%>
							</select>
						</div>

						<div class="mb-3">
							<button type="submit" class="btn btn-secondary" form="formCuotas">MOSTRAR CLIENTES</button>
						</div>

					</form>

				</div>

			</div>

			<div class="col-12 col-md-6 text-white">

				<div class="p-5 m-3 bg-secondary">

					<form action="listarPorCliente" method="post" id="formCliente">
					
						<input type="hidden" name="accion" value="listarCuotasPorCliente">

						<div class="mb-3">
							<label for="" class="form-label fw-bold">SELECCIONE UN CLIENTE</label>
							<%
							LinkedList<usuario> usuarios = new LinkedList<usuario>();
							CtrlUsuario ctrlUsuario = new CtrlUsuario();
							usuarios = ctrlUsuario.listarUsuarios("Cliente");
							%>
							<select class="form-control" name="idUsuario" id="">
								<%
								for (usuario u : usuarios) {
								%>
								<option value="<%=u.getIdUsuario()%>"><%=u.getApellido() + ", " + u.getNombre()%></option>
								<%
								}
								%>
							</select>
						</div>

						<div class="mb-3">
							<button type="submit" class="btn btn-light" form="formCliente">MOSTRAR CUOTAS</button>
						</div>

					</form>

				</div>

			</div>
			
			<% if(request.getSession().getAttribute("listado_de_cuotas_por_cliente") != null) { %>
			<table class="col-12 table p-0 mt-4 table-hover bg-white shadow-xl rounded-3">
				<thead>
					<tr class="bg-dark">
						<th scope="col">Mes</th>
						<th scope="col">Año</th>
						<th scope="col">Monto</th>
						<th scope="col">Fecha Pago</th>
						<th scope="col">Monto Abonado</th>
						<th scope="col">Acciones</th>
					</tr>
				</thead>
				<tbody>
				<%
				LinkedList<cliente_cuota> cuotasDeCliente = (LinkedList<cliente_cuota>) request.getSession().getAttribute("listado_de_cuotas_por_cliente");
				for (cliente_cuota cc : cuotasDeCliente) {
				%>
				<tr>
					<td><%=cc.getCuota().getNombreMes() %></td>
					<td><%=cc.getCuota().getAnio() %></td>
					<td><%=cc.getCuota().getMonto() %></td>
					<td><%=cc.getFechaPago() %></td>
					<td><%=cc.getMontoAbonado() %></td>
					<td>
						<% if(cc.getFechaPago() == null) { %>
						<a href="pagarCuotaDesdeCliente?idCuota=<%=cc.getCuota().getIdCuota()%>&idCliente=<%=cc.getUsuario().getIdUsuario()%>&monto=<%=cc.getCuota().getMonto()%>" class="btn btn-danger">Pagar Cuota</a>
						<% } else { %>
						<h3 class="fw-bold text-success m-0 p-0">COBRADO</h3>
						<% } %>
						</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<% } %>
		
		
		
		
		
		<% if(request.getSession().getAttribute("listado_de_clientes_por_cuota") != null) { %>
		
			<table class="col-12 table mt-4 p-0 table-hover bg-white shadow-xl rounded-3">
				<thead>
					<tr class="bg-dark">
						<th scope="col">Cliente</th>
						<th scope="col">Fecha Pago</th>
						<th scope="col">Monto Abonado</th>
						<th scope="col">Acciones</th>
					</tr>
				</thead>
				<tbody>
				<%
				LinkedList<cliente_cuota> clientesDeCuota = (LinkedList<cliente_cuota>) request.getSession().getAttribute("listado_de_clientes_por_cuota");
				for (cliente_cuota cc : clientesDeCuota) {
				%>
				<tr>
					<td><%=cc.getUsuario().getApellido()+", "+cc.getUsuario().getNombre() %></td>
					<td><%=cc.getFechaPago() %></td>
					<td><%=cc.getMontoAbonado() %></td>
					<td>
						<% if(cc.getFechaPago() == null) { %>
						<h3 class="fw-bold text-danger m-0 p-0">NO COBRADO</h3>
						<% } else { %>
						<h3 class="fw-bold text-success m-0 p-0">COBRADO</h3>
						<% } %>
						</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<% } %>

		</div>

	</div>


	<jsp:include page="../footer.jsp" />



	<!-- JavaScript -->

	<script src="../js/bootstrap.bundle.min.js"></script>
</body>
</html>

<%
} else {
response.sendRedirect("../index.jsp?error=sesionNoIniciada");
}
%>