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

	public int saveWithEmpId(Permission perm, Long empId) {
		Query query = entityManager.createNativeQuery("INSERT INTO Permission "
				+ "(etat, raison, description, heure_deb, heure_fin, employe_id) "
				+ "VALUES (?1,?2,?3,?4,?5,?6)");
		query.setParameter(1, perm.getEtat());
		query.setParameter(2, perm.getRaison());
		query.setParameter(3, perm.getDescription());
		query.setParameter(4, perm.getHeureDeb());
		query.setParameter(5, perm.getHeureFin());
		query.setParameter(6, empId);
		return query.executeUpdate();)
	}

}
