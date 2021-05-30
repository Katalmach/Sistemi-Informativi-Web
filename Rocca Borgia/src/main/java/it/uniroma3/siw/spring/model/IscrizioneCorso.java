package it.uniroma3.siw.spring.model;

import java.util.Date;

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
	private Date inizioIscrizione;

	@Column(nullable=false)
	private Date fineIscrizione;

	@ManyToOne(cascade = {CascadeType.PERSIST,  CascadeType.REMOVE})
	private Corso corso;

	@ManyToOne(cascade = {CascadeType.PERSIST,  CascadeType.REMOVE})
	private User user;
	
	public Corso getCorso() {
		return corso;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User User) {
		this.user = User;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	
	public void setFineIscrizione(Date fineIscrizione) {
		this.fineIscrizione = fineIscrizione;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getInizioIscrizione() {
		return inizioIscrizione;
	}

	public void setInizioIscrizione(Date inizioIscrizione) {
		this.inizioIscrizione = inizioIscrizione;
	}

	public Date getFineIscrizione() {
		return this.fineIscrizione;
	}
	public Money getCostoCorso() {
		return this.corso.getCostoMensile().multiply(3);
	}

}
