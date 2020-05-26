package ec.edu.ups.est.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.est.dao.DAOGuia;
import ec.edu.ups.est.dao.UsuarioDAO;
import ec.edu.ups.est.modelo.Usuario;

/**
 * Servlet implementation class Registrar
 */
@WebServlet("/ControladorRegistrar")
public class ControladorRegistrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ControladorValidacionParametros control;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorRegistrar() {
		super();
		ControladorValidacionParametros control = null;
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = null;
		doGet(request, response);

		control = new ControladorValidacionParametros();
		String url = "";
		url = "/JSPs/Registrar.jsp";
		UsuarioDAO usuarioDAO = DAOGuia.getGuia().getUsuarioDAO();

		Usuario usu = null;
		boolean ci = false;
		boolean no = false;
		boolean ap = false;
		boolean co = false;
		boolean pa = false;
		boolean paw = false;
		boolean iguales = false;
		


		String cedula = request.getParameter("cedula");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("email");
		String pass = request.getParameter("password");
		String confirma = request.getParameter("confirma");


		String validacionesCedula = "";
		String validacionesNombre = "";
		String validacionesApellido = "";
		String validacionesCorreo = "";
		String validacionesPassw = "";
		String validacionesPasswConf = "";

		if(cedula.equals("")) 
			validacionesCedula += "La cedula esta vacia";
		else {
			if (control.validadorDeCedula(cedula)){
				ci = true;
			}else
				validacionesCedula += "La cedula es incorrecta";
		}


		if(nombre.equals("")) 
			validacionesNombre += "El nombre esta vacio";
		else {
			if(control.validarTexto(nombre)) {
				no = true;
			}else {

				validacionesNombre += "Ingrese solo letras";


			}


		}



		if(apellido.equals("")) 
			validacionesApellido += "El apellido esta vacio";
		else {
			if(control.validarTexto(apellido)) {
				ap = true;
			}else {

				validacionesApellido += "Ingrese solo letras";

			}


		}

		if(correo.equals("")) 
			validacionesCorreo += "El correo esta vacio";
		else{
			co = true;

		}

		if(pass.equals("")) 
			validacionesPassw += "La contraseña esta vacia";
		else {
			if (pass.length() >= 8) { 

				boolean espacios = false;
				boolean banMayus = false;
				boolean banMinus = false;
				for (int i = 0; i < pass.length(); i++) {
					char codigo = pass.charAt(i);
					if(codigo > 64 && codigo < 91 && !banMayus) { 
						banMayus= true;

					}
					else if(codigo > 96 && codigo < 123 && !banMinus) {
						banMinus = true;

					}else if(codigo == 255) {
						espacios = true;
					}
				}

				if (espacios)
					validacionesPassw += "<br>La contraseña no puede contener espacios en blanco";
				if (!banMayus)
					validacionesPassw += "<br>Debe Contener una mayuscula";

				if (!banMinus)

					validacionesPassw += "<br>Debe contener una minuscula";
			} else {

				validacionesPassw += "<br>Contraseña debe tener minimo 8 caracteres";
			}

		}

		if(confirma.equals("")) 
			validacionesPasswConf += "Confirmacion vacia";
		else {
			if (confirma.length() >= 8) { 

				boolean espacios = false;
				boolean banMayus = false;
				boolean banMinus = false;
				for (int i = 0; i < confirma.length(); i++) {
					char codigo = confirma.charAt(i);
					if(codigo > 64 && codigo < 91 && !banMayus) { 
						banMayus= true;

					}
					else if(codigo > 96 && codigo < 123 && !banMinus) {
						banMinus = true;

					}else if(codigo == 255) {
						espacios = true;
					}
				}

				if (espacios)
					validacionesPasswConf += "<br>La contraseña no puede contener espacios en blanco";
				if (!banMayus)
					validacionesPasswConf += "<br>Debe Contener una mayuscula";

				if (!banMinus)

					validacionesPasswConf += "<br>Debe contener una minuscula";
			} else {

				validacionesPasswConf += "<br>Contraseña debe tener minimo 8 caracteres";
			}
		}


		if(validacionesPassw.equals(""))
			pa = true;

		if(validacionesPasswConf.equals(""))
			paw = true;

		if(pa && paw) {
			if(pass.equals(confirma)) 
				iguales = true;
			else {
				validacionesPasswConf ="Las contraseñas no coinciden";
			}
		}

		if(ci && no && ap && co && pa && paw && iguales) {

			boolean ok = true;
			List<Usuario> usuarios = usuarioDAO.find();

			for (Usuario usuario : usuarios) {
				if(cedula.equals(usuario.getCedula())) {
					ok = false;
					validacionesCedula = "Cedula registrada actualmente!";

				}
				if(cedula.equals(usuario.getCorreo())) {
					ok = false;
					validacionesCorreo = "Correo registrado actualmente!";
				}
			}
			if(ok) {
				usu = new Usuario(cedula, nombre, apellido, correo, pass);
				usuarioDAO.create(usu);
				session = request.getSession(true); 

				session.setAttribute("accesos", 1); 
				session.setAttribute("usuario", usu);

				System.out.println(usu);
				url = "/JSPs/IniciarSesion.jsp";

			}

		}




		request.setAttribute("cedula", cedula);
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellido", apellido);
		request.setAttribute("correo", correo);
		request.setAttribute("pass", pass);
		request.setAttribute("confirma", confirma);

		request.setAttribute("Usuario", usu);
		request.setAttribute("validacionesCedula", validacionesCedula);
		request.setAttribute("validacionesNombre", validacionesNombre);
		request.setAttribute("validacionesApellido", validacionesApellido);
		request.setAttribute("validacionesCorreo", validacionesCorreo);
		request.setAttribute("validacionesPassw", validacionesPassw);
		request.setAttribute("validacionesPasswConf", validacionesPasswConf);
		request.getRequestDispatcher(url).forward(request, response);







	}



}
