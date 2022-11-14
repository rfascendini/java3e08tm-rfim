
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
<title>Nuevo Horario Actividad</title>

</head>
<body class="bg-info">

	<jsp:include page="../header.jsp" />
	

	<div class="container mt-5">
	
		<%
		
		if(request.getParameter("idActividad") == null) {
		
		 %>

		<div class="container bg-white shadow-xl">
			<form class="needs-validation was-validated p-1" action="" id="form1" method="post">
				<div class="row g-3">
				
					<input type="hidden" name="accion" value="nuevo">
					
					<!-- ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD  -->
					<div class="col-12">
						<% 
						CtrlActividad ctrlActividad = new CtrlActividad();
						LinkedList<actividad> actividades = ctrlActividad.listarActividades();
						%>
						<label for="idActividad" class="form-label">ACTIVIDAD</label> 
						<select class="form-control" name="idActividad" id="form1" required>
							<option value="" selected disabled>Seleccione una opción...</option>
							<% for(actividad a : actividades) { %>
								<option value="<%=a.getIdActividad()%>"><%=a.getNombre() %></option>
							<% } %>
						</select>
						<div class="invalid-feedback">Se requiere una ACTIVIDAD válido</div>
					</div>
					<!-- ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD ACTIVIDAD  -->
				
					

					<!-- PROFESORES  PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES -->
					<% if(request.getSession().getAttribute("tpjava_usuario_tipoUsuario").equals("Admin") || request.getSession().getAttribute("tpjava_usuario_tipoUsuario").equals("Administrativo")) { %>
					<div class="col-12">
						<label for="idUsuario" class="form-label">CLIENTE</label>
						
						<% 
						CtrlUsuario ctrlUsuario = new CtrlUsuario();
						LinkedList<usuario> usuarios = ctrlUsuario.listarUsuarios("Cliente");
						%>
						
						<select class="form-control" name="idUsuario" id="idUsuario" required>
							<option value="" selected disabled>Seleccione una opción...</option>
							<% for(usuario u : usuarios) { %>
								<option value="<%=u.getIdUsuario()%>"><%=u.getApellido()+", "+u.getNombre()%> </option>
							<% } %>
						</select>
						<div class="invalid-feedback">Se requiere un CLIENTE válido</div>
					</div>
					<!-- PROFESORES  PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES PROFESORES -->
					<% } else if(request.getSession().getAttribute("tpjava_usuario_tipoUsuario").equals("Cliente")) { %>
						<input type="hidden" name="idUsuario" value="<%=request.getSession().getAttribute("tpjava_usuario_idUsuario") %>">
					<% } %>
					
				</div>
	
				<div class="mt-5 mb-2">
				<button class="w-100 btn btn-success btn-lg" type="submit" value="1" form="form1">SIGUIENTE</button>
				</div>
			</form>
		</div>
		
		<% } %>
		
		
		<%
		
		if(request.getParameter("idActividad") != null) {
		
		 %>
		 
		<div class="container bg-white shadow-xl mt-5">
		
			<form class="needs-validation was-validated p-1" action="nuevoHAC" method="post" id="form2">
			
				<input type="hidden" name="accion" value="nuevo">
			
				<div class="row g-3">
				
						<input class="form-control" name="idUsuario" type="hidden" value="<%=request.getParameter("idUsuario") %>">
				
					<div class="col-12">
						<% 
						CtrlHA ctrlHA = new CtrlHA();
						LinkedList<horarioActividad> has = ctrlHA.listarHAporActividad(Integer.parseInt(request.getParameter("idActividad")));
						%>
						<label for="idHA" class="form-label">HORARIO ACTIVIDAD</label> 
						<select class="form-control" name="idHA" id="idHA" required>
							<option value="" selected disabled>Seleccione una opción...</option>
							<%  for(horarioActividad ha : has) { %>
								 <option value="<%=  ha.getIdHA()%>"><%=  ha.getActividad().getNombre()+" - "+ha.getDia()+" - "+ha.getHoraComienzo()+" hs A "+ha.getHoraFin()+" hs" %></option>
							<%  } %>
						</select>
						<div class="invalid-feedback">Se requiere un HORARIO ACTIVIDAD válido</div>
					</div>
				
				</div>
	
				<div class="mt-5 mb-2">
				<button class="w-100 btn btn-success btn-lg" type="submit" form="form2">GUARDAR</button>
				</div>
			</form>
		</div>
		
		<% } %>
		
		
		
		
		
		
		<div class="text-center mt-5">
				<a href="<%=request.getContextPath()%>/usuarios/listar" class="btn btn-danger btn-lg">VOLVER</a>
		</div>

	</div>

	<jsp:include page="../footer.jsp" />


	<!-- JavaScript -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js" integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
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