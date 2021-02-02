package it.gestionelibro.dao.autore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.gestionelibro.model.Autore;

public class AutoreDAOImpl implements AutoreDAO {
	
	private EntityManager entityManager;

	@Override
	public List<Autore> list() throws Exception {
		return entityManager.createQuery("from Autore",Autore.class).getResultList();
	}

	@Override
	public Autore findById(Long id) throws Exception {
		return entityManager.find(Autore.class,id);
	}

	@Override
	public void update(Autore input) throws Exception {
		if(input==null) {
			throw new Exception("Valore di input non valido");
		}
		input=entityManager.merge(input);
		
	}

	@Override
	public void insert(Autore input) throws Exception {
		if(input==null) {
			throw new Exception("Valore di input non valido");
		}
		entityManager.persist(input);
		
	}

	@Override
	public void delete(Autore input) throws Exception {
		if(input==null || input.getId()<1) {
			throw new Exception("Valore di input non valido");
		}
		entityManager.remove(entityManager.merge(input));
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager=entityManager;
		
	}

	@Override
	public List<Autore> findAllByCognome(String cognomeInput) throws Exception {
		if(cognomeInput==null) {
			throw new Exception("valore di input non valido");
		}
		TypedQuery<Autore>query=entityManager.createQuery("from Autore a where a.cognome like ?1", Autore.class);
		
		return query.setParameter(1, cognomeInput+'%').getResultList();
	}

}
