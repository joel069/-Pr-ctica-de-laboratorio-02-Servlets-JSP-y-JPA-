package ec.edu.ups.est.controlador;

import java.io.IOException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.est.dao.DAOGuia;
import ec.edu.ups.est.dao.TelefonoDAO;
import ec.edu.ups.est.dao.UsuarioDAO;
import ec.edu.ups.est.modelo.Telefono;
import ec.edu.ups.est.modelo.Usuario;

/**
 * Servlet implementation class LlenarTabla
 */
@WebServlet("/ControladorBuscarContacto")
public class ControladorBuscarContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ControladorValidacionParametros control;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorBuscarContacto() {
		ControladorValidacionParametros control = null;
		
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
		
		control = new ControladorValidacionParametros();
		String name = request.getParameter("opcion");
		String parametro = request.getParameter("parametro");

		UsuarioDAO usuarioDAO = DAOGuia.getGuia().getUsuarioDAO();
		boolean bandera = true;
		Usuario usuario = null;
		if(parametro == "") {
			String error = "Por favor, ingrese un dato";
			request.setAttribute("error", error);
			bandera = false;
		}

		if(name.equals("cedula") && bandera) {	
			if(control.validadorDeCedula(parametro)) {
				System.out.println("Correcto");
				
				
				if(usuarioDAO.read(parametro)==null) {
					String error = "Usuario no encontrado";

					request.setAttribute("error", error);

					request.setAttribute("parInval", parametro);
				}else {
					usuario = usuarioDAO.read(parametro);
					request.setAttribute("usuario", usuario);

					request.setAttribute("titulo","Informacion del usuario a buscar:");
					request.setAttribute("nn", "Nombre: ");
					request.setAttribute("cc", "Cedula: ");
					request.setAttribute("crr", "Correo: ");
				}
			}else{
				String error = "Cedula incorrecta";
				request.setAttribute("error", error);

				request.setAttribute("parInval", parametro);
			}

		}else if(name.equals("correo") && bandera){


			if(control.validadorDeCorreo(parametro)) {
				
				request.setAttribute("usuario", usuario);

				if(usuarioDAO.readByAddress(parametro)== null) {
					String error = "Usuario no encontrado";

					request.setAttribute("error", error);
					request.setAttribute("parInval", parametro);
				}
				else {

					usuario = usuarioDAO.readByAddress(parametro);
					request.setAttribute("usuario", usuario);

					request.setAttribute("titulo","Informacion del usuario a buscar:");
					request.setAttribute("nn", "Nombre: ");
					request.setAttribute("cc", "Cedula: ");
					request.setAttribute("crr", "Correo: ");
				}
			}else {
				String error = "Correo incorrecto";
				request.setAttribute("error", error);

				request.setAttribute("parInval", parametro);
			}
		}

		request.getRequestDispatcher("JSPs/BuscarContacto.jsp").forward(request, response);
	}

}
