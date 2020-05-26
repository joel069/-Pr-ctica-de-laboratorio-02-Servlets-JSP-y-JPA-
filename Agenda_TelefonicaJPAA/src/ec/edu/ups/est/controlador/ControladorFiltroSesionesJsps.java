package ec.edu.ups.est.controlador;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ControladorFiltroSesiones
 */
@WebFilter({"/JSPs/CuentaPrincipal.jsp", "/JSPs/ActualizarTelefono.jsp", "/JSPs/BuscarContacto.jsp"})
public class ControladorFiltroSesionesJsps implements Filter {

    /**
     * Default constructor. 
     */
    public ControladorFiltroSesionesJsps() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpSession sesion = ((HttpServletRequest) request).getSession(false);// don't create if it doesn't exist
		HttpServletRequest request1 = (HttpServletRequest) request; 
		if(sesion != null && !sesion.isNew()) {
			System.out.println("Bien");
		    chain.doFilter(request, response);
		} else {
			String login = request1.getContextPath() + "/JSPs/IniciarSesion.jsp";
			System.out.println("Mal");
		    ((HttpServletResponse) response).sendRedirect(login);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
