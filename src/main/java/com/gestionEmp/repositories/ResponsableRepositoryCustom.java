package com.gestionEmp.repositories;

import com.gestionEmp.entities.Permission;

public interface ResponsableRepositoryCustom {

	int validePermission(Long permId);
	int valideConge(Long empId, Long permId);
}
