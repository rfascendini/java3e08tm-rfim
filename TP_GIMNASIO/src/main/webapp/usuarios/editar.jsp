
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
	/* usuario u = new usuario();
	DataUsuario du = new DataUsuario();
	String a = request.getSession().getAttribute("usuario_a_editar").toString();
	usuario u2 = new usuario();
	u2.setIdUsuario(Integer.parseInt(a));
	u = du.seleccionarPorID(u2); */
	
	// RESULTADO FINAL DEBE SER
	usuario u = (usuario) request.getSession().getAttribute("usuario_a_editar");
	// NOTA: "usuario_a_editar" DEBE SER UN OBJETO.
	
	// CON ESTO LEEMOS SI ESTAMOS EDITANDO UN USUARIO O CREANDO UNO NUEVO PARA PASAR EL VALOR AL ACTION
	String accion = this.getClass().getSimpleName().replaceFirst("_jsp","").toString()+"Usuario";
	
	%>

	<div class="container my-5">
	

		<div class="container bg-white shadow-xl">
			<form class="needs-validation was-validated p-1" action="editarUsuario" method="post">
				<div class="row g-3 mt-3">

					<input type="hidden" name="idUsuario" value="<%=u.getIdUsuario()%>">
					<input type="hidden" name="accion" value="editar">
					
					<div class="col-12">
						<label for="tipoUsuario" class="form-label">TIPO DE USUARIO</label> 
						<select class="form-control" name="tipoUsuario" id="tipoUsuario" required>
							<option disabled>Seleccione una opción...</option>
							<option value="Profesor" <% if(u.getTipoUsuario().equals("Profesor")) { out.println("selected"); } %>>Profesor</option>
							<option value="Cliente" <% if(u.getTipoUsuario().equals("Cliente")) { out.println("selected"); } %>>Cliente</option>
							<option value="Administrativo" <% if(u.getTipoUsuario().equals("Administrativo")) { out.println("selected"); } %>>Administrativo</option>
							<option value="Admin" <% if(u.getTipoUsuario().equals("Admin")) { out.println("selected"); } %>>Supervisor</option>
						</select>
						<div class="invalid-feedback">Se requiere un TIPO DE USUARIO válido</div>
					</div>
				
					<div class="col-md-6 col-lg-3">
						<label for="nombre" class="form-label">NOMBRE</label> 
						<input type="text" class="form-control" name="nombre" id="nombre" placeholder="" value="<%=u.getNombre()%>" required>
						<div class="invalid-feedback">Se requiere un NOMBRE válido</div>
					</div>
	
					<div class="col-md-6 col-lg-3">
						<label for="lastName" class="form-label">APELLIDO</label> 
						<input type="text" class="form-control" name="apellido" id="apellido" placeholder="" value="<%=u.getApellido()%>" required>
						<div class="invalid-feedback">Se requiere un APELLIDO válido</div>
					</div>
	
					<div class="col-md-4 col-lg-2">
						<label for="fechaNacimiento" class="form-label">FEC. NAC.</label>
						<input type="date" class="form-control" name="fechaNacimiento" id="fechaNacimiento" placeholder="" value="" >
						<div class="invalid-feedback">Se requiere una FECHA NAC. válida</div>
					</div>
	
					<div class="col-md-4 col-lg-2">
						<label for="dni" class="form-label">DNI</label> 
						<input type="text" class="form-control" name="dni" id="dni" placeholder="" value="<%=u.getDni()%>" required>
						<div class="invalid-feedback">Se requiere un DNI válido</div>
					</div>
					
					<div class="col-md-4 col-lg-2">
						<label for="sexo" class="form-label">SEXO</label> 
						<select class="form-select" id="sexo" name="sexo">
							<option value="" disabled>Seleccione...</option>
							<option value="F" <% if(u.getSexo().equals("F"))  { out.print("selected"); } %>>Femenino</option>
							<option value="M" <% if(u.getSexo().equals("M"))  { out.print("selected"); } %>>Masculino</option>
							<option value="O" <% if(u.getSexo().equals("O")) { out.print("selected"); } %>>Otro</option>
						</select>
						<div class="invalid-feedback">Se requiere un SEXO</div>
					</div>
					
					<div class="col-md-12 col-lg-3">
						<label for="password" class="form-label">PASSWORD</label> 
						<input type="text" class="form-control" name="password" id="password" value="<%=u.getPassword()%>" placeholder="" required>
						<div class="invalid-feedback">Se requiere un PASSWORD válido</div>
					</div>
						
					<div class="col-md-6 col-lg-3">
						<label for="domicilio" class="form-label">DOMICILIO</label> 
						<input type="text" class="form-control" name="domicilio" id="domicilio" placeholder="" value="<%=u.getDomicilio()%>" required>
						<div class="invalid-feedback">Se requiere un DOMICILIO válido</div>
					</div>
	
					<div class="col-md-6 col-lg-3">
						<label for="telefono" class="form-label">TELÉFONO</label> 
						<input type="text" class="form-control" name="telefono" id="telefono" placeholder="" value="<%=u.getTelefono()%>" required>
						<div class="invalid-feedback">Se requiere un TELÉFONO válido</div>
					</div>

					<div class="col-md-12 col-lg-3">
						<label for="email" class="form-label">EMAIL</label> 
						<input type="email" class="form-control" name="email" id="email" placeholder="" value="<%=u.getEmail()%>" required>
						<div class="invalid-feedback">Se requiere un EMAIL válido</div>
					</div>
	

					
				</div>

				<div class="mt-5 mb-2">
					<button class="w-100 btn btn-success btn-lg" type="submit">GUARDAR</button>
				</div>
				
			</form>
		</div>
		
		
		<div class="text-center mt-5">
				<a href="<%=request.getContextPath()%>/usuarios/listar" class="btn btn-danger btn-lg">VOLVER</a>
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