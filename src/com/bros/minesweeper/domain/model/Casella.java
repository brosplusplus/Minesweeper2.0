package com.bros.minesweeper.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Casella", uniqueConstraints={
		@UniqueConstraint(columnNames={"idPartida", "numeroFila","numeroColumna"})
})
public class Casella {
	@Id
	@GeneratedValue
	@Column (name="idCasella")
	private Integer idCasella;
	
	@ManyToOne	
	@JoinColumn(name="idPartida")
	private Partida partida;
	private Integer numeroFila;
	private Integer numeroColumna;
	private Integer numero;
	private Boolean estaDescoberta;
	private Boolean estaMarcada;
	private Boolean teMina;
	
	public void setPartida(Partida p)
	{
		this.partida = p;
	}
	
	public Integer getNumeroFila() {
		return numeroFila;
	}
	public void setNumeroFila(Integer numeroFila) {
		this.numeroFila = numeroFila;
	}
	public Integer getNumeroColumna() {
		return this.numeroColumna;
	}
	public void setNumeroColumna(Integer numeroColumna) {
		this.numeroColumna = numeroColumna;
	}
	public Boolean getEstaDescoberta() {
		return estaDescoberta;
	}
	public void setEstaDescoberta(Boolean estaDescoberta) {
		this.estaDescoberta = estaDescoberta;
	}
	public Boolean getEstaMarcada() {
		return estaMarcada;
	}
	public void setEstaMarcada(Boolean estaMarcada) {
		this.estaMarcada = estaMarcada;
	}
	public Boolean getTeMina() {
		return teMina;
	}
	public void setTeMina(Boolean teMina) {
		this.teMina = teMina;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer Numero) {
		this.numero = Numero;
	}

	public void marcar() throws Exception{
		if (getEstaDescoberta()) throw new Exception("La casella esta descoberta i no es pot marcar");
		if (getEstaMarcada()) throw new Exception("La casella ja esta marcada");
		setEstaMarcada(true);
	}
	
	public void desmarcar() throws Exception{
		if (getEstaDescoberta()) throw new Exception("La casella esta descoberta i no es pot desmarcar");
		if (!getEstaMarcada()) throw new Exception("La casella ja esta desmarcada");
		setEstaMarcada(false);
	}
	
	public Boolean tensMina() {
		return this.getTeMina();
	}

	public Boolean estaDescoberta() {
		return this.getEstaDescoberta();
	}
	
	public void descobrirCasella() throws Exception {
		if (getEstaDescoberta()) throw new Exception("La casella esta descoberta");
		if (getEstaMarcada()) throw new Exception("La casella esta marcada i no es pot descobrir");
		setEstaDescoberta(true);
	}

	public void incrementaNumero() {
		++this.numero;
	}
}
