package it.euris.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.euris.example.models.User;

@Controller
public class SpringController {
	
	
	@Autowired
	private User mioUtente;
	@Autowired
	public User luciaUser;
	
	@RequestMapping(value={"/ciaoSpring", "/salveSpring"}, method=RequestMethod.GET)
	public String goToPage(){
		return "hiddenPage";
	}
	
	@RequestMapping(value={"/ciaoSpringUser", "/salveSpringUser"}, method=RequestMethod.GET)
	public ModelAndView goToPage(@RequestParam("name") String nome, @RequestParam("surname") String cognome){
		//istanza/bean iniettata
		mioUtente.setName(nome);
		mioUtente.setSurname(cognome);
		
		ModelAndView modAndView = new ModelAndView("hiddenPage");
		modAndView.addObject("mioUtente", mioUtente);
		return modAndView;
	}
	
	@RequestMapping(value={"/tuuts"}, method=RequestMethod.GET)
	public ModelAndView goToLucia(){
		ModelAndView modAndView = new ModelAndView("hiddenPage");
		modAndView.addObject("mioUtente", luciaUser);
		return modAndView;
	}

}
