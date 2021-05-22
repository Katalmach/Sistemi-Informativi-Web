package it.uniroma3.siw.spring.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PrenotazioneCampo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable=false)
	private LocalDateTime dataInizio;

	@Column(nullable=false)
	private LocalDateTime dataFine;

	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private Campo campo;

	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private Persona persona;

	public Campo getCampo() {
		return campo;
	}

	public void setCampo(Campo campo) {
		this.campo = campo;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona utente) {
		this.persona = utente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDateTime getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}
}
