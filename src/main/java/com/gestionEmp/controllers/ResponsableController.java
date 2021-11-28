package com.gestionEmp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gestionEmp.entities.Employe;
import com.gestionEmp.services.EmployeService;
import com.gestionEmp.services.ResponsableService;

@Controller
public class ResponsableController {

	@Autowired
	private ResponsableService respService; 
	
	@Autowired
	private EmployeService empService;

	@GetMapping("/addEmploye")
	public String addEmploye(Model model) {
		Employe employe = new Employe();
		model.addAttribute("employeForm",employe);
		return "new_employe";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveEemploye(@ModelAttribute("employe") Employe employe) {
		empService.save(employe);
		return "redirect:/";
	}
	
	@RequestMapping(value="/")
	public String listEmploye(Model model) {
		List<Employe> listEmploye = respService.ListAllEmployeTypes();
		model.addAttribute("listEmploye",listEmploye);
		
		return "liste_employe";
	}
	
}
