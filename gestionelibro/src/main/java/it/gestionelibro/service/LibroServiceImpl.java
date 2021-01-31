package it.gestionelibro.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.gestionelibro.dao.LibroDAO;
import it.gestionelibro.model.Libro;
import it.gestionelibro.web.listener.LocalEntityManagerFactoryListener;

public class LibroServiceImpl implements LibroService {

	private LibroDAO libroDao;

	public void setLibroDao(LibroDAO libroDao) {
		this.libroDao = libroDao;

	}

	public List<Libro> listAll() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			libroDao.setEntityManager(entityManager);
			return libroDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	public Libro caricaSingoloElemento(Long idInput) throws Exception {
		EntityManager entityManager= LocalEntityManagerFactoryListener.getEntityManager();
		
		try {
			libroDao.setEntityManager(entityManager);
			return libroDao.findById(idInput);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	public void aggiorna(Libro input) throws Exception {
		EntityManager entityManager=LocalEntityManagerFactoryListener.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			libroDao.setEntityManager(entityManager);
			libroDao.update(input);
			
			entityManager.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	public void inserisciNuovo(Libro input) throws Exception {
		EntityManager entityManager=LocalEntityManagerFactoryListener.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			libroDao.setEntityManager(entityManager);
			libroDao.insert(input);
			
			entityManager.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	public void rimuovi(Libro input) throws Exception {
		EntityManager entityManager=LocalEntityManagerFactoryListener.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			libroDao.setEntityManager(entityManager);
			libroDao.delete(input);
			
			entityManager.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

}
