package it.gestionelibro.dao.libro;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.gestionelibro.model.Libro;


public class LibroDAOImpl implements LibroDAO {
	
	private EntityManager entityManager;

	public List<Libro> list() throws Exception {
		return entityManager.createQuery("from Libro", Libro.class).getResultList();
	}

	public Libro findById(Long id) throws Exception {
		return entityManager.find(Libro.class, id);
	}

	public void update(Libro input) throws Exception {
		if(input==null) {
			throw new Exception("Valore di input non valido");
		}
		input=entityManager.merge(input);
		
	}

	public void insert(Libro input) throws Exception {
		if(input==null) {
			throw new Exception("Valore di input non valido");
		}
		entityManager.persist(input);
		
	}

	public void delete(Libro input) throws Exception {
		if(input==null || input.getId()<1) {
			throw new Exception("Valore di input non valido");
		}
		entityManager.remove(entityManager.merge(input));
		
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager=entityManager;
		
	}

	@Override
	public List <Libro> findAllByTitolo(String titoloInput) throws Exception {
		if(titoloInput==null)
			throw new Exception("Valore di input non valido");
		TypedQuery<Libro> query = entityManager.createQuery("from Libro l where l.titolo like ?1", Libro.class);
		return query.setParameter(1, titoloInput+'%').getResultList();
	}


}
