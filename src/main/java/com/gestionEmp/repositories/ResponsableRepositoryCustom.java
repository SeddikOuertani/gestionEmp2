package com.gestionEmp.repositories;

import java.util.List;

import com.gestionEmp.entities.Employe;
import com.gestionEmp.entities.Permission;

public interface ResponsableRepositoryCustom {

	int validePermission(Long permId);
	int valideConge(Long empId, Long permId);
	List<Employe> getAllEmployeTypes();
}
