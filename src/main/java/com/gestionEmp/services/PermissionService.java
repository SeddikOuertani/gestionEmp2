package com.gestionEmp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEmp.entities.Permission;
import com.gestionEmp.repositories.PermissionRepository;

@Service
@Transactional
public class PermissionService {
	
	@Autowired
	private PermissionRepository permRepo;
	
	public Permission get(Long id) {
		return permRepo.findById(id).get();
	}
	
	public void save(Permission permission) {
		permRepo.save(permission);
	}
	
	public List<Permission> listAll(){
		return permRepo.findAll();
	}
	
	public List<Permission> listAllPermissions(){
		return permRepo.findAllPermissions();
	}
	
	public void delete(Long id) {
		permRepo.deleteById(id);
	}

}
