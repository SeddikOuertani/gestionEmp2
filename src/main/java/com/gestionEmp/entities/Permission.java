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
	
	@Column(name="description")
	private String description;
	
	@Column(name="heureDeb")
	private String heureDeb;
	
	@Column(name="heureFin")
	private Date heureFin;
	
	@Column(name="etat")
	private String etat;
	
	@ManyToOne
	private Employe employe;
	
	private SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
	
	public Permission(String raison, Date heureFin) {
		this.raison = raison;
		this.heureDeb = localDateFormat.format(new Date());
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
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIdPerm(Long idPerm) {
		this.idPerm = idPerm;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}

	public String getHeureDeb() {
		return heureDeb;
	}

	public void setHeureDeb(String heureDeb) {
		this.heureDeb = heureDeb;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
}
