package it.gestionelibro.service;

import it.gestionelibro.dao.autore.AutoreDAO;
import it.gestionelibro.dao.autore.AutoreDAOImpl;
import it.gestionelibro.dao.libro.LibroDAO;
import it.gestionelibro.dao.libro.LibroDAOImpl;
import it.gestionelibro.service.autore.AutoreService;
import it.gestionelibro.service.autore.AutoreServiceImpl;

public class MyServiceFactory {
	
	private static LibroService LIBRO_SERVICE_INSTANCE = null;
	private static LibroDAO LIBRODAO_INSTANCE = null;
	
	private static AutoreService AUTORE_SERVICE_INSTANCE=null;
	private static AutoreDAO AUTOREDAO_INSTANCE =null;

	public static LibroService getLibroServiceInstance() {
		if (LIBRO_SERVICE_INSTANCE == null)
			LIBRO_SERVICE_INSTANCE = new LibroServiceImpl();

		if (LIBRODAO_INSTANCE == null)
			LIBRODAO_INSTANCE = new LibroDAOImpl();

		LIBRO_SERVICE_INSTANCE.setLibroDao(LIBRODAO_INSTANCE);

		return LIBRO_SERVICE_INSTANCE;
	}
	
	public static AutoreService getAutoreServiceInstance() {
		if(AUTORE_SERVICE_INSTANCE==null)
			AUTORE_SERVICE_INSTANCE=new AutoreServiceImpl();
		
		if(AUTOREDAO_INSTANCE==null)
			AUTOREDAO_INSTANCE=new AutoreDAOImpl();
		
		AUTORE_SERVICE_INSTANCE.setAutoreDao(AUTOREDAO_INSTANCE);
		
		return AUTORE_SERVICE_INSTANCE;
	}


}
