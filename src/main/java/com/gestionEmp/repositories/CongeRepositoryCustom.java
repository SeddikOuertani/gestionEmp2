package com.gestionEmp.repositories;
import java.util.List;

import com.gestionEmp.entities.Conge;
public interface CongeRepositoryCustom  {
	public List<Conge> getListCongeByEtat(String etat);

}
