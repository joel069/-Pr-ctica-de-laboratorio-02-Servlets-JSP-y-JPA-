package ec.edu.ups.jpa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.GenericDAO;
import ec.edu.ups.modelo.telefono;
import ec.edu.ups.modelo.user;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {
	
    private Class<T> persistentClass;
    protected EntityManager em;

    public JPAGenericDAO(Class<T> persistentClass) {
	this.persistentClass = persistentClass;
	this.em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
    }

    @Override
    public boolean create(T entity) {
	em.getTransaction().begin();
	try {
	    em.persist(entity);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    System.out.println(">>>> ERROR:JPAGenericDAO:create " + e);
	    if (em.getTransaction().isActive())
		em.getTransaction().rollback();
	}
	return false;
	
    }

    @Override
    public T read(ID id) {
	return em.find(persistentClass, id);
    }

    @Override
    public boolean update(T entity) {
	em.getTransaction().begin();
	try {
	    em.merge(entity);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
	    if (em.getTransaction().isActive())
		em.getTransaction().rollback();
	}
	
	return false;
    }

    // entity debe estar en estado de "Managed"
    @Override
    public boolean delete(T entity) {
	em.getTransaction().begin();
	try {
	    em.remove(entity);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
	    if (em.getTransaction().isActive())
		em.getTransaction().rollback();
	}
	return false;
    }

    @Override
    public void deleteByID(ID id) {
	T entity = this.read(id);
	if (entity != null)
	    this.delete(entity);
    }
    
    

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List<T> findAll() {
	em.getTransaction().begin();
	List<T> lista = null;
	try {
	    javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	    cq.select(cq.from(persistentClass));
	    lista = em.createQuery(cq).getResultList();
	    em.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return lista;

    }

	@Override
	public List<T> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findById(ID id) {
		// TODO Auto-generated method stub
		return null;
	}
}