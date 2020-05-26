package ec.edu.ups.est.controlador;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.est.dao.DAOGuia;
import ec.edu.ups.est.dao.TelefonoDAO;
import ec.edu.ups.est.dao.UsuarioDAO;
import ec.edu.ups.est.modelo.Telefono;
import ec.edu.ups.est.modelo.Usuario;

/**
 * Servlet implementation class Telefono
 */
@WebServlet("/ControladorTelefono")
public class ControladorTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ControladorValidacionParametros control;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorTelefono() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		control = new ControladorValidacionParametros();
		String opcion = request.getParameter("accion");

		if(opcion.equals("crear_telefono")) {
			UsuarioDAO usuarioDAO = DAOGuia.getGuia().getUsuarioDAO();
			TelefonoDAO telefonoDAO = DAOGuia.getGuia().getTelefonoDAO();
			Telefono tel = null;
			String telefono11 = "";
			String tipo = request.getParameter("tipo");
			String operadora = request.getParameter("operadoras");
			String cc = request.getParameter("cc");

			telefono11 = request.getParameter("telefono");

			String validacionTelefono = "";
			Usuario usuario = usuarioDAO.read(cc);
			if(telefono11 == "") {
				validacionTelefono += "Por favor ingresar datos!";

			}
			if(!control.validarNumero(telefono11)) {
				request.setAttribute("er", telefono11);
				validacionTelefono += "Ingrese solo numeros";

			}
			if(tipo.equals("Celular") && telefono11.length()!=10 && telefono11 != "") {

				request.setAttribute("er", telefono11);
				validacionTelefono += "Numero de celular incorrecto!";
			}
			if(tipo.equals("Fijo") && telefono11.length()!=7 && telefono11 != "") {

				request.setAttribute("er", telefono11);
				validacionTelefono += "Numero de telefono fijo incorrecto!";
			}
			Usuario user = usuarioDAO.read(cc);
			List<Telefono> telefonos = telefonoDAO.findByUsuario(user); 
			for (Telefono telefono : telefonos) {
				if(telefono11.equals(telefono.getNumero())) { 

					request.setAttribute("er", telefono11);
					validacionTelefono += "Numero Existente";				
				}
			}

			if(validacionTelefono=="") {

				tel = new Telefono(telefono11, tipo, operadora, usuario);
				telefonoDAO.create(tel);
				usuario = usuarioDAO.read(cc);

				request.setAttribute("bien", "Se ha registrado exitosamente el Numero ");

				request.setAttribute("num", tel.getNumero());
			}

			telefonos.add(tel);
			
			usuario.setTelefonos(telefonos);

			request.getSession().setAttribute("usuario", usuario);
			System.out.println("holaBien" + usuario);

			request.setAttribute("validacionTelefono", validacionTelefono);

			request.getRequestDispatcher("/JSPs/CuentaPrincipal.jsp").forward(request, response);
		}

		if(opcion.equals("buscar_telefono")) {
			String telefono = request.getParameter("telefono");
			String validaciones = "";
			boolean ban = true;


			UsuarioDAO usuarioDAO = DAOGuia.getGuia().getUsuarioDAO();
			TelefonoDAO telefonoDAO = DAOGuia.getGuia().getTelefonoDAO();
			if(telefono == "") {
				ban=false;
				validaciones += "campo vacio";
				request.setAttribute("validacionTelefono", validaciones);
			}else {
				if(!control.validarNumero(telefono)) {
					validaciones += "Ingrese solamente numeros";
					request.setAttribute("validacionTelefono", validaciones);
					ban=false;
				}else {
					if(telefono.length() !=7 && telefono.length() !=10) {
						ban=false;
						validaciones += "Ingrese numero correcto";
						request.setAttribute("validacionTelefono", validaciones);

					}
				}
			}


			if(ban) {

				Telefono telFInal = null;
				if(telefonoDAO.read(telefono)!=null){
					telFInal = telefonoDAO.read(telefono);
					System.out.println("entra bien");
					request.setAttribute("datosTelefono", "Datos Del Telefono");
					request.setAttribute("infoTelefono", "Telefono: ");
					request.setAttribute("infoTipo", "Tipo: ");
					request.setAttribute("infoOperadora", "Operadora: ");
					request.setAttribute("telefono", telFInal);

				}else {
					validaciones="No se ha encontrado nmumero";
					request.setAttribute("validacionTelefono", validaciones);
					System.out.println("Entra mal");
				}
			}


			request.getRequestDispatcher("/JSPs/ActualizarTelefono.jsp").forward(request, response);
		}

		if(opcion.equals("modificar_telefono")) {
			UsuarioDAO usuarioDAO = DAOGuia.getGuia().getUsuarioDAO();
			TelefonoDAO telefonoDAO = DAOGuia.getGuia().getTelefonoDAO();
			Telefono tel = null;
			String ttt = request.getParameter("telPar");
			HttpSession misession= (HttpSession) request.getSession();
			Usuario us= (Usuario) misession.getAttribute("usuario");
			String actualizar = request.getParameter("buscarTelefono");
			String elimina = request.getParameter("eliminar");
			String nuevoNumero = request.getParameter("telActualizar");
			String nuevoTipo = request.getParameter("operadoras");
			String validaciones = "";
			boolean ban = true;

			if(nuevoNumero == "") {
				ban=false;
				validaciones += "campo vacio";
				request.setAttribute("validacionTelefonoActualizar", validaciones);
			}else {
				if(!control.validarNumero(nuevoNumero)) {
					validaciones += "Ingrese solamente numeros";
					request.setAttribute("validacionTelefonoActualizar", validaciones);
					ban=false;
				}else {
					if(nuevoNumero.length() !=7 && nuevoNumero.length() !=10) {
						ban=false;
						validaciones += "Ingrese numero correcto";
						request.setAttribute("validacionTelefonoActualizar", validaciones);

					}
				}
			}



			if(actualizar != null && ban == true) {
				Telefono telFInal = null;
				if(nuevoNumero.equals(ttt)) {
					Telefono tele = telefonoDAO.read(nuevoNumero);
					tele.setNumero(nuevoNumero);
					tele.setOperadora(nuevoTipo);
					tele.setUsuario(us);
					telefonoDAO.update(tele);
					request.setAttribute("valOk", "Actualizado el numero " + tele.getNumero());
				}else {
					Telefono tele = telefonoDAO.read(ttt);
					tele.setNumero(nuevoNumero);
					tele.setOperadora(nuevoTipo);
					tele.setUsuario(us);
					telefonoDAO.update(tele);
					request.setAttribute("valOk", "Actualizado el numero " +nuevoNumero);
				}
			}

			if(elimina != null && ban == true) {
				Telefono telFInal = null;
				System.out.println("entro a eliminar");
				if(telefonoDAO.read(nuevoNumero)!=null) {
					telFInal = telefonoDAO.read(nuevoNumero);
					telefonoDAO.delete(telFInal);
					request.setAttribute("valOk", "Eliminado el numero " + nuevoNumero);
				}else {
					validaciones += "No existe el numero ingresado";
					request.setAttribute("validacionTelefonoActualizar", validaciones);
				}
			}

			List<Telefono> telefonos = telefonoDAO.findByUsuario(us);
			us.setTelefonos(telefonos);
			request.getSession().setAttribute("usuario", us);
			request.getRequestDispatcher("/JSPs/ActualizarTelefono.jsp").forward(request, response);

		}


	}
}
