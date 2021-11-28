package com.gestionEmp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Responsable extends Employe{

	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Responsable(String login, String nom, String prenom, String numTel, String email, int congeRestant) {
		super(login, nom, prenom, numTel, email, email, congeRestant);
	}
	
	public Responsable() {
		
	}
	
}