package ec.edu.ups.est.Jpa;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.ups.est.dao.UsuarioDAO;
import ec.edu.ups.est.modelo.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO{

	public JPAUsuarioDAO() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario readByAddress(String id) {
		// TODO Auto-generated method stub
		Query query = em.createNamedQuery("readByAddress");
		
		query.setParameter("correo", id);
		Usuario user = (Usuario) query.getSingleResult();
		return user;
		
	}



}
