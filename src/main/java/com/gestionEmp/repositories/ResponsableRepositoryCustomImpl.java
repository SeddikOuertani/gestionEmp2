package com.gestionEmp.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestionEmp.entities.Employe;
import com.gestionEmp.entities.Permission;

@Repository
@Transactional(readOnly = true)
public class ResponsableRepositoryCustomImpl implements ResponsableRepositoryCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	
	public int validePermission(Long permId) {
		String etat = "en_cours";
		Query query = entityManager.createNativeQuery("UPDATE Permission SET etat = ?1 WHERE id_perm = ?2");
		query.setParameter(1, etat);
		query.setParameter(2, permId);
		
		return query.executeUpdate();
	}

	public int valideConge(Long empId, Long permId) {
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<Employe> getAllEmployeTypes() {
		Query query = entityManager.createNativeQuery("SELECT * FROM Employe WHERE dtype = 'Employe'",Employe.class);
		return (List<Employe>) query.getResultList();
	}

	public String findEmpByPerm(Long permId) {
		Query query = entityManager.createNativeQuery(
				"SELECT Emp.login FROM Employe Emp, Permission Perm "
				+ "WHERE Emp.id = Permission.employe_id AND Perm.id_perm = ?");
		
		query.setParameter(1, permId);
		return query.getSingleResult().toString();
	}
}
