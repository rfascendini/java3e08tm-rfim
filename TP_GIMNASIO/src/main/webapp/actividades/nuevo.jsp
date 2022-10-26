
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
<title>Editar Actividad</title>

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

	<%
	// CON ESTO LEEMOS SI ESTAMOS EDITANDO UN USUARIO O CREANDO UNO NUEVO PARA PASAR EL VALOR AL ACTION
	String accion = this.getClass().getSimpleName().replaceFirst("_jsp","").toString()+"Actividad";
	
	%>

	<div class="container my-5">
	

		<div class="container bg-white shadow-xl" style="max-width:568px">
			<form class="needs-validation was-validated p-1" action="nuevoActividad" method="post">
				<div class="row g-3 mt-3">

					<input type="hidden" name="accion" value="nuevo">
				
					<div class="col-12">
						<label for="nombre" class="form-label">NOMBRE</label> 
						<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese el nombre de la Actividad..." required>
						<div class="invalid-feedback">Se requiere un NOMBRE válido</div>
					</div>
	
					<div class="col-12">
						<label for="descripcion" class="form-label">DESCRIPCIÓN</label> 
						<textarea class="form-control" name="descripcion" id="descripcion" rows="10" placeholder="Ingrese la descripción de la actividad (opcional)..."></textarea>
						<div class="invalid-feedback">Se requiere una DESCRIPCIÓN válido</div>
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