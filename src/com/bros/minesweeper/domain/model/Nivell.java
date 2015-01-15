package com.bros.minesweeper.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Nivell represents a level of a minesweeper game
 * @author Borja Arias
 * @version 0.1
 */

@Entity
@Table(name="Nivell")
public class Nivell {
	private String nom;
	/**
	 * Number of columns
	 */
	private Integer nombreCasellesxFila;
	/**
	 * Number of rows
	 */
	private Integer nombreCasellesxColumna; 
	
	
	private Integer nombreMines;

	/**
	 * Association attributes
	 */
	
	@Id
	@Column(name=("nomNivell"))
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNombreCasellesxFila() {
		return nombreCasellesxFila;
	}

	public void setNombreCasellesxFila(Integer nombreCasellesxFila) {
		this.nombreCasellesxFila = nombreCasellesxFila;
	}

	public Integer getNombreCasellesxColumna() {
		return nombreCasellesxColumna;
	}

	public void setNombreCasellesxColumna(Integer nombreCasellesxColumna) {
		this.nombreCasellesxColumna = nombreCasellesxColumna;
	}

	public Integer getNombreMines() {
		return nombreMines;
	}

	public void setNombreMines(Integer nombreMines) {
		this.nombreMines = nombreMines;
	}

	public int obteNombreCasellesxColumna() {
		return this.getNombreCasellesxColumna();
	}
	
	public int obteNombreCasellesxFila() {
		return this.getNombreCasellesxFila();
	}

}
