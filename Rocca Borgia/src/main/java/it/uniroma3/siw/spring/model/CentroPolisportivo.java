package it.uniroma3.siw.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CentroPolisportivo {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

@Column(nullable=false)
private String nome;

@Column(nullable=false)
private String citta;

@Column(nullable=false)
private String via;

@Column
private ArrayList<String> phonenumbers;

@OneToMany(mappedBy="centroPolisportivo")
private List<Istruttore> dipendenti;

@OneToMany(mappedBy="centroPolisportivo")
private List<Campo> campi;

public CentroPolisportivo() {
	
}
public CentroPolisportivo(String nome,String citta,String via) {
	this.nome = nome;
	this.citta = citta;
	this.via=via;
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

public String getCitta() {
	return citta;
}

public void setCitta(String citta) {
	this.citta = citta;
}

public String getVia() {
	return via;
}

public void setVia(String via) {
	this.via = via;
}

public ArrayList<String> getPhonenumbers() {
	return phonenumbers;
}

public void setPhonenumbers(ArrayList<String> phonenumbers) {
	this.phonenumbers = phonenumbers;
}

}
