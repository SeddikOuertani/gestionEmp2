package com.gestionEmp.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.gestionEmp.entities.Conge;
import com.gestionEmp.entities.Employe;
import com.gestionEmp.services.CongeService;
import com.gestionEmp.services.EmployeService;

@Controller
@RequestMapping("/home/{login}/conge")
public class CongeController {
	@Autowired
	private CongeService congeService;
	@Autowired
	private EmployeService employeService;
	
	@GetMapping("/add")
	public String addConge(Model model ,@PathVariable("login") String login) {
		long idEmploye = employeService.findEmployeByLogin(login).getId();
		Conge conge = new Conge();
		Employe employe = new Employe();
		employe.setId(idEmploye);
		conge.setEmploye(employe);
		model.addAttribute("congeForm",conge);	
		model.addAttribute("login",login);
		
		return "new_conge";
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveConge(@ModelAttribute("conge") Conge conge,@PathVariable("login") String login) {
		conge.setEtat("enCours");
		
		double diff = conge.getDateFin().getTime() - conge.getDateDebut().getTime();
		System.out.println("diff "+diff);
		int period = (int)Math.floor(diff/(24 * 60 * 60 * 1000));
		
		System.out.println("Period "+period);
		conge.setPeriode(period);
		
		congeService.save(conge);
		
		return "redirect:/home/"+login+"/conge";
	}
	
	@RequestMapping(value="")
	public String listConge(Model model,@PathVariable("login") String login) {
		List<Conge> listConge = employeService.findEmployeByLogin(login).getCongeList();
		model.addAttribute("listConge",listConge);
		model.addAttribute("login",login);
		return "liste_conge";
	}
	@GetMapping("/delete/{id}")
	public String deleteConge(@PathVariable("id") Long id, Model model,@PathVariable("login") String login) {	
		congeService.delete(id);
		return "redirect:/home/"+login+"/conge";
	}
	@GetMapping("/update/{id}")
	public String updateConge(@PathVariable("login") String login,@PathVariable("id") Long id,Model model) {
		
		Conge conge = congeService.get(id);
		model.addAttribute("conge",conge);
		model.addAttribute("login",login);
		return "update_conge";
		
	}
}