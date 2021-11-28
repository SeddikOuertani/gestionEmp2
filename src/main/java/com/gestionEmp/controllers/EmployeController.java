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

@Controller
public class EmployeController {

	@Autowired
	private EmployeService empService;
	
	@RequestMapping("/home/{login}")
	public String listEmployeInfo(@ModelAttribute("login") String login,Model model) {
		Employe employe = empService.findEmployeByLogin(login);
		model.addAttribute("employe",employe);
		
		return "employe_home";
	}
	
	@RequestMapping("home/{login}/conges")
	public String showCongeList(@PathVariable("login") String login, Model model) {
		Employe employe = empService.findEmployeByLogin(login);
		model.addAttribute("employe",employe);
		//List<Permission> listConges = empService.findPermissionsByEmpId(employe.getId());
		//model.addAttribute("listConges",listConges);
		return "liste_conges";
	}
	
	@RequestMapping("home/{login}/permissions")
	public String showPermList(@PathVariable("login") String login, Model model) {
		Employe employe = empService.findEmployeByLogin(login);
		List<Permission> listPermissions = empService.findPermissionsByEmpId(employe.getId());
		model.addAttribute("employe",employe);
		model.addAttribute("listPerm",listPermissions);
		return "liste_permission_employe";
	}
	
	@RequestMapping("home/{login}/permissions/addPerm")
	public String addNewPermission(@PathVariable("login") String login, Model model) {
		Employe employe = empService.findEmployeByLogin(login);
		Permission permission = new Permission();
		model.addAttribute("employe",employe);
		model.addAttribute("permission",permission);
		return "new_permission";
	}
	
	@PostMapping(value="home/{login}/permissions/savePerm")
	public String savePermission(@ModelAttribute("permission") Permission permission ,@PathVariable("login") String login, Model model) {
		Employe employe = empService.findEmployeByLogin(login);
		model.addAttribute("employe",employe);
		permission.setEtat("En attente");
		permission.setValidated(false);
		empService.savePermWithEmpId(permission, employe.getId());
		return "redirect:/home/"+login+"/permissions";
	}
	
	@RequestMapping(value="/loginPage")
	public String showLoginPage(Model model) {
		Employe employe = new Employe();
		
		model.addAttribute("employeForm",employe);
		
		return "login";
	}
	
	@PostMapping(value="/login")
	public String login(@ModelAttribute("employeForm") Employe employe , Model model, BindingResult result) {
		Employe employeFetched;
		try {
			employeFetched = empService.findEmployeByLogin(employe.getLogin());
		}catch(Exception e) {
			model.addAttribute("errorMessage",e.getMessage()+"\n\n"+e.getLocalizedMessage()+"\n\n"+e.getCause());
			return "error_page";
		}
		
		if(empService.fetchEmployeType(employeFetched.getLogin()).equals("Employe")) {
			model.addAttribute("Employe",employeFetched);
			return "redirect:/home/"+employeFetched.getLogin();
		}else {
			model.addAttribute("Responsable",employeFetched);
			return "redirect:/responsable";
		}
	}
	

}
