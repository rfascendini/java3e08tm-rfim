
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
<title>Listar Usuarios</title>

<style>
th, td {
	vertical-align: middle !important;
}

thead>tr>th {
	color: white !important
}
</style>

</head>
<body class="bg-info">

	<jsp:include page="../header.jsp" />

	<div class="container mt-5">

		<table class="table p-0 table-hover bg-white shadow-xl rounded-3">
			<thead>
				<tr class="bg-dark">
					<th scope="col">ID</th>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido</th>
					<th scope="col">Email</th>
					<th scope="col">Telefono</th>
					<th scope="col">Tipo Usuario</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>

				<%
				// CREAMOS UNA LINKED LIST DE USUARIOS
				LinkedList<usuario> usuarios = (LinkedList<usuario>) request.getSession().getAttribute("listado_de_usuarios");

				// RECORREMOS LA LINKED LIST
				for (usuario u : usuarios) {
				%>

				<tr>
					<th scope="row"><%=u.getIdUsuario()%></th>
					<td><%=u.getNombre()%></td>
					<td><%=u.getApellido()%></td>
					<td><%=u.getEmail()%></td>
					<td><%=u.getTelefono()%></td>
					<td><%=u.getTipoUsuario()%></td>
					<td>
						<a href="editar?id=<%=u.getIdUsuario()%>" class="btn btn-warning">Editar</a> 
						
						<% if(u.getTipoUsuario().equals("Cliente")) { %>
						<a href="../ha_clientes/listarPorCliente?id=<%=u.getIdUsuario()%>" class="btn btn-primary">Ver Actividades</a>
						<a href="../cuotas_clientes/listarPorCliente?id=<%=u.getIdUsuario()%>" class="btn btn-info text-white">Ver Cuotas</a>						
						<% } %>
						
						<% if(u.getTipoUsuario().equals("Profesor")) { %>
						<a href="../ha/listarPorProfesor?id=<%=u.getIdUsuario()%>" class="btn btn-success">Ver Actividades</a>
						<% } %>
						
						
						<a href="eliminar?id=<%=u.getIdUsuario()%>" class="btn btn-danger">Eliminar</a>
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