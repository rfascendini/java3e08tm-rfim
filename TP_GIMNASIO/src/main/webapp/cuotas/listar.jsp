
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
					<th scope="col">Mes</th>
					<th scope="col">Año</th>
					<th scope="col">Monto</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			
				<%
				// CREAMOS UNA LINKED LIST DE Actividades
				LinkedList<cuota> cuotas = (LinkedList<cuota>) request.getSession().getAttribute("listado_de_cuotas");

				// RECORREMOS LA LINKED LIST
				for (cuota c : cuotas) {
				%>

				<tr>
					<td><%=c.getMes()%></td>
					<td><%=c.getAnio()%></td>
					<td><% if(c.getMonto() == 0) { out.print("Sin Asignar"); } else { out.print(c.getMonto()); }%></td>
					<td>
						<a href="editar?id=<%=c.getIdCuota()%>" class="btn btn-warning">Editar Monto</a>
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