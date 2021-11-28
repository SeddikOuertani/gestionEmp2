package com.gestionEmp.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPerm;
	
	@Column(name="raison")
	private String raison;
	
	@Column(name="heureDeb")
	private String heureDeb;
	
	@Column(name="heureFin")
	private String heureFin;
	
	@Column(name="description")
	private String description;
	
	@Column(name="etat")
	private String etat;
	
	@Column(name="validated")
	private boolean validated;
	
	@ManyToOne
	private Employe employe;
	
	public Permission(String raison,String description, String heureDeb, String heureFin, boolean validated) {
		this.raison = raison;
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
		this.description = description;
		this.etat = "En attente";
		this.validated = false;
	}
	
	public Permission() {
		
	}

	public Long getIdPerm() {
		return idPerm;
	}

	public String getRaison() {
		return raison;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public void setIdPerm(Long idPerm) {
		this.idPerm = idPerm;
	}

	public String getHeureDeb() {
		return heureDeb;
	}

	public void setHeureDeb(String heureDeb) {
		this.heureDeb = heureDeb;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
}
