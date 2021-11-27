package com.gestionEmp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEmp.entities.Administrateur;
import com.gestionEmp.repositories.AdministrateurRepository;

@Service
@Transactional
public class AdministrateurService {

	@Autowired
	private AdministrateurRepository adminRepo;
	
	public Administrateur get(Long id) {
		return adminRepo.findById(id).get();
	}
	
	public void save(Administrateur administrateur) {
		adminRepo.save(administrateur);
	}
	
	public List<Administrateur> listAll(){
		return adminRepo.findAll();
	}
	
	public void delete(Long id) {
		adminRepo.deleteById(id);
	}
}
