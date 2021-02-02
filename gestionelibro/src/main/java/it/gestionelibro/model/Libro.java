package it.gestionelibro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "codice")
	private String codice;
	@Column(name = "titolo")
	private String titolo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "autore_id")
	private Autore autore;
	@Column(name = "prezzo")
	private Integer prezzo;
	@Column(name = "dataarrivo")
	private Date dataArrivo;
	
	
	
	public Libro() {
		
	}

	public Libro(String codice, String titolo, Integer prezzo, Date dataArrivo, Autore autore) {
		this.codice=codice;
		this.titolo=titolo;
		this.prezzo=prezzo;
		this.dataArrivo=dataArrivo;
		this.autore=autore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public Date getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}
	
	public Autore getAutore() {
		return autore;
	}
	
	public void setAutore(Autore autore) {
		this.autore=autore;
	}
	
	
}
