package ec.edu.ups.est.dao;

import ec.edu.ups.est.modelo.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, String>{
	
	public abstract Usuario readByAddress(String id);
	
		

}
