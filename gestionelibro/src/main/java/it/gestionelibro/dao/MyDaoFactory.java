package it.gestionelibro.dao;

import it.gestionelibro.dao.autore.AutoreDAO;
import it.gestionelibro.dao.autore.AutoreDAOImpl;
import it.gestionelibro.dao.libro.LibroDAO;
import it.gestionelibro.dao.libro.LibroDAOImpl;

public class MyDaoFactory {
	private static LibroDAO libroDaoInstance = null;
	
	private static AutoreDAO autoreDaoInstance=null;

	public static LibroDAO getLibroDAOInstance() {
		if (libroDaoInstance == null)
			libroDaoInstance = new LibroDAOImpl();

		return libroDaoInstance;
	}
	
	public static AutoreDAO getAutoreDAOInstance() {
		if(autoreDaoInstance==null)
			autoreDaoInstance=new AutoreDAOImpl();
		
		return autoreDaoInstance;
	}

}
