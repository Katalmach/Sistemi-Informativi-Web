package it.uniroma3.siw.spring.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Persona;
import it.uniroma3.siw.spring.service.PersonaService;


@Component
public class PersonaValidator implements Validator {
	@Autowired
	private PersonaService personaService;
	
    private static final Logger logger = LoggerFactory.getLogger(PersonaValidator.class);

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataDiNascita", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "luogoDiNascita", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numCI", "required");
		
		if (!errors.hasErrors()) {
			logger.debug("confermato: valori non nulli");
			if (this.personaService.alreadyExists((Persona)o)) {
				logger.debug("e' un duplicato");
				errors.reject("duplicato");
			}
		}
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Persona.class.equals(aClass);
	}
}