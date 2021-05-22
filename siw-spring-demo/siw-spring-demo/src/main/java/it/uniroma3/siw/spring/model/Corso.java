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
public class Corso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, unique = true)
	private String nomeCorso;
	
	@Column(nullable=false, length=2000)
	private String descrizione;

	@Column(nullable=false)
	private Money costoMensile;

	@OneToMany(mappedBy="corso")
	private List<IscrizioneCorso> iscrizioni;

	@ManyToOne(cascade = { CascadeType.PERSIST , CascadeType.REMOVE,CascadeType.MERGE})
	private Sport sport;

	public List<IscrizioneCorso> getIscrizioni() {
		return iscrizioni;
	}

	public void setIscrizioni(List<IscrizioneCorso> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}

	public List<Istruttore> getIstruttori() {
		return istruttori;
	}

	public void setIstruttori(List<Istruttore> istruttori) {
		this.istruttori = istruttori;
	}

	@OneToMany(mappedBy ="corso")
	private List<Istruttore> istruttori;



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Sport getSport() {
		return this.sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public Money getCostoMensile() {
		return costoMensile;
	}

	public void setCostoMensile(Money costoMensile) {
		this.costoMensile = costoMensile;
	}
}