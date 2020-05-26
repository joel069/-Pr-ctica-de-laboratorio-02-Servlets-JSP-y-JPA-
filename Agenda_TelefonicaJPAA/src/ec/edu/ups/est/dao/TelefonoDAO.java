package ec.edu.ups.est.dao;

import java.util.List;
import java.util.Set;

import ec.edu.ups.est.modelo.Telefono;
import ec.edu.ups.est.modelo.Usuario;

public interface TelefonoDAO extends GenericDAO<Telefono, Integer> {
	
	public abstract Telefono read(String numero);


	
}
