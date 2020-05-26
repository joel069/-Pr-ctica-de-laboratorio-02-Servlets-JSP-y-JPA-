
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Cuenta</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link href="../css/createAccount.css" rel="stylesheet" type="text/css" />
</head>
<body>

<!--Cabecera-->
	<nav
		class="navbar navbar-expand-lg navbar-dark gris row scrolling-navbar fixed-top">
		<div class="collapse navbar-collapse ">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a href="../index.html" class="nav-link"
					style="color: black;">
						<span class="clearfix d-none d-sm-inline-block">PAGINA PRINCIPAL</span></a></li>
			</ul>
		</div>
	</nav>
	<!--Cabecera-->

<div class="container col-lg-4">
		<form action="/Agenda_TelefonicaJPAA/ControladorRegistrar" method="post">
			<!-- /Practica_de_laboratorio_02_Servlets_JSP_y_JSP/Registro -->

			<input class="form-control" type="hidden" name="registro"
				value="registro">

			<div class="form-group text-center">
		
				<p>
					<strong>CREAR CUENTA</strong>
				</p>
			</div>


			<div class="form-group">
				 <label>CEDULA </label> <input 
				 type="text" id="identificacion" name="cedula" value="${cedula}" placeholder="Cedula"  class="form-control" />
								
			</div>


			<div class="form-group">
				<div class="form-group">
					<!-- First name -->
					<label>NOMBRE</label> <input 
					type="text" id="nombre" name="nombre" value="${nombre}" placeholder="Nombre" class="form-control" />
								
								
					
					
				</div>
				<div class="form-group">
					<!-- Last name -->
					 <label>APELLIDO</label><input 
					 type="text" id="apellido" name="apellido" value="${apellido}" placeholder="Apellido" class="form-control" />
				</div>
			</div>


			<div class="form-group">
				<label>	CORREO</label> </label> <input
					type="email" id="email" name="email" value="${correo}" placeholder="Correo"  class="form-control" />
			</div>


			<div class="form-group">
				 <label>CONTRASEÑA</label> <input 
				 type="password" id="password" name="password" value="${pass}"placeholder="Contraseña" class="form-control"/>
			</div>
			
			<div class="form-group">
			<label for="password">CONFIRMAR CONTRASEÑA</label><input
				type="password" id="confirma" name="confirma" value="${confirma}" placeholder="Contraseña" class="form-control" />
			
			</div>
			
			<br /> <input class="btn btn-primary btn-large btn-block"
								type="submit" name="Ingresar" value="Registrarse" /> 
				
				
		



		</form>
	</div>




	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
		
	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/active.js"></script>


</body>
</html>