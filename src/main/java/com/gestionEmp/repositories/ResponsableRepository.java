package com.gestionEmp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionEmp.entities.Responsable;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Long>, ResponsableRepositoryCustom {

	
}
