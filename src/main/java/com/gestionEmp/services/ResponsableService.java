package com.gestionEmp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEmp.entities.Employe;
import com.gestionEmp.entities.Permission;
import com.gestionEmp.entities.Responsable;
import com.gestionEmp.repositories.PermissionRepository;
import com.gestionEmp.repositories.ResponsableRepository;

@Service
@Transactional
public class ResponsableService {
	
	@Autowired
	private ResponsableRepository respRepo;
	
	@Autowired
	private PermissionRepository permRepo;
	
	public Responsable get(Long id) {
		return respRepo.findById(id).get();
	}
	
	public List<Permission> listAllPerms(){
		return permRepo.findAllPermissions();
	}
	
	public void save(Responsable responsable) {
		respRepo.save(responsable);
	}
	
	public List<Responsable> listAll(){
		return respRepo.findAll();
	}
	
	public void delete(Long id) {
		respRepo.deleteById(id);
	}
	
	public List<Employe> ListAllEmployeTypes(){
		return respRepo.getAllEmployeTypes();
	}
}
