
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
<title>Editar Cuota</title>

</head>
<body class="bg-info">

	<jsp:include page="../header.jsp" />
	
	<% cuota c = (cuota) request.getSession().getAttribute("cuota_a_editar"); %>

	<div class="container mt-5">

		<div class="container bg-white shadow-xl">
			<form class="needs-validation was-validated p-1" action="editarCuota" method="post">
				<div class="row g-3">
				
					<input type="hidden" name="accion" value="editar">
					<input type="hidden" name="idCuota" value="<%=c.getIdCuota() %>">
					
					<div class="col-6 col-md-6 col-lg-3">
						<label for="horaFin" class="form-label">MES</label>
						<input type="text" class="form-control" value="<%=c.getMes() %>" readonly>
					</div>
					
					<div class="col-6">
						<label for="horaFin" class="form-label">AÑO</label>
						<input type="text" class="form-control" value="<%=c.getAnio() %>" readonly>
					</div>
					
					<div class="col-12 col-md-6 col-lg-3">
						<label for="horaFin" class="form-label">MONTO CUOTA</label>
						<input type="number" class="form-control" name="monto" id="monto" value="<%=c.getMonto() %>" required>
						<div class="invalid-feedback">Se requiere un MONTO válido</div>
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
	request.getSession().setAttribute("action_result_status", "sesionNoIniciada");
	request.getSession().setAttribute("action_result_message", "Debe iniciar sesión para continuar...");
	response.sendRedirect("../index.jsp");
}
%>