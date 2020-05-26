package ec.edu.ups.jpa;

import java.util.List;

import ec.edu.ups.dao.DaoTelefono;
import ec.edu.ups.modelo.telefono;
import ec.edu.ups.modelo.user;



public class JPATelefonoDAO  extends JPAGenericDAO<telefono, Integer> implements DaoTelefono{
	
	 public JPATelefonoDAO() {
			super(telefono.class);
		    }

	@Override
	public List<telefono> findByPersonaId(String cedula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<telefono> findBySearchTelf(String cedula, String numero) {
		// TODO Auto-generated method stub
		return null;
	}

}
