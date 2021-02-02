package it.gestionelibro.service.autore;

import java.util.List;

import javax.persistence.EntityManager;

import it.gestionelibro.dao.autore.AutoreDAO;
import it.gestionelibro.model.Autore;
import it.gestionelibro.web.listener.LocalEntityManagerFactoryListener;

public class AutoreServiceImpl implements AutoreService {
	
	private AutoreDAO autoreDao;

	@Override
	public void setAutoreDao(AutoreDAO autoreDao) {
		this.autoreDao=autoreDao;
		
	}

	@Override
	public List<Autore> listAll() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			autoreDao.setEntityManager(entityManager);
			return autoreDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Autore caricaSingoloElemento(Long idInput) throws Exception {
		EntityManager entityManager=LocalEntityManagerFactoryListener.getEntityManager();
		
		try {
			autoreDao.setEntityManager(entityManager);
			return autoreDao.findById(idInput);
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Autore input) throws Exception {
		EntityManager entityManager=LocalEntityManagerFactoryListener.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			autoreDao.setEntityManager(entityManager);
			autoreDao.update(input);
			
			entityManager.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw e;
			
		}finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}	
	}

	@Override
	public void inserisciNuovo(Autore input) throws Exception {
		EntityManager entityManager=LocalEntityManagerFactoryListener.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			autoreDao.setEntityManager(entityManager);
			autoreDao.insert(input);
			
			entityManager.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
		
	}

	@Override
	public void rimuovi(Autore input) throws Exception {
		EntityManager entityManager=LocalEntityManagerFactoryListener.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			autoreDao.setEntityManager(entityManager);
			autoreDao.delete(input);
			
			entityManager.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
		
	}

	@Override
	public List<Autore> cercaTuttiCognomi(String cognomeInput) throws Exception {
		EntityManager entityManager=LocalEntityManagerFactoryListener.getEntityManager();
		
		try{
			autoreDao.setEntityManager(entityManager);
			 return autoreDao.findAllByCognome(cognomeInput);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Autore caricaAutoreConOpere(Long id) throws Exception {
		EntityManager entityManager=LocalEntityManagerFactoryListener.getEntityManager();
		
		try {
			autoreDao.setEntityManager(entityManager);
			return autoreDao.getEagerLibri(id);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

}
