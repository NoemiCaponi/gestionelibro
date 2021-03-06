package it.gestionelibro.service;

import java.util.List;

import it.gestionelibro.dao.libro.LibroDAO;
import it.gestionelibro.model.Libro;

public interface LibroService {

	public void setLibroDao(LibroDAO libroDao);

	public List<Libro> listAll() throws Exception;

	public Libro caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Libro input) throws Exception;

	public void inserisciNuovo(Libro input) throws Exception;

	public void rimuovi(Libro input) throws Exception;
	
	public List<Libro>cercaTuttiTitoli (String titoloInput) throws Exception;
	
	public Libro caricaLibroConAutore(Long idInput) throws Exception;

}
