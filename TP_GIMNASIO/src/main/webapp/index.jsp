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

<title>Login</title>

<style>
.borderShadow {
	box-shadow: 0px 0px 31px 21px rgba(0, 0, 0, 0.76);
	-webkit-box-shadow: 0px 0px 31px 21px rgba(0, 0, 0, 0.76);
	-moz-box-shadow: 0px 0px 30px 21px rgba(0, 0, 0, 0.76);
}
</style>

</head>
<body class="d-flex justify-content-center align-items-center"
	style="height: 100vh; background-image: url('images/bgIndex.jpg'); background-size: cover;">

	<%
	String e = "2"; // CERRAR SESION;
	if (e.equals(request.getParameter("estado"))) {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		response.sendRedirect("index.jsp");
	}
	%>



	<div class="container bg-white borderShadow p-5" style="width: 400px">
		<form action="Login" method="post">
			<h1 class="text-center mb-3 fw-600">INICIAR SESIÓN</h1>

			<div class="form-floating">
				<input type="number" name="dni" min="1" max="99999999"
					class="form-control" id="floatingInput"
					placeholder="N° de Documento" /> <label for="floatingInput">DNI</label>
			</div>
			<div class="form-floating mt-1">
				<input type="password" name="password" class="form-control"
					id="floatingPassword" placeholder="Contraseña" /> <label
					for="floatingPassword">Contraseña</label>
			</div>

			<div class="text-center">
				<button class="btn btn-lg btn-block btn-primary mt-3" type="submit">INICIAR
					SESIÓN</button>
			</div>
		</form>
	</div>


	<!-- JavaScript -->
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>