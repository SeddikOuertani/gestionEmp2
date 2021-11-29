package com.gestionEmp.repositories;

import java.util.List;

import com.gestionEmp.entities.Permission;

public interface PermissionRepositoryCustom {

	List<Permission> findPermissionsByEmpId(Long empId);
	int saveWithEmpId(Permission perm, Long empId);
	List<Permission> findAllPermissions();
}
