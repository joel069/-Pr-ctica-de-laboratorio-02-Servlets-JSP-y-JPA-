package ec.edu.ups.jpa;


import java.util.List;

import ec.edu.ups.dao.DaoUsuario;
import ec.edu.ups.modelo.user;


public class JPAUserDAO extends JPAGenericDAO<user, String> implements DaoUsuario {
    
    public JPAUserDAO() {
	super(user.class);
    }

	@Override
	public user findPrsona(String correo, String contrasena) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<user> findByIdOrMail(String context) {
		// TODO Auto-generated method stub
		return null;
	}
    
}

