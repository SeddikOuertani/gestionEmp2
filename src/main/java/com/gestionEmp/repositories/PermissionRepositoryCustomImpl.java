package com.gestionEmp.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEmp.entities.Permission;

@Repository
@Transactional(readOnly = true)
public class PermissionRepositoryCustomImpl implements PermissionRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Permission> findPermissionsByEmpId(Long empId) {
		Query query = entityManager.createNativeQuery("SELECT * FROM Permission WHERE employe_id = ?",Permission.class);
		query.setParameter(1, empId);
		
		return (List<Permission>) query.getResultList();
	}

}
