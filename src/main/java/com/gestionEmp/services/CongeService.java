package com.gestionEmp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEmp.entities.Conge;
import com.gestionEmp.repositories.CongeRepository;

@Service
@Transactional
public class CongeService {
	
	@Autowired
	private CongeRepository congeRepo;
	
	public Conge get(Long id) {
		return congeRepo.findById(id).get();
	}
	
	public void save(Conge Conge) {
		congeRepo.save(Conge);
	}
	
	public List<Conge> listAll(){
		return congeRepo.findAll();
	}
	
	public void delete(Long id) {
		congeRepo.deleteById(id);
	}
}
