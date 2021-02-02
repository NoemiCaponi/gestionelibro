package it.gestionelibro.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="autore")
public class Autore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idautore")
	private Long id;
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
	@OneToMany(mappedBy = "autore", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Libro>opere=new ArrayList<Libro>();
	
	public Autore() {
		
	}
	
	public Autore(String nome, String cognome) {
		this.nome=nome;
		this.cognome=cognome;
	}
	
	public Autore(String nome, String cognome, List<Libro>opere) {
		this.nome=nome;
		this.cognome=cognome;
		this.opere=opere;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}
	
	public List<Libro> getOpere(){
		return opere;
	}
	
	public void setOpere(List<Libro>opere) {
		this.opere=opere;
	}

	@Override
	public String toString() {
		return "Autore [nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	 public void addLibro(Libro libro){
	        this.opere.add(libro);
	        if(libro.getAutore()!=this) {
	        	libro.setAutore(this);
	        }
	    }
	
}
