package it.uniroma3.siw.spring.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Corso;
import it.uniroma3.siw.spring.model.Istruttore;

public interface IstruttoreRepository extends CrudRepository<Istruttore, Long> {

	public List<Istruttore> findByNome(String nome);

	public List<Istruttore> findByNomeAndCognome(String nome, String cognome);

	public List<Istruttore> findByNomeOrCognome(String nome, String cognome);
	
	public List<Istruttore> findByIdAndCorso(Long id,Corso corso);
}
