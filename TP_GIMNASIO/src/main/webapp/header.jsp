<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
  <div class="container-fluid d-flex justify-content-between">
  	<div>
    <a class="navbar-brand" href="request.getContextPath()/menu.jsp">INICIO</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    </div>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">


        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Actividades
          </a>
          <ul class=" dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Nuevo</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/actividades/listar">Listar</a></li>
          </ul>
        </li>
        
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Horarios Actividades
          </a>
          <ul class=" dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Nuevo</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/ha/listar">Listar</a></li>
          </ul>
        </li>
        
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Usuarios
          </a>
          <ul class=" dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/usuarios/nuevo">Nuevo</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><p class="text-info m-0" style="padding: 0.25rem 1rem">Listar</p></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/usuarios/listarUsuarios">Admin</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/usuarios/listarAdministrativos">Administrativos</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/usuarios/listarClientes">Clientes</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/usuarios/listarProfesores">Profesores</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/usuarios/listar">TODOS</a></li>
            
          </ul>
        </li>
        
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Cuotas
          </a>
          <ul class=" dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Registrar Pago</a></li>
          </ul>
        </li>
        
      </ul>
      
      
      <div class="d-flex" style="align-items: center">
      	<h5 class="text-white mb-0 me-2">Hola, <%=request.getSession().getAttribute("tpjava_usuario_nombre") + " "+ request.getSession().getAttribute("tpjava_usuario_apellido")%>!</h5>
		<!-- <a href="../index.jsp?estado=2" class="btn btn-primary">Salir</a> -->
		<a href="<%=request.getContextPath()%>/Logout" class="btn btn-primary">Salir</a>
      </div>
      
      
      
    </div>
  </div>
</nav>