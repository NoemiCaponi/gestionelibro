package it.gestionelibro.dao.autore;

import java.util.List;

import it.gestionelibro.dao.IBaseDAO;
import it.gestionelibro.model.Autore;


public interface AutoreDAO extends IBaseDAO<Autore>{

	public List<Autore> findAllByCognome (String cognomeInput) throws Exception;
	
	public Autore getEagerLibri(Long id) throws Exception;
}
