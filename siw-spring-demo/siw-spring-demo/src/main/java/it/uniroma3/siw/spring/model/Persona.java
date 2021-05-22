package it.uniroma3.siw.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"nome","cognome"}))
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false)
	private String nome;

	@Column(nullable=false)
	private String cognome;
	
	@Column(nullable=false)
	private String numCI;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataDiNascita;
	
	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	@Column(nullable = false)
	private String luogoDiNascita;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
	private CentroPolisportivo centroPolisportivo;
	
	@OneToMany(mappedBy="persona")
	private List<PrenotazioneCampo> prenotazioni;
	
	@OneToMany(mappedBy="persona")
	private List<IscrizioneCorso> iscrizioni;

	public CentroPolisportivo getCentroPolisportivo() {
		return centroPolisportivo;
	}

	public void setCentroPolisportivo(CentroPolisportivo centroPolisportivo) {
		this.centroPolisportivo = centroPolisportivo;
	}

	public List<PrenotazioneCampo> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<PrenotazioneCampo> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public List<IscrizioneCorso> getIscrizioni() {
		return iscrizioni;
	}

	public void setIscrizioni(List<IscrizioneCorso> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNumCI() {
		return numCI;
	}

	public void setNumCI(String numCI) {
		this.numCI = numCI;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}
}
