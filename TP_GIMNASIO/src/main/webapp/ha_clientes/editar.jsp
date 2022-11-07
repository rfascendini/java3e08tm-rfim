
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
<title>Editar Horario Actividad</title>

</head>
<body class="bg-info">

	<jsp:include page="../header.jsp" />
	
	<% horarioActividad ha = (horarioActividad) request.getSession().getAttribute("ha_a_editar"); %>

	<div class="container mt-5">

		<div class="container bg-white shadow-xl">
			<form class="needs-validation was-validated p-1" action="editarHA" method="post">
				<div class="row g-3">
				
					<input type="hidden" name="accion" value="editar">
					<input type="hidden" name="idHA" value="<%=ha.getIdHA() %>">
					
					<!-- ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD  -->
					<div class="col-12">
						<% 
						CtrlActividad ctrlActividad = new CtrlActividad();
						LinkedList<actividad> actividades = ctrlActividad.listarActividades();
						%>
						<label for="idActividad" class="form-label">ACTIVIDAD</label> 
						<select class="form-control" name="idActividad" id="idActividad" required>
							<% for(actividad a : actividades) { %>
								<option value="<%=a.getIdActividad()%>" <% if(ha.getActividad().getIdActividad() == a.getIdActividad()) { out.println("selected"); } %>><%=a.getNombre() %></option>
							<% } %>
						</select>
						<div class="invalid-feedback">Se requiere una ACTIVIDAD válido</div>
					</div>
					<!-- ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD  -->
					

					<!-- PROFESORES  PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES -->
					<div class="col-12">
						<label for="idUsuario" class="form-label">PROFESOR</label>
						
						<% 
						CtrlUsuario ctrlUsuario = new CtrlUsuario();
						LinkedList<usuario> usuarios = ctrlUsuario.listarUsuarios("Profesor");
						%>
						
						<select class="form-control" name="idUsuario" id="idUsuario" required>
							<% for(usuario u : usuarios) { %>
								<option value="<%=u.getIdUsuario()%>" <% if(ha.getUsuario().getIdUsuario() == u.getIdUsuario()) { out.println("selected"); } %>><%=u.getApellido()+", "+u.getNombre()%> </option>
							<% } %>
						</select>
						<div class="invalid-feedback">Se requiere un PROFESOR válido</div>
					</div>
					<!-- PROFESORES  PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES -->
					
				
					<div class="col-md-6 col-lg-3">
						<label for="dia" class="form-label">DIA</label> 
						<select class="form-control" name="dia" id="dia" required>
							<option value="Lunes" <% if(ha.getDia().equals("Lunes")) { out.println("selected"); } %>>Lunes</option>
							<option value="Martes" <% if(ha.getDia().equals("Martes")) { out.println("selected"); } %>>Martes</option>
							<option value="Miercoles" <% if(ha.getDia().equals("Miercoles")) { out.println("selected"); } %>>Miercoles</option>
							<option value="Jueves" <% if(ha.getDia().equals("Jueves")) { out.println("selected"); } %>>Jueves</option>
							<option value="Viernes" <% if(ha.getDia().equals("Viernes")) { out.println("selected"); } %>>Viernes</option>
							<option value="Sabado" <% if(ha.getDia().equals("Sabado")) { out.println("selected"); } %>>Sabado</option>
						</select>
						<div class="invalid-feedback">Se requiere un DIA válido</div>
					</div>
	
					<div class="col-md-6 col-lg-3">
						<label for="cuposDisponibles" class="form-label">CUPOS DISP.</label> 
						<input type="number" class="form-control" name="cuposDisponibles" id="cuposDisponibles" value="<%=ha.getCuposDisponibles() %>">
						<div class="invalid-feedback">Se requiere un CUPO válido</div>
					</div>
	
					<div class="col-md-6 col-lg-3">
						<label for="horaComienzo" class="form-label">HORA COM.</label>
						<input type="time" class="form-control" name="horaComienzo" id="horaComienzo" value="<%=ha.getHoraComienzo() %>">
						<div class="invalid-feedback">Se requiere una HORA válida</div>
					</div>
					
					<div class="col-md-6 col-lg-3">
						<label for="horaFin" class="form-label">HORA FIN</label>
						<input type="time" class="form-control" name="horaFin" id="horaFin" value="<%=ha.getHoraFin() %>">
						<div class="invalid-feedback">Se requiere una HORA válida</div>
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