package com.gestionEmp.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.gestionEmp.entities.Conge;
import com.gestionEmp.entities.Employe;

public class CongeRepositoryCustomImp implements CongeRepositoryCustom {
	
	@PersistenceContext
	EntityManager entityManager;


	public List<Conge> getListCongeByEtat(String etat) {
		Query query = entityManager.createNativeQuery("SELECT * FROM employe WHERE etat=?1",Employe.class);
		query.setParameter(1, etat);
		return (List<Conge>) query.getResultList();
	}

}
