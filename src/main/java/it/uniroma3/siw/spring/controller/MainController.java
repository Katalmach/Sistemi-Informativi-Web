package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.service.CustodeService;
import it.uniroma3.siw.spring.service.SportService;
import it.uniroma3.siw.spring.service.UserService;


@Controller
public class MainController {
	
	@Autowired
	private CustodeService custodeService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private SportService sportService;
	
	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index(Model model) {
			return "index";
	}
	
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String getPaginaAbout(Model model) {
    		model.addAttribute("users", this.userService.getAllUsers());
    		model.addAttribute("custodi", this.custodeService.tutti());
    		model.addAttribute("sports",this.sportService.tutti());
    		return "about";
    }
}
