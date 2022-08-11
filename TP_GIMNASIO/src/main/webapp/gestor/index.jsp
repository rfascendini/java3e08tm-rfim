<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<title>Login</title>

<style>
.borderShadow {
	box-shadow: -1px 7px 20px 13px rgba(0, 0, 0, 0.75);
	-webkit-box-shadow: -1px 7px 20px 13px rgba(0, 0, 0, 0.75);
	-moz-box-shadow: -1px 7px 20px 13px rgba(0, 0, 0, 0.75);
}
</style>

</head>
<body
	class="bg-primary d-flex justify-content-center align-items-center"
	style="height: 100vh">

	<div class="container bg-white borderShadow p-5" style="width: 400px">
		<form action="Login" method="post">
			<h1 class="text-center mb-3 fw-600">INICIAR SESION<br>ADMINISTRADOR</h1>

			<div class="form-floating">
				<input type="number" name="dni" class="form-control"
					id="floatingInput" placeholder="N° de Documento" /> <label
					for="floatingInput">DNI</label>
			</div>
			<div class="form-floating mt-1">
				<input type="password" name="password" class="form-control"
					id="floatingPassword" placeholder="Password" /> <label
					for="floatingPassword">Password</label>
			</div>

			<div class="text-center">
				<button class="btn btn-lg btn-block btn-primary mt-3" type="submit">Iniciar Sesion</button>
			</div>
		</form>
	</div>


	<!-- JavaScript -->
	<script src="../js/bootstrap.bundle.min.js"></script>
</body>
</html>