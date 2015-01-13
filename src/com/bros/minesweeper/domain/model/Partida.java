package com.bros.minesweeper.domain.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bros.minesweeper.datainterface.CtrlNivell;

/**
 * Partida represents a single game of minesweeper
 * 
 * @author Borja Arias
 * @version 0.1
 */

@Entity
@Table(name="Partida")
public class Partida {
	/**
	 * Partida own atributes
	 */
	@Id
	@GeneratedValue
	@Column(name="idPartida")
	private Integer idPartida;
	private Boolean estaAcabada;
	private Boolean estaGuanyada;
	private Integer nombreTirades;
	private Integer casellesPerDescobrir;
	
	/**
	 * Association attributes
	 */
	
	@OneToOne
	@JoinColumn(name="JugadorActual_username")
	private Jugador jugadorPartidaActual;
	@ManyToOne
	@JoinColumn(name="Jugador_username")
	private Jugador jugadorPartidaJugada;
	
	
	@ManyToOne
	@JoinColumn(name="nomNivell")
	private Nivell teNivell;
	
	@Transient
	private EstrategiaPuntuacio estrategia;
	@Transient
	private Integer puntuacio_temps;
	@Transient
	private Integer puntuacio_tirades;
	
	@OneToMany (targetEntity=Casella.class, mappedBy="idCasella")
	private List<Casella> taulell;
	@Transient
	private Integer nCols; //numero de columnes del taulell
	@Transient
	private Integer nRows; //numero de files del taulell

	public Partida(int id, Jugador jugName, String niv, 
			EstrategiaPuntuacio estrategiaEscollida) {
		this.idPartida = id;
		this.estaAcabada = false;
		this.estaGuanyada = false;
		this.nombreTirades = 0;
		this.taulell = new ArrayList<Casella>();
		this.jugadorPartidaActual = jugName;
		this.teNivell = CtrlNivell.get(niv);
		this.estrategia = estrategiaEscollida;
		
		Integer columnesDelNivell = this.teNivell.getNombreCasellesxFila();
		Integer filesDelNivell = this.teNivell.getNombreCasellesxColumna();
		
		this.inicialitzarCaselles(filesDelNivell, columnesDelNivell, this.teNivell.getNombreMines());
		this.assignarPuntuacio();			
	}

	public Integer getIdPartida() {
		return idPartida;
	}
	
	public void setIdPartida(Integer idPartida) {
		this.idPartida = idPartida;
	}
	
	public Boolean getEstaAcabada() {
		return estaAcabada;
	}
	
	public void setEstaAcabada(Boolean estaAcabada) {
		this.estaAcabada = estaAcabada;
	}
	
	public Boolean getEstaGuanyada() {
		return estaGuanyada;
	}
	
	public void setEstaGuanyada(Boolean estaGuanyada) {
		this.estaGuanyada = estaGuanyada;
	}
	
	public Integer getNombreTirades() {
		return nombreTirades;
	}
	
	public void setNombreTirades(Integer nombreTirades) {
		this.nombreTirades = nombreTirades;
	}
	
	public Integer getCasellesPerDescobrir() {
		return casellesPerDescobrir;
	}
	
	public void setCasellesPerDescobrir(Integer casellesPerDescobrir) {
		this.casellesPerDescobrir = casellesPerDescobrir;
	}
	
	public Jugador getJugadorPartidaActual() {
		return jugadorPartidaActual;
	}
	
	public void setJugadorPartidaActual(Jugador jugadorPartidaActual) {
		this.jugadorPartidaActual = jugadorPartidaActual;
	}
	
	private void setCasellaTaulell(int numF, int numC, Casella c) {
		int posicio = this.nCols*numF + numC;
		this.taulell.set(posicio, c);
	}
	private Casella getCasellaTaulell(int numF, int numC) {
		int posicio = this.nCols*numF + numC;
		return this.taulell.get(posicio);
	}
	
	public Jugador getJugadorPartidaJugada() {
		return jugadorPartidaJugada;
	}
	
	public void setJugadorPartidaJugada(Jugador jugadorPartidaJugada) {
		this.jugadorPartidaJugada = jugadorPartidaJugada;
	}
	
	public Nivell getTeNivell() {
		return teNivell;
	}
	
	public void setTeNivell(Nivell teNivell) {
		this.teNivell = teNivell;
	}
	
	public EstrategiaPuntuacio getEstrategia() {
		return estrategia;
	}
	
	public void setEstrategia(EstrategiaPuntuacio estrategia) {
		this.estrategia = estrategia;
	}
	
	public List<Casella> getTaulell() {
		return taulell;
	}
	
	public void setTaulell(ArrayList<Casella> taulell) {
		this.taulell = taulell;
	}
	
	public void marcarCasella(int numF, int numC) throws Exception{
		getCasellaTaulell(numF, numC).marcar();
	}
	
	public void desmarcarCasella (int numF, int numC) throws Exception {
		getCasellaTaulell(numF, numC).desmarcar();
	}
	
	public EstatPartida descobrirCasella (int numF, int numC) throws Exception {
		getCasellaTaulell(numF, numC).descobrirCasella();
		EstatPartida es = new EstatPartida();
		return es;
	}
	
	public void inicialitzarCaselles(Integer filesDelNivell, Integer columnesDelNivell, Integer numMines ) {
		for (int nF = 0; nF < filesDelNivell; ++nF) {
			for (int nC = 0; nC <  columnesDelNivell; ++nC) {
				Casella c = new Casella(nF, nC, this);
				this.taulell.add(c);
			}
		}
	}
	
	public void colocarMines(){
		Integer columnesDelNivell = this.teNivell.getNombreCasellesxFila();
		Integer filesDelNivell = this.teNivell.getNombreCasellesxColumna();
		Integer numMinesDelNivell = this.teNivell.getNombreMines();
		while(numMinesDelNivell > 0){
			Random rand = new Random();
			Integer x = rand.nextInt(filesDelNivell);
			Integer y = rand.nextInt(columnesDelNivell);
			Casella c = getCasella(x, y);
			if(!c.getTeMina()){
				c.setTeMina(true);
				for (int i = x-1; i < x+1; ++i) {
					for (int j = y-1; j <  y+1; ++j) {
						if(0 <= i && i < this.nRows && 0 <= j && j < this.nCols && !(x == i && y == j)){
							Casella c2 = getCasellaTaulell(i, j);
							if(!c2.tensMina()) c2.incrementaNumero();
							setCasellaTaulell(i, j, c2);
						}
					}
				}
				--numMinesDelNivell;
				setCasella(x, y, c);
			}			
		}
	}
	
	public void crearCaselles (Integer F, Integer C, Integer nM) {
		this.casellesPerDescobrir = F*C - nM;
		inicialitzarCaselles(F, C, nM);
		colocarMines();
	}
	
	public void assignarPuntuacio() {
		//TODO implement
	}
	
	/*public static void main(String[] args) throws Exception {
		Partida p = new Partida();
		EstatPartida es = p.descobrirCasella(0, 0);
		System.out.print(es.puntuacio);
	}*/
}
