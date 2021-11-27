package com.gestionEmp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEmp.entities.Employe;
import com.gestionEmp.entities.Permission;
import com.gestionEmp.repositories.EmployeRepository;
import com.gestionEmp.repositories.PermissionRepository;

@Service
@Transactional
public class EmployeService {
	
	@Autowired
	private EmployeRepository empRepo;
	
	@Autowired
	private PermissionRepository permRepo;
	
	public Employe findEmployeByLogin(String login) {
		return empRepo.getEmployeByLogin(login);
	}
	
	public List<Permission> findPermissionsByEmpId(Long empId){
		return permRepo.findPermissionsByEmpId(empId);
	}
	
	public List<Employe> findEmployeByName(String name){
		return empRepo.getEmployeListByName(name);
	}
	
	public int updateEmployeAt(Long id, Employe employe) {
		return empRepo.updateEmployeAt(id,employe);
	}
	
	public Employe get(Long id) {
		return empRepo.findById(id).get();
	}
	
	public void save(Employe employe) {
		empRepo.save(employe);
	}
	
	public List<Employe> listAll(){
		return empRepo.findAll();
	}
	
	public void delete(Long id) {
		empRepo.deleteById(id);
	}
	
}
