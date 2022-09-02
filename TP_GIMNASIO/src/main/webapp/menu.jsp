<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>MENU</title>

</head>
<body class="">

	<jsp:include page="header.jsp" />

	<%
	if (request.getSession().getAttribute("tpjava_usuario_sesionIniciada") == "true") {
	%>


	<div>
		<h1 class="text-white"><%=request.getSession().getAttribute("tpjava_usuario_nombre") + " "
		+ request.getSession().getAttribute("tpjava_usuario_apellido")%></h1>
	</div>

	<%
	} else {

	response.sendRedirect("index.jsp?error=sesionNoIniciada");

	}
	%>




	<!-- JavaScript -->
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>