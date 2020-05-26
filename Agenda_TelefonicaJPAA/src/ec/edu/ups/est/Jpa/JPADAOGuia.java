package ec.edu.ups.est.Jpa;

import ec.edu.ups.est.dao.DAOGuia;
import ec.edu.ups.est.dao.TelefonoDAO;
import ec.edu.ups.est.dao.UsuarioDAO;

public class JPADAOGuia extends DAOGuia {

	

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new JPAUsuarioDAO();
	}

	@Override
	public TelefonoDAO getTelefonoDAO() {
		// TODO Auto-generated method stub
		return new JPATelefonoDAO();
	}
	

}
