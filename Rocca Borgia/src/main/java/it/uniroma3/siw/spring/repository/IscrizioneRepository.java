package it.uniroma3.siw.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Corso;
import it.uniroma3.siw.spring.model.IscrizioneCorso;
import it.uniroma3.siw.spring.model.User;

public interface IscrizioneRepository extends CrudRepository<IscrizioneCorso,Long> {
	public List<IscrizioneCorso> findByCorso(Corso corso);
	
	public List<IscrizioneCorso> findByUser(User user);
	
	public List<IscrizioneCorso> findByInizioIscrizione(Date inizioIscrizione);


	public List<IscrizioneCorso> findByInizioIscrizioneAndFineIscrizione(Date inizioIscrizione,Date fineIscrizione);
	

	public List<IscrizioneCorso> findByFineIscrizione(Date fineIscrizione);
}
