package it.uniroma3.siw.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.javamoney.moneta.Money;

@Entity
public class Campo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, unique = true)
	private long nome;

	@Column(length = 2000)
	private String descrizione;
	
	@Column(nullable=false)
	private Money prezzoOrario;

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE})
	private CentroPolisportivo centroPolisportivo;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private Sport sport;
	
	@OneToMany(mappedBy ="campo")
	private List<PrenotazioneCampo> prenotazioni;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMatricola() {
		return nome;
	}

	public void setMatricola(long matricola) {
		this.nome = matricola;
	}

	public Money getPrezzoOrario() {
		return prezzoOrario;
	}

	public void setPrezzoOrario(Money prezzoOrario) {
		this.prezzoOrario = prezzoOrario;
	}

	public long getNome() {
		return nome;
	}

	public void setNome(long nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public CentroPolisportivo getCentroPolisportivo() {
		return centroPolisportivo;
	}

	public void setCentroPolisportivo(CentroPolisportivo centroPolisportivo) {
		this.centroPolisportivo = centroPolisportivo;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public List<PrenotazioneCampo> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<PrenotazioneCampo> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
}

