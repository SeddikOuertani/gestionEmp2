package com.gestionEmp.entities;

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
	private Date heureDeb;
	
	@Column(name="heureFin")
	private Date heureFin;
	
	@Column(name="etat")
	private String etat;
	
	@ManyToOne
	private Employe employe;
	
	public Permission(String raison, Date heureDeb, Date heureFin) {
		this.raison = raison;
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
		this.etat = "attendu";
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

	public Date getHeureDeb() {
		return heureDeb;
	}

	public void setHeureDeb(Date heureDeb) {
		this.heureDeb = heureDeb;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	public String isEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
}
