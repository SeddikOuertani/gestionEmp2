package com.gestionEmp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Conge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idConge;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="dateDebut")
	private Date dateDebut;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="dateFin")
	private Date dateFin;
	
	//nombre de jour !!
	@Column(name="periode")
	private int periode;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	private Employe employe;
	
	
	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Conge() {
		super();
	}

	public Conge(Date dateDebut, Date dateFin, int periode, String description) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.periode = periode;
		this.description = description;
	}
	
	public Long getIdConge() {
		return idConge;
	}
	public void setIdConge(Long idConge) {
		this.idConge=idConge;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public int getPeriode() {
		return periode;
	}
	public void setPeriode(int periode) {
		this.periode = periode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
