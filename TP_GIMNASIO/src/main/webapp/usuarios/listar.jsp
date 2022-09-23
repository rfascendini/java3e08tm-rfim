
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
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>

				<%
				// CREAMOS UNA LINKED LIST DE USUARIOS
				LinkedList<usuario> usuarios = new LinkedList<usuario>();

				// CREAMOS UNA INSTANCIA DE DATA USUARIO 
				DataUsuario du = new DataUsuario();

				// LE ASIGNAMOS EL RESULTADO DE LISTAR USUARIOS A LA LINKED LIST USUARIOS
				usuarios = du.listarUsuarios();

				// RECORREMOS LA LINKED LIST
				for (usuario u : usuarios) {
				%>

				<tr>
					<th scope="row"><%=u.getIdUsuario()%></th>
					<td><%=u.getNombre()%></td>
					<td><%=u.getApellido()%></td>
					<td><%=u.getEmail()%></td>
					<td><%=u.getTelefono()%></td>
					<td><a href="javascript:void(0)" class="btn btn-primary">Ver Información</a> <a href="editar?id=<%=u.getIdUsuario()%>"
						class="btn btn-warning">Editar</a> <a href="javascript:void(0)"
						class="btn btn-danger">Eliminar</a> <a href="javascript:void(0)"
						class="btn btn-secondary">Ver Actividades</a></td>
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