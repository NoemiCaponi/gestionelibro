package it.gestionelibro.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface IBaseDAO<Libro> {

	public List<Libro> list() throws Exception;

	public Libro findById(Long id) throws Exception;

	public void update(Libro input) throws Exception;

	public void insert(Libro input) throws Exception;

	public void delete(Libro input) throws Exception;

	public void setEntityManager(EntityManager entityManager);


}
