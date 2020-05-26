 package ec.edu.ups.jpa;


import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DaoTelefono;
import ec.edu.ups.dao.DaoUsuario;

public class JPADAOFactory extends DAOFactory {

	@Override
	public DaoUsuario getUsuarioDAO() {
		return new JPAUserDAO();
	}

	@Override
	public DaoTelefono getTelefonoDAO() {
		return new  JPATelefonoDAO();
	}

	
	

}
