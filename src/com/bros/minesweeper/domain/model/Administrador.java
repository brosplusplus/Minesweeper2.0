package com.bros.minesweeper.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="ADMINISTRADOR")
public class Administrador extends UsuariRegistrat {
	@Column(name="tlfn")
	private String tlfn;

	public String getTlfn() {
		return tlfn;
	}

	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
	}
	
}
