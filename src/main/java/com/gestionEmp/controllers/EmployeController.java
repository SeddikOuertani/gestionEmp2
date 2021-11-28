package com.gestionEmp.controllers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestionEmp.entities.Employe;
import com.gestionEmp.services.EmployeService;

@Controller
public class EmployeController {

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
		List<Employe> listEmploye = empService.listAll();
		model.addAttribute("listEmploye",listEmploye);
		
		return "liste_employe";
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Employe employe = empService.get(id);
		model.addAttribute("employe",employe);
		return "update_employe";
	}

	@PostMapping("update/{id}")
	public String updateEmploye(@ModelAttribute("employe") Employe employe, @PathVariable("id") Long id, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("I'm in the hasErrors if block");
			employe.setId(id);
			return "update_employe";
		}

		System.out.println("I'm right after the if block");
		
		int i = empService.updateEmployeAt(id,employe);

		System.out.println("I'm after the update Instruction");
		if(i == 0) {
			return "update_employe";
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("delete/{id}")
	public String deleteVoiture(@PathVariable("id") Long id, Model model) {	
		empService.delete(id);
		return "redirect:/";
	}
}
