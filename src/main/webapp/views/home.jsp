<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.edutecno.model.Libro"%>
<%@page import="com.edutecno.vo.LibroVO"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="charset=ISO-8859-1">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet"
          href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css" />
    <title>Booklet</title>
</head>
<body>
	<!-- Inicio Header -->
	<nav class="navbar navbar-dark bg-dark">
			<div class="container">
				<a class="navbar-brand" href="/home">Biblioteca Booklet</a>
				<div class="navbar">
					<div class="navbar-nav">
						<form action="handleLogout" class="form-inline" method="POST">
							<a class="nav-item nav-link disabled mr-sm-2" href="#" tabindex="-1" aria-disabled="true"></a> 
								<input type="submit" class="btn btn-outline-danger my-2 my-sm-0" name="btnEnviar" value="logout">
						</form>
					</div>
				</div>
			</div>
		</nav>
	<!-- Fin Header -->

<!-- Inicio Contenido -->
	<div class="mt-5 p-3">

	    <!-- Inicio Mensajes -->
	    <c:if test="${mensaje != null ? true : false}">
	        <div class="alert alert-secondary alert-dismissible fade show"
	             role="alert">${mensaje}
	            <button type="button" class="close" data-dismiss="alert"
	                    aria-label="Close">
	                <span aria-hidden="true">&times;</span>
	            </button>
	        </div>
	    </c:if>
	    <!-- Fin Mensajes -->
	
	    <!-- Boton agregar usuario -->
	    <!-- <a href="agregarForm" class="btn m-2 btn-success">Agregar libro</a> -->
	
		<div class="container-fluid p-5">
		    <form method="POST" action="buscar">
		        <table class="float-right">
		            <tr>
		            	<td><a href="agregarForm" class="btn m-2 btn-success">Agregar libro</a></td>
		                <td class="p-2"><label for="imprenta">Buscador:</label></td>
		                <td>
		                	<input class="form-control" type="text" placeholder="Buscador" name="textoBuscado" />
		                </td>
		                <td colspan="2">
		                	<input type="submit" class="btn m-2 btn-primary" value="Buscar" /></td>
		            </tr>
		        </table>
		    </form>
	    </div>
	
	    <!-- Inicio Tabla -->
	    <div class="container-fluid mt-5 p-5 text-center">
		    <table border="1" class="table table-hover">
		        <thead class="thead-dark">
		        <tr>
		            <th class="col-2" scope="col">Título</th>
		            <th class="col-2" scope="col">Autor</th>
		            <th class="col-1" scope="col">Imprenta</th>
		            <th class="col-1" scope="col">Año</th>
		            <th class="col-1" scope="col">Disponibilidad</th>
		            <th class="col-3" scope="col">Acciones</th>
		        </tr>
		        </thead>
		        <tbody>
		        <c:forEach items="${VO.listaLibros}" var="u">
		            <tr>
		                <td>${u.getTitulo()}</td>
		                <td>${u.getAutor()}</td>
		                <td>${u.getImprenta()}</td>
		                <td>${u.getAnio()}</td>
		                <td>${u.getDisponible() == 1 ? 'Si' : 'No'}</td>
		
		                <td>
		                <a href="cambiarDisponibilidad?idLibro=${u.getIdLibro()}"class="btn btn-warning btn-sm">Cambiar Disponibilidad</a>
		                <a href="editarForm?idLibro=${u.getIdLibro()}" class="btn btn-primary btn-sm">Editar</a> 
		                <a href="eliminar?idLibro=${u.getIdLibro()}" class="btn btn-danger btn-sm">Eliminar</a></td>
		            </tr>
		        </c:forEach>
		
		        </tbody>
		    </table>
		    <!-- Fin tabla -->
	    </div>
	</div>
	

<!-- Fin Contenido -->
</body>
</html>