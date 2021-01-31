package it.gestionelibro.service;

import it.gestionelibro.dao.LibroDAO;
import it.gestionelibro.dao.LibroDAOImpl;

public class MyServiceFactory {
	
	private static LibroService LIBRO_SERVICE_INSTANCE = null;
	private static LibroDAO LIBRODAO_INSTANCE = null;

	public static LibroService getLibroServiceInstance() {
		if (LIBRO_SERVICE_INSTANCE == null)
			LIBRO_SERVICE_INSTANCE = new LibroServiceImpl();

		if (LIBRODAO_INSTANCE == null)
			LIBRODAO_INSTANCE = new LibroDAOImpl();

		LIBRO_SERVICE_INSTANCE.setLibroDao(LIBRODAO_INSTANCE);

		return LIBRO_SERVICE_INSTANCE;
	}


}
