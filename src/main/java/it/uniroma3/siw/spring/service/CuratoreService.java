package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Curatore;
import it.uniroma3.siw.spring.repository.CuratoreRepository;

@Service
public class CuratoreService {
	
	@Autowired
	private CuratoreRepository curatoreRepository; 
	
	@Transactional
	public Curatore inserisci(Curatore curatore) {
		return curatoreRepository.save(curatore);
	}

	@Transactional
	public List<Curatore> tutti() {
		return (List<Curatore>) curatoreRepository.findAll();
	}

	@Transactional
	public Curatore curatorePerId(Long id) {
		Optional<Curatore> optional = curatoreRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(Curatore curatore) {
		List<Curatore> curatori = this.curatoreRepository.findByNomeAndCognome(curatore.getNome(), curatore.getCognome());
		if (curatori.size() > 0)
			return true;
		else 
			return false;
	}

	@Transactional
	public Object curatorePerCognome(String oggettoDaCercare) {
		List<Curatore> curatori = curatoreRepository.findByCognome(oggettoDaCercare);
		if (curatori.size()>0)
			return curatori;
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExistsByCognome(String oggettoDaCercare) {
		List<Curatore> curatori = this.curatoreRepository.findByCognome(oggettoDaCercare);
		if (curatori.size() > 0)
			return true;
		else 
			return false;
	}

	@Transactional
	public Object curatorePerNome(String oggettoDaCercare) {
		List<Curatore> curatori = curatoreRepository.findByNome(oggettoDaCercare);
		if (curatori.size()>0)
			return curatori;
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExistsByNome(String oggettoDaCercare) {
		List<Curatore> curatori = this.curatoreRepository.findByNome(oggettoDaCercare);
		if (curatori.size() > 0)
			return true;
		else 
			return false;
	}
}
