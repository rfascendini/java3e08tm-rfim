
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
<title>Listar Horarios Actividades</title>

</head>
<body class="bg-info">

	<% 
	if(request.getSession().getAttribute("action_result_status") == "1") { %>
		<script>
			Swal.fire({
			  icon: 'success',
			  title: '<%=request.getSession().getAttribute("action_result_message") %>',
			})
		</script>
	<% } else if(request.getSession().getAttribute("action_result_status") == "0") { %>
		<script>
		Swal.fire({
			icon : 'error',
			title : 'Oops...',
			text : '<%=request.getSession().getAttribute("action_result_message") %>',
		})
		</script>
	<% } 
	request.getSession().setAttribute("action_result_status",null);
	request.getSession().setAttribute("action_result_message",null);
	%>
	

	<jsp:include page="../header.jsp" />

	<div class="container mt-5">

		<table class="table p-0 table-hover bg-white shadow-xl rounded-3"
			style="max-width: 768">
			<thead>
				<tr class="bg-dark">
					<th scope="col">ID HA</th>
					<th scope="col">Actividad</th>
					<th scope="col">Usuario</th>
					<th scope="col">Día</th>
					<th scope="col">Hora Comienzo</th>
					<th scope="col">Hora Fin</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>

				<%
				// CREAMOS UNA LINKED LIST DE Actividades
				LinkedList<horarioActividad> horariosActividades = (LinkedList<horarioActividad>) request.getSession().getAttribute("listado_de_ha");
				DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

				// RECORREMOS LA LINKED LIST
				for (horarioActividad ha : horariosActividades) {
				%>

				<tr>
					<th><%=ha.getIdHA()%></th>
					<th><%=ha.getActividad().getNombre()%></th>
					<td><%=ha.getUsuario().getNombre()%></td>
					<td><%=ha.getDia()%></td>
					<td><%=ha.getHoraComienzo().format(dtFormat.withZone(ZoneId.of("UTC-3")))%></td>
					<td><%=ha.getHoraFin().format(dtFormat.withZone(ZoneId.of("UTC-3")))%></td>
					<td>
						<% if (request.getSession().getAttribute("tpjava_usuario_tipoUsuario").equals("Admin") || request.getSession().getAttribute("tpjava_usuario_tipoUsuario").equals("Administrativo")) { %>
						<a href="editar?id=<%=ha.getIdHA()%>" class="btn btn-warning">Editar</a>
						<a href="javascript:void(0)" class="btn btn-primary">Ver Clientes</a>
						<a href="eliminar?id=<%=ha.getIdHA()%>" class="btn btn-danger">Eliminar</a>
						<% } else if (request.getSession().getAttribute("tpjava_usuario_tipoUsuario").equals("Cliente")) { %>
						<a href="javascript:void(0)" class="btn btn-primary">Inscribirme</a>
						<% } %>
					</td>
				</tr>

				<%
				}
				%>


			</tbody>
		</table>

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