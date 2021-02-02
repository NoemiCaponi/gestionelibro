package it.gestionelibro.service.autore;

import java.util.List;

import it.gestionelibro.dao.autore.AutoreDAO;
import it.gestionelibro.model.Autore;

public interface AutoreService {

	public void setAutoreDao(AutoreDAO autoreDao);

	public List<Autore> listAll() throws Exception;

	public Autore caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Autore input) throws Exception;

	public void inserisciNuovo(Autore input) throws Exception;

	public void rimuovi(Autore input) throws Exception;
	
	public List<Autore>cercaTuttiCognomi (String cognomeInput) throws Exception;
	
	public Autore caricaAutoreConOpere(Long id)throws Exception;

}
