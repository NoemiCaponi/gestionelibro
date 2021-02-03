package it.gestionelibro.dao.libro;

import java.util.List;

import it.gestionelibro.dao.IBaseDAO;
import it.gestionelibro.model.Libro;

public interface LibroDAO extends IBaseDAO<Libro> {
	
	public List<Libro> findAllByTitolo(String titoloInput) throws Exception;
	
	public Libro findLibroConAutore(Long id) throws Exception;

}
