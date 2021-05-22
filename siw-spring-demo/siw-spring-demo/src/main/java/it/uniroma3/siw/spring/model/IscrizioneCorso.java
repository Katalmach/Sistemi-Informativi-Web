package it.uniroma3.siw.spring.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.javamoney.moneta.Money;

@Entity
public class IscrizioneCorso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable=false)
	private LocalDate inizioIscrizione;

	@Column(nullable=false)
	private LocalDate fineIscrizione;

	@ManyToOne(cascade = {CascadeType.PERSIST,  CascadeType.REMOVE})
	private Corso corso;

	@ManyToOne(cascade = {CascadeType.PERSIST,  CascadeType.REMOVE})
	private Persona persona;
	
	public Corso getCorso() {
		return corso;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	
	public void setFineIscrizione(LocalDate fineIscrizione) {
		this.fineIscrizione = fineIscrizione;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getInizioIscrizione() {
		return inizioIscrizione;
	}

	public void setInizioIscrizione(LocalDate inizioIscrizione) {
		this.inizioIscrizione = inizioIscrizione;
	}

	public LocalDate getFineIscrizione() {
		return this.inizioIscrizione.plusMonths(3);
	}
	public Money getCostoCorso() {
		return this.corso.getCostoMensile().multiply(3);
	}

}
