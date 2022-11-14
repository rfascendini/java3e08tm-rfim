<%
if (request.getSession().getAttribute("tpjava_usuario_sesionIniciada") == "true") {
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/estilos.css">
<title>MENU</title>

</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="container shadow-xl bg-primary mt-5 rounded-3">
		<h1 class="p-5 text-white fw-bold">
			¡Bienvenido
			<%=request.getSession().getAttribute("tpjava_usuario_nombre") + " "
		+ request.getSession().getAttribute("tpjava_usuario_apellido")%>!
		</h1>
	</div>

	<jsp:include page="footer.jsp" />

	<!-- JavaScript -->
	<script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>

<%
} else {
	request.getSession().setAttribute("action_result_status", "sesionNoIniciada");
	request.getSession().setAttribute("action_result_message", "Debe iniciar sesión para continuar...");
	response.sendRedirect("../index.jsp");
}
%>