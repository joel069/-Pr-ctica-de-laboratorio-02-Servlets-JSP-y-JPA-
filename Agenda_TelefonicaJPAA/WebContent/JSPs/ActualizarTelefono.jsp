
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar Telefono</title>
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
	<header>


		<C:set var="u" value="${requestScope['usuario']}" />
		<C:set var="usu" value="${sessionScope['usuario']}" />
		<C:set var="telefono" value="${requestScope['telefono']}" />

		<!--Cabecera-->
		<header>

			<!-- Navbar -->
			<nav
				class="navbar navbar-expand-lg navbar-dark griss row scrolling-navbar fixed-top">

				<ul class="navbar-nav mr-auto"
					style="margin-left: 35px; font-size: 22px">
					<li class="active"><a
						href="/Agenda_TelefonicaJPAA/JSPs/CuentaPrincipal.jsp">Inicio</a></li>
				</ul>
				<!-- Search form -->
				<form class=" col-xs-8 col-sm-4 col-md-4 col-mg-4 mr-sm-4"
					id="formulario">

					<ul>
						<li class=" col-xs-8 col-sm-4 col-md-4 col-mg-4 mr-sm-4"
							class="btn  btn-block" style="font-size: 20px;"><a
							href="/Agenda_TelefonicaJPAA/JSPs/BuscarContacto.jsp"
							style="color: lightblue">BUSCAR </a></li>

					</ul>
				</form>

				<!-- Datos extras -->
				<form class=" nav navbar-nav nav-flex-icons ml-auto mr-sm-2">
					<a
						href="/Agenda_TelefonicaJPAA/ControladorSesion?salir=1"
						class="active" style="color:; font-size: 20px;"
						type="submit" name="accion" value="Salir"> CERRAR SESION </a>
				</form>

				</ul>
			</nav>
		</header>
		<!--Cabecera-->





	</header>

	<section class="our_skill">
		<div class="container">
			<div class="limiter">
				<div class="container-table100">



					<form
						action="/Agenda_TelefonicaJPAA/ControladorTelefono?accion=buscar_telefono"
						method="post" style="font-size: 20px;">

						<br></br> <br>
						<C:set var="texto1"
							value="${requestScope.infoTelefono}${telefono.numero}" />

						<C:set var="texto2"
							value="${requestScope.infoTipo}${telefono.tipo}" />

						<C:set var="texto3"
							value="${requestScope.infoOperadora}${telefono.operadora}" />
						<label for="telefono">Ingresar el Numero a Modificar:</label> <input
							type="tel" placeholder="Ingresar Numero" name="telefono"
							id="login-name" maxlength="10" value="${telefono.numero}"><input
							class="busq" type="submit"
							name="buscar" value="Buscar Telefono"
							style="border-radius: 25px; margin-top: 33px;">
						<p class="Gigan">${requestScope.datosTelefono}</p>



						<p class="Peq">${texto1}</p>
						<p class="Peq">${texto2}</p>
						<p class="Peq">${texto3}</p>
					</form>

					<form
						action="/Agenda_TelefonicaJPAA/ControladorTelefono?accion=modificar_telefono"
						method="post" style="margin-bottom: 25px;">


						<br>
						<br>
						<br>
						<label style="font-size: 20px;" for="telefono">Actualizar
							Numero </label> <input type="tel" name="telActualizar" id="login-name"
							maxlength="10" value="${telefono.numero}"
							style="font-size: 15px;"><label style="font-size: 20px;"
							class="hh" for="operadoras">Operadora:</label> <select
							id="operadoras" name="operadoras" style="font-size: 15px;">
							<option value="Claro">Claro</option>
							<option value="Movistar">Movistar</option>
							<option value="CNT">ETAPA</option>

						</select> 
						
						<input type="tel" name="telPar" id="login-name" maxlength="10"
							value="${telefono.numero}" style="visibility: hidden;"><input
							class="botonesac1" type="submit"
							name="buscarTelefono" value="Actualizar"
							
							style="border-radius: 25px; margin-top: 33px;"><input
							class="botonesac" type="submit"
							name="eliminar" value="Eliminar"
							style="border-radius: 25px; margin-top: 33px;">
					</form>

					<div class="wrap-table100">
						<div class="table100 ver1">


							<div class="wrap-table100-nextcols js-pscroll">
								<div class="table100-nextcols">

									<div
										style="color: black; font-size: larger; padding-top: 5px; padding-left: 5px;">
										${requestScope.valOk}</div>

									<table class="table">
										<thead class="while blue-text">
											<tr class="row100 head">
												<th scope="col" style="font-size: 20px;">Numero
													Telefonico</th>
												<th scope="col" style="font-size: 20px;">Tipo </th>
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

															<li style="font-size: 15px; color: red;"><a
																href="/Agenda_TelefonicaJPAA/JSPs/ActualizarTelefono.jsp"
																style="color: red">Actualizar</a></li>


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


	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/active.js"></script>


</body>
</html>