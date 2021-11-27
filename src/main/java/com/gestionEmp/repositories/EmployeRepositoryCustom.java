package com.gestionEmp.repositories;

import java.util.List;

import com.gestionEmp.entities.Employe;
import com.gestionEmp.entities.Permission;

public interface EmployeRepositoryCustom {

	List<Employe> getEmployeListByName(String name);
	Employe getEmployeByLogin(String login);
	int updateEmployeAt(Long id, Employe employe);
	int permissionFinish(Long permId);
	
}
