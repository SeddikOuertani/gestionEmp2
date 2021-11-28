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
public class EmployeRepositoryCustomImpl implements EmployeRepositoryCustom{

	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Employe> getEmployeListByName(String name) {
		Query query = entityManager.createNativeQuery("SELECT * FROM employe WHERE name LIKE ?",Employe.class);
		query.setParameter(1, name + "%");
		return (List<Employe>) query.getResultList();
	}

	public Employe getEmployeByLogin(String login) {
		Query query = entityManager.createNativeQuery("SELECT * FROM employe WHERE login = ?",Employe.class);
		query.setParameter(1, login);
		Employe employe = (Employe) query.getSingleResult();
		System.out.println("in the EmployeCustomImpl");
		System.out.println(employe.getMotDePasse());
		return employe;
	}

	public int updateEmployeAt(Long id, Employe employe) {
		Query queryGet = entityManager.createNativeQuery("SELECT * FROM Employe WHERE id = ?",Employe.class);
		queryGet.setParameter(1, id);
		
		Query querySet = entityManager.createQuery("UPDATE Employe SET mot_de_passe = ?1, login = ?2, nom = ?3, prenom = ?4, email = ?5, num_tel = ?6, conge_restant = ?7 WHERE id = ?8");
		
		
		querySet.setParameter(1, employe.getMotDePasse());
		querySet.setParameter(2, employe.getLogin());
		querySet.setParameter(3, employe.getNom());
		querySet.setParameter(4, employe.getPrenom());
		querySet.setParameter(5, employe.getEmail());
		querySet.setParameter(6, employe.getNumTel());
		querySet.setParameter(7, employe.getCongeRestant());
		querySet.setParameter(8, id);
		
		return querySet.executeUpdate();
	}

	public int permissionFinish(Long permId) {
		String etat = "finis";
		Query query = entityManager.createNativeQuery("UPDATE Permission SET etat = ?1 WHERE perm_id = ?2");
		query.setParameter(1, etat);
		query.setParameter(2, permId);
		
		return query.executeUpdate();
	}

	public String fetchEmpType(String login) {
		Query query = entityManager.createNativeQuery("SELECT dtype FROM Employe WHERE login = ?1");
		query.setParameter(1, login);
		
		return (query.getSingleResult()).toString();
	}


}
