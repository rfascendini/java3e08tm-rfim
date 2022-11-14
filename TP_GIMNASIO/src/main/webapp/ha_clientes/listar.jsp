
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
<title>Listar Horarios Actividades y Clientes</title>

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
					<th scope="col">ID HAC</th>
					<th scope="col">Actividad</th>
					<th scope="col">Dia</th>
					<th scope="col">Hs Comienzo</th>
					<th scope="col">Hs Fin</th>
					<th scope="col">Cliente</th>
					<th scope="col">Fecha Registro</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			
				<%
				// CREAMOS UNA LINKED LIST DE Actividades
				LinkedList<ha_cliente> hacs = (LinkedList<ha_cliente>) request.getSession().getAttribute("listado_de_hac");
				DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
				DateTimeFormatter dtFormat2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

				// RECORREMOS LA LINKED LIST
				for (ha_cliente hac : hacs) {
				%>

				<tr>
					<td><%=hac.getIdHAC()%></td>
					<td><%=hac.getHA().getActividad().getNombre()%></td>
					<td><%=hac.getHA().getDia()%></td>
					<td><%=hac.getHA().getHoraComienzo().format(dtFormat.withZone(ZoneId.of("UTC-3")))%></td>
					<td><%=hac.getHA().getHoraFin().format(dtFormat.withZone(ZoneId.of("UTC-3")))%></td>
					<td><%=hac.getUsuario().getNombre()%></td>
					<td><%=hac.getFechaRegistro().format(dtFormat2.withZone(ZoneId.of("UTC-3")))%></td>
					<td>
						<a href="darDeBaja?id=<%=hac.getIdHAC()%>" class="btn btn-warning">Dar de Baja</a>
						<a href="eliminar?id=<%=hac.getIdHAC()%>" class="btn btn-danger">Eliminar</a>
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
	request.getSession().setAttribute("action_result_status", "sesionNoIniciada");
	request.getSession().setAttribute("action_result_message", "Debe iniciar sesión para continuar...");
	response.sendRedirect("../index.jsp");
}
%>