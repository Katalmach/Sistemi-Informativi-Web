package it.uniroma3.siw.spring.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Campo;
import it.uniroma3.siw.spring.model.Prenotazione;
import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.repository.PrenotazioneRepository;


@Service
public class PrenotazioneService {

		@Autowired
		private PrenotazioneRepository prenotazioneRepository; 
		
		@Transactional
		public Prenotazione inserisci(Prenotazione prenotazione) {
			return prenotazioneRepository.save(prenotazione);
		}

		@Transactional
		public List<Prenotazione> tutti() {
			return (List<Prenotazione>) prenotazioneRepository.findAll();
		}

		@Transactional
		public void elimina(Prenotazione prenotazione) {
			this.prenotazioneRepository.delete(prenotazione);
		}
		
		
		@Transactional
		public Prenotazione prenotazionePerId(Long id) {
			Optional<Prenotazione> optional = prenotazioneRepository.findById(id);
			if (optional.isPresent())
				return optional.get();
			else 
				return null;
		}
		
		@Transactional
		public List<Prenotazione> prenotazioniPerUtente(User user) {
			List<Prenotazione> prenotazioni = prenotazioneRepository.findByUser(user);
			if (prenotazioni.size()>0)
				return prenotazioni;
			else 
				return null;
		}

		@Transactional
		public boolean alreadyExists(Prenotazione prenotazione) {
			Optional<Prenotazione> prenotazioni = this.prenotazioneRepository.findByGiornoAndOraAndCampo(prenotazione.getGiorno(), prenotazione.getOra(),prenotazione.getCampo());
			if (prenotazioni.isPresent())
				return true;
			else 
				return false;
		}
		

		@Transactional
		public List<Prenotazione> prenotazioniPerCampo(Campo campo) {
			List<Prenotazione> prenotazioni =this.prenotazioneRepository.findByCampo(campo);
			if(prenotazioni.size()>0)
				return prenotazioni;
			return null;
		}
		
		@Transactional
		public List<Prenotazione> prenotazioniPerGiorno(LocalDate giorno) {
			List<Prenotazione> prenotazioni =this.prenotazioneRepository.findByGiorno(giorno);
			if(prenotazioni.size()>0)
				return prenotazioni;
			return null;
		}
		
		@Transactional
		public long conta() {
			return this.prenotazioneRepository.count();
		}
		
		@Transactional
		public List<Prenotazione> prenotazioniOrdinatePerCampo(User user) {
			List<Prenotazione> prenotazioni =this.prenotazioneRepository.findByUser(user, 1);
			if(prenotazioni.size()>0)
				return prenotazioni;
			return null;
		}
		
	}


