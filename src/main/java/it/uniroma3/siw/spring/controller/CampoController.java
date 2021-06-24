package it.uniroma3.siw.spring.controller;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.spring.controller.validator.CampoValidator;
import it.uniroma3.siw.spring.model.Campo;
import it.uniroma3.siw.spring.model.Prenotazione;
import it.uniroma3.siw.spring.service.CampoService;
import it.uniroma3.siw.spring.service.CustodeService;
import it.uniroma3.siw.spring.service.PrenotazioneService;
import it.uniroma3.siw.spring.service.SportService;

@Controller
public class CampoController {

	@Autowired
	private CampoService campoService;

	@Autowired
	private CampoValidator campoValidator;

	@Autowired
	private SportService sportService;

	@Autowired
	private CustodeService custodeService;

	@Autowired
	private PrenotazioneService prenotazioneService;
	
	@RequestMapping(value="/admin/campo", method = RequestMethod.GET)
	public String addCampo(Model model) {
		model.addAttribute("campo", new Campo());
		model.addAttribute("sports", this.sportService.tutti());
		model.addAttribute("custodi", this.custodeService.tutti());
		return "campoForm";
	}

	@RequestMapping(value = "/campo/{id}", method = RequestMethod.GET)
	public String getCampo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("campo", this.campoService.campoPerId(id));
		return "campo";
	}

	@RequestMapping(value = "/campo", method = RequestMethod.GET)
	public String getCampi(Model model) {
		model.addAttribute("campi", this.campoService.tutti());
		return "campi";
	}

	@RequestMapping(value = "/admin/campi", method = RequestMethod.GET)
	public String getCampiAdmin(Model model) {
		model.addAttribute("campi", this.campoService.tutti());
		return "/admin/campi";
	}


	@RequestMapping(value="/campiOrdinatiPerSport", method = RequestMethod.GET)
	public String getCampiOrdinatiSport(Model model) {
		model.addAttribute("campi", this.campoService.campiOrdinatiPerSport());
		return "campi";
	}

	@RequestMapping(value="/campiOrdinatiPerPrezzoOrario", method = RequestMethod.GET)
	public String getCampiOrdinatiPrezzo(Model model) {
		model.addAttribute("campi", this.campoService.campiOrdinatiPerPrezzoOrario());
		return "campi";
	}

	@RequestMapping(value = "/eliminaCampo/{id}", method = RequestMethod.GET)
	public String eliminaCampo(@PathVariable("id")Long id, Model model) {
		this.campoService.elimina(this.campoService.campoPerId(id));
		model.addAttribute("campi", this.campoService.tutti());
		return "admin/campi";
	}

	@RequestMapping(value = "/admin/campo", method = RequestMethod.POST)
	public String addCampo(@ModelAttribute("campo") Campo campo, 
			Model model, @RequestParam Long sportSelezionato,
			@RequestParam Long custodeSelezionato, 
			BindingResult bindingResult) {
		campo.setSport(this.sportService.sportPerId(sportSelezionato));
		campo.setCustode(this.custodeService.custodePerId(custodeSelezionato));
		this.campoValidator.validate(campo, bindingResult);
		if (!bindingResult.hasErrors()) {
			this.campoService.inserisci(campo);
			model.addAttribute("campi", this.campoService.tutti());
			return "campi";
		}
		model.addAttribute("sports", this.sportService.tutti());
		model.addAttribute("custodi", this.custodeService.tutti());
		return "campoForm";
	}  

	@RequestMapping(value="/modificaCampo/{id}", method = RequestMethod.GET)
	public String modificaCampo(Model model,@PathVariable("id")Long id) {
		Campo campo= new Campo();
		
		List<Prenotazione> prenotazioni = this.prenotazioneService.prenotazioniPerCampo(this.campoService.campoPerId(id));
		
		if(prenotazioni.size()>0 &&prenotazioni!=null)
		for(Prenotazione prenotazione:prenotazioni) {
			prenotazione.setCampo(campo);
		}
		campo.setMatricola("prova");
		this.campoService.inserisci(campo);
		model.addAttribute("campo",campo);
		 this.campoService.elimina(this.campoService.campoPerId(id));
		model.addAttribute("prenotazioni", prenotazioni); 
		model.addAttribute("custodi", this.custodeService.tutti());
		model.addAttribute("sports", this.sportService.tutti());
		return "/admin/modificaCampo";
	}

	
	@RequestMapping(value="/modificaCampo/{id}", method= RequestMethod.POST)
	public String modificaCampo(Model model, @PathVariable("id")Long id, @RequestParam Long sportSelezionato,
			@RequestParam Long custodeSelezionato, @ModelAttribute("campo")Campo campo,
			BindingResult campoBindingResult) {
		campo.setCustode(this.custodeService.custodePerId(custodeSelezionato));
		campo.setSport(this.sportService.sportPerId(sportSelezionato));
		
		this.campoValidator.validate(campo, campoBindingResult);
		if(!campoBindingResult.hasErrors()) {
			this.campoService.inserisci(campo);
			model.addAttribute("campi",this.campoService.tutti());
			return "/admin/campi";
		}
		model.addAttribute("custodi",this.custodeService.tutti());
		model.addAttribute("sports",this.sportService.tutti());

		return "/admin/modificaCampo";
	}

}

