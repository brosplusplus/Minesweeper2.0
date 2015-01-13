package com.bros.minesweeper.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="USUARIREGISTRAT")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class UsuariRegistrat{
	@Column(name="nom")
	private String nom;
	@Column(name="cognom")
	private String cognom;
	@Column(name="pwd")
	private String pwd;
	@Id
	@Column(name="username")
	private String username;
	
	public String getCognom() {
		return cognom;
	}
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
		
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
