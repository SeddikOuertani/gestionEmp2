package com.gestionEmp.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="login")
	private String login;
	
	@Column(name="motDePasse")
	private String motDePasse;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="numTel")
	private String numTel;
	
	@Column(name="email")
	private String email;
	
	@Column(name="dateDernPermission")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateDernPermission;
	
	@Column(name="congeRestant")
	private int congeRestant;
	
	@OneToMany(mappedBy = "employe")
	private List<Conge> congeList = new ArrayList<Conge>();
	
	@OneToMany(mappedBy = "employe")
	private List<Permission> permList = new ArrayList<Permission>();
	
	public Employe(String login, String motDePasse, String nom, String prenom, String numTel, String email, int congeRestant) {
		this.login = login;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
		this.email = email;
		this.congeRestant = congeRestant;
	}
	
	public Employe() {
		this.prenom ="";
		this.nom = "";
		this.email = "";
		this.numTel = "";
		this.congeRestant = 0;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCongeRestant() {
		return congeRestant;
	}

	public void setCongeRestant(int congeRestant) {
		this.congeRestant = congeRestant;
	}

	public List<Conge> getCongeList() {
		return congeList;
	}

	public void setCongeList(List<Conge> congeList) {
		this.congeList = congeList;
	}

	public List<Permission> getPermList() {
		return permList;
	}

	public void setPermList(List<Permission> permList) {
		this.permList = permList;
	}
	
	
}
