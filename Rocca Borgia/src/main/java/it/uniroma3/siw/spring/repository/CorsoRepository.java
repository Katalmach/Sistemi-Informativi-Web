package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.javamoney.moneta.Money;

import it.uniroma3.siw.spring.model.Corso;
import it.uniroma3.siw.spring.model.Sport;

public interface CorsoRepository {
	public List<Corso> findByNome(String nomeCorso);
	
	public List<Corso> findByNomeAndCostoMensile(String nomeCorso, Money costoMensile);
	
	public List<Corso> findBySport(Sport sport);
	
	
}
