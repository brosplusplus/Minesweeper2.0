package com.bros.minesweeper.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column (name="idCasella")
	private String idCasella;
	
	@ManyToOne
	@JoinColumn(name="idPartida")
	private Partida partida;
	private Integer numeroFila;
	private Integer numeroColumna;
	private Integer numero;
	private Boolean estaDescoberta;
	private Boolean estaMarcada;
	private Boolean teMina;
	
	public Casella(){
		
	}
	
	public Casella(int nF, int nC, Partida partida) {
		this.numeroFila = nF;
		this.numeroColumna = nC;
		this.estaDescoberta = false;
		this.estaMarcada = false;
		this.teMina = false;
		this.partida = partida;
		this.idCasella = partida+":"+nF+":"+nC;
	}
	
	public void setPartida(Partida p) {
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

	/**
	 * Funcio que marca la casella.
	 * @throws Exception
	 * 					casellaJaDescoberta: es vol marcar una casella que esta descoberta.
	 * 					casellaJaMarcada: es vol marcar una casella que esta marcada.
	 */
	public void marcar() throws Exception{
		if (getEstaDescoberta()) throw new Exception("La casella esta descoberta i no es pot marcar");
		if (getEstaMarcada()) throw new Exception("La casella ja esta marcada");
		setEstaMarcada(true);
	}
	
	/**
	 * Funcio que desmarca la casella.
	 * @throws Exception
	 * 					casellaJaDescoberta: es vol desmarcar una casella que esta descoberta.
	 * 					casellaJaDesmarcada: es vol desmarcar una casella que esta desmarcada.
	 */
	public void desmarcar() throws Exception{
		if (getEstaDescoberta()) throw new Exception("La casella esta descoberta i no es pot desmarcar");
		if (!getEstaMarcada()) throw new Exception("La casella ja esta desmarcada");
		setEstaMarcada(false);
	}
	
	/**
	 * Funcio per saber si una casella conte una mina.
	 * @return true si te una mina, false altrament.
	 */
	public Boolean tensMina() {
		return this.getTeMina();
	}

	/**
	 * Funcio per saber si una casella esta descoberta.
	 * @return true si esta descoberta, false altrament.
	 */
	public Boolean estaDescoberta() {
		return this.getEstaDescoberta();
	}
	
	/**
	 * Funcio que descobreix la casella.
	 * @throws Exception
	 * 					casellaMarcada: es vol marcar una casella ja marcada
	 * 					casellaJaDescoberta: es vol descobrir una casella ja descoberta.
	 */
	public void descobrir() throws Exception {
		if (getEstaDescoberta()) throw new Exception("La casella esta descoberta");
		if (getEstaMarcada()) throw new Exception("La casella esta marcada i no es pot descobrir");
		setEstaDescoberta(true);
	}

	/**
	 * Funcio per incrementar el numero que tindra la casella en el 
	 * moment de ser descoberta (el numero un cop iniciada la partida
	 * ha de ser la suma total de mines que te la casella a les caselles
	 * del voltant [0-8]).
	 */
	public void incrementaNumero() {
		if (this.numero == null) numero = 0;
		++this.numero;
	}

}
