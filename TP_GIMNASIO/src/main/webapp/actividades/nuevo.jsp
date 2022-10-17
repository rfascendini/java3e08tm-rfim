
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
<title>Editar Usuario</title>

</head>
<body class="bg-info">

	<jsp:include page="../header.jsp" />

	<div class="container mt-5">

		<div class="container bg-white shadow-xl">
			<form class="needs-validation was-validated p-1" action="nuevoUsuario" method="post">
				<div class="row g-3">
				
					<input type="hidden" name="accion" value="nuevo">
				
					<div class="col-md-6 col-lg-3">
						<label for="nombre" class="form-label">NOMBRE</label> 
						<input type="text" class="form-control" name="nombre" id="nombre" placeholder="">
						<div class="invalid-feedback">Se requiere un NOMBRE válido</div>
					</div>
	
					<div class="col-md-6 col-lg-3">
						<label for="lastName" class="form-label">APELLIDO</label> 
						<input type="text" class="form-control" name="apellido" id="apellido" placeholder="">
						<div class="invalid-feedback">Se requiere un APELLIDO válido</div>
					</div>
	
					<div class="col-md-4 col-lg-2">
						<label for="fechaNacimiento" class="form-label">FEC. NAC.</label>
						<input type="date" class="form-control" name="fechaNacimiento" id="fechaNacimiento" placeholder="">
						<div class="invalid-feedback">Se requiere una FECHA NAC. válida</div>
					</div>
	
					<div class="col-md-4 col-lg-2">
						<label for="dni" class="form-label">DNI</label> 
						<input type="number" class="form-control" name="dni" id="dni" placeholder="">
						<div class="invalid-feedback">Se requiere un DNI válido</div>
					</div>
					
					<div class="col-md-4 col-lg-2">
						<label for="sexo" class="form-label">SEXO</label> 
						<select class="form-select" id="sexo" name="sexo">
							<option value="" selected disabled>Seleccione...</option>
							<option value="F">Femenino</option>
							<option value="M">Masculino</option>
							<option value="O">Otro</option>
						</select>
						<div class="invalid-feedback">Se requiere un SEXO</div>
					</div>
					
					<div class="col-md-6 col-lg-3">
						<label for="password" class="form-label">PASSWORD</label> 
						<input type="text" class="form-control" name="password" id="password" placeholder="">
						<div class="invalid-feedback">Se requiere un PASSWORD válido</div>
					</div>
						
					<div class="col-md-6 col-lg-3">
						<label for="domicilio" class="form-label">DOMICILIO</label> 
						<input type="text" class="form-control" name="domicilio" id="domicilio" placeholder="">
						<div class="invalid-feedback">Se requiere un DOMICILIO válido</div>
					</div>
	
					<div class="col-md-6 col-lg-3">
						<label for="telefono" class="form-label">TELÉFONO</label> 
						<input type="number" class="form-control" name="telefono" id="telefono" placeholder="">
						<div class="invalid-feedback">Se requiere un TELÉFONO válido</div>
					</div>

					<div class="col-md-12 col-lg-3">
						<label for="email" class="form-label">EMAIL</label> 
						<input type="email" class="form-control" name="email" id="email" placeholder="">
						<div class="invalid-feedback">Se requiere un EMAIL válido</div>
					</div>
	
					
				</div>
	
				<div class="mt-5 mb-2">
				<button class="w-100 btn btn-success btn-lg" type="submit">GUARDAR</button>
				</div>
			</form>
		</div>
		
		<div class="text-center mt-5">
				<a href="listar.jsp" class="btn btn-danger btn-lg">VOLVER</a>
		</div>

	</div>

	<jsp:include page="../footer.jsp" />


	<!-- JavaScript -->
	<script src="../js/bootstrap.bundle.min.js"></script>

	<script>
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		(function() {
			'use strict'

			// Fetch all the forms we want to apply custom Bootstrap validation styles to
			var forms = document.querySelectorAll('.needs-validation')

			// Loop over them and prevent submission
			Array.prototype.slice.call(forms).forEach(function(form) {
				form.addEventListener('submit', function(event) {
					if (!form.checkValidity()) {
						event.preventDefault()
						event.stopPropagation()
					}

					form.classList.add('was-validated')
				}, false)
			})
		})()
	</script>

</body>
</html>

<%
} else {
response.sendRedirect("../index.jsp?error=sesionNoIniciada");
}
%>