<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
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

<h1>Ha ocurrido un error</h1>
<h3>
    <a href="home">volver al inicio</a>
</h3>
</body>
</html>