package com.bros.minesweeper.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe per representar un Jugador.
 * @author Alex More
 *
 */
@Entity
@Table(name="Jugador")
public class Jugador extends UsuariRegistrat{
	@Column(name="email")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
