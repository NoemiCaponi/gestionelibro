package it.gestionelibro.dao;

import java.util.List;

import it.gestionelibro.model.Libro;

public interface LibroDAO extends IBaseDAO<Libro> {
	
	public List<Libro> findAllByTitolo(String titoloInput) throws Exception;

}
