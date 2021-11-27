package com.gestionEmp.repositories;

import com.gestionEmp.entities.Permission;

public interface ResponsableRepositoryCustom {

	void validePermission(Long empId, Long permId);
	void valideConge(Long empId, Long permId);
}
