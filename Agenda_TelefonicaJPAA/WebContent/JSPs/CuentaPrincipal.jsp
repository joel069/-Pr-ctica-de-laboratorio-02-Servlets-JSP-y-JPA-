
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<C:set var="usu" value="${sessionScope['usuario']}" />
<title>${usu.nombre}${usu.apellido}</title>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	<!-- Optional theme -->
	<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
	<!-- Google Fonts -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
	<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
	<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.15.0/css/mdb.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap"
	rel="stylesheet">
<link
	href="/Agenda_TelefonicaJPAA/css/estilos.css"
	rel="stylesheet" type="text/css" />
<link
	href="/Agenda_TelefonicaJPAA/css/estilos.css"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link href="../css/estilos.css" rel="stylesheet" type="text/css" />

</head>
<body>


	<!--Cabecera-->
	<header>

		<!-- Navbar -->
		<nav
			class="navbar navbar-expand-lg navbar-dark griss row scrolling-navbar fixed-top">

			<ul class="navbar-nav mr-auto" 
				style="margin-left: 35px; font-size: 22px" >
				<li class="active"><a href="#" class="nav-link"
					style="color: black;" > <span
						class="clearfix d-none d-sm-inline-block"  >PERFIL</span></a></li>
			</ul>
			<!-- Search form -->
			<form class=" col-xs-8 col-sm-4 col-md-4 col-mg-4 mr-sm-4"
				id="formulario">

				<ul>
					<li class=" col-xs-8 col-sm-4 col-md-4 col-mg-4 mr-sm-4"
						class="btn  btn-block" style="font-size: 20px;"><a
						href="/Agenda_TelefonicaJPAA/JSPs/BuscarContacto.jsp" style="color: black">BUSCAR 
					</a></li>

				</ul>
			</form>





			<!-- Datos extras -->
			<form class=" nav navbar-nav nav-flex-icons ml-auto mr-sm-2">
				<a
					href="/Agenda_TelefonicaJPAA/ControladorSesion?salir=1"
					class="btn  btn-block" style="color: black; font-size: 20px;"
					type="submit" name="accion" value="Salir"> CERRAR SESION </a>
			</form>

			</ul>
		</nav>
	</header>
	<!--Cabecera-->






	<section>
		<div class="container">
			<div>
				<div>

					<form 
						action="/Agenda_TelefonicaJPAA/ControladorTelefono?accion=crear_telefono"
						method="post"
						style="margin-top: 60px; padding-top: 30px; width: 539px;" >


						<p>
							<b style="font-size: 30px;" > Ingresar Celular </b>
						</p>

						<br>
						<div class="form-group">
							<label style="font-size: 20px;" id="label-1">Cedula:</label> <input class="mi" type="tel"
								name="cc" id="hola" value="${usu.cedula}" style="font-size: 15px;">
						</div>
						<div class="form-group">
							<label style="font-size: 20px;" for="telefono">Ingresar Celular:</label> <input
								type="tel" name="telefono" id="login-name" maxlength="15"
								value="${requestScope.er}" style="font-size: 15px;">
						</div>

						
							<div class="form-group">
							<label style="font-size: 20px;" class="hh" for="operadoras">Operadora:</label> <select
								id="operadoras" name="operadoras" style="font-size: 15px;">
								<option value="Claro">Claro</option>
								<option value="Movistar">Movistar</option>
								<option value="CNT">Etapa</option>
					
							</select>

						</div>

						<div class="form-group">

							<label style="font-size: 20px;"class="hh" for="tipo">Tipo:</label> <select id="tipo"
								name="tipo" style="font-size: 15px;">
								<option value="Celular">Celular</option>
								<option value="Fijo">Fijo</option>

							</select>

						</div>


						<input style="font-size: 15px;" class="boton" type="submit" name="Ingresar"
							value="Registrar Telefono">
					</form>
					<div class="wrap-table100">
						<div class="table100 ver1">


							<div class="wrap-table100-nextcols js-pscroll">
								<div class="table100-nextcols">

									<div
										style="color: black; font-size: larger; padding-top: 5px; padding-left: 5px;">${requestScope.bien}:
										${requestScope.num}</div>

									<table class="table">
										<thead class="while blue-text">
											<tr>

												<th scope="col" style="font-size: 20px;">Numero</th>
												<th scope="col" style="font-size: 20px;">Tipo</th>
												<th scope="col" style="font-size: 20px;">Operadora</th>
												<th scope="col" style="font-size: 20px;">Acciones</th>
											</tr>
										</thead>

										<tbody>

											<C:forEach var="telefono" items="${usu.telefonos}">

												<tr class="row100 body">

													<td scope="col" style="font-size: 15px; color: black;"><a
														href="tel:${telefono.numero}">${telefono.numero}</a></td>

													<td scope="col" style="font-size: 15px; color: black;">${telefono.tipo}</td>
													<td scope="col" style="font-size: 15px; color: black;">${telefono.operadora}</td>
													<td>
														<ul>

															<li style="font-size: 15px;color: red;" ><a
																href="/Agenda_TelefonicaJPAA/JSPs/ActualizarTelefono.jsp" style= "color: red ">MODIFICAR
																	INFORMACION PERSONAL</a></li>


														</ul>
													</td>




												</tr>
											</C:forEach>

										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</section>
	
	
	<footer class="page-footer font-small rgba(63, 81, 181, 0.7) rgba-indigo-strong">

		<!-- Footer Links -->
		<div class="container text-center text-md-left">

			<!-- Grid row -->
			<div class="row">

				
				<!-- Grid column -->

				<hr class="clearfix w-100 d-md-none">


				<!-- Grid column -->

				<hr class="clearfix w-100 d-md-none">

				<!-- Grid column -->
				<div class="col-md-4 col-lg-3 mx-auto my-md-4 my-0 mt-4 mb-1">

					<!-- Contact details -->
					<h5 class="font-weight-bold text-uppercase mb-4">Contactanos</h5>

					<ul class="list-unstyled">
						<li>
							<p>
								<i ></i> Cuenca - Ecuador
							</p>
						</li>
						<li>
							<p>
								<a href="mailto:cuenta@deemail.com"><i
									"></i> fvasquezf1@est.ups.edu.ec 
							</p> </a>

						</li>
						
					</ul>

				</div>
				<!-- Grid column -->

				<hr class="clearfix w-100 d-md-none">

				<!-- Grid column -->
				<div class="col-md-2 col-lg-2 text-center mx-auto my-4 ">

					<!-- Social buttons -->
					<h5 class="font-weight-bold text-uppercase mb-4">Redes Sociales</h5>


					<!-- Facebook -->
					<a href="https://www.facebook.com/joel.vasquez.3133719"
						target="_black" class="fb-ic"> <i
						class="fab fa-facebook-f fa-lg white-text mr-md-5 mr-3 fa-2x">
					</i>
					</a>
					<!--Instagram-->
					<a href="https://www.instagram.com/joelv069/?hl=es-la" target="_black"
						class="ins-ic"> <i
						class="fab fa-instagram fa-lg white-text mr-md-5 mr-3 fa-2x"></i>

					
				</div>
				<!-- Grid column -->



			</div>
			<!-- Grid row -->

		</div>
		<!-- Footer Links -->

		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">
			© 2020 Copyright: <a href="https://mdbootstrap.com/"> Vasquez Fajardo Franklin Joel</a>
		</div>
		<!-- Copyright -->

	</footer>
	<!-- Footer -->
	

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<!-- JQuery -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.15.0/js/mdb.min.js"></script>
	<script src="js/funcion.js"></script>

	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/active.js"></script>


</body>
</html>