package com.gestionEmp.controllers;

import java.util.List;

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

import com.gestionEmp.entities.Employe;
import com.gestionEmp.entities.Permission;
import com.gestionEmp.services.EmployeService;
import com.gestionEmp.services.PermissionService;
import com.gestionEmp.services.ResponsableService;

@Controller
public class ResponsableController {

	@Autowired
	private ResponsableService respService; 
	
	@Autowired
	private EmployeService empService;

	@GetMapping("/responsable/empList/addEmploye")
	public String addEmploye(Model model) {
		Employe employe = new Employe();
		model.addAttribute("employeForm",employe);
		return "new_employe";
	}
	
	@RequestMapping(value="/responsable/empList/addEmploye/save", method = RequestMethod.POST)
	public String saveEemploye(@ModelAttribute("employe") Employe employe) {
		empService.save(employe);
		return "redirect:/responsable";
	}
	
	@RequestMapping(value="/responsable/empList")
	public String listEmploye(Model model) {
		List<Employe> listEmploye = respService.ListAllEmployeTypes();
		model.addAttribute("listEmploye",listEmploye);
		
		return "liste_employe";
	}
	
	@RequestMapping(value="/responsable")
	public String respHome(Model model) {
		
		return "responsable_home";
	}
	
	@GetMapping("/responsable/empList/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Employe employe = empService.get(id);
		model.addAttribute("employe",employe);
		return "update_employe";
	}

	@PostMapping("/responsable/empList/update/{id}")
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
			return "redirect:/responsable";
		}
	}
	
	@GetMapping("/responsable/empList/delete/{id}")
	public String deleteEmploye(@PathVariable("id") Long id, Model model) {	
		
		try{
			empService.delete(id);
			return "redirect:/responsable";
		}catch(Exception e) {
			model.addAttribute("errorMessage",e.getMessage()+"\n\n"+e.getLocalizedMessage()+"\n\n"+e.getCause());
			return "error_page";
		}
	}
	
	@RequestMapping("/responsable/permList")
	public String listPermission(Model model) {
		List<Permission> listPermission = respService.listAllPerms();
		model.addAttribute("listPermission",listPermission);
		
		return "liste_permission_responsable";
	}
	
	
}
