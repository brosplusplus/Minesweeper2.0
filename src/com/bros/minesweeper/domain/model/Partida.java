package com.bros.minesweeper.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
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

import com.bros.minesweeper.factory.FactoriaControladors;
import com.bros.minesweeper.factory.FactoriaEstrategiaPuntuacio;
import com.bros.minesweeper.utils.Pair;
import com.bros.minesweeper.utils.debug;

/**
 * Partida representa una partida al joc BuscaMines
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
	
	@OneToMany (targetEntity=Casella.class, mappedBy="partida")
	private List<Casella> taulell;
	@Transient
	private Integer nCols; //numero de columnes del taulell
	@Transient
	private Integer nRows; //numero de files del taulell
	@Transient
	private Integer nMines; //numero de mines del taulell

	public Partida() {}
	
	public Partida(Jugador jugName, Nivell niv, EstrategiaPuntuacio estrat){
		this.estaAcabada = false;
		this.estaGuanyada = false;
		this.nombreTirades = 0;
		this.taulell = new ArrayList<Casella>();
		this.jugadorPartidaActual = jugName;
		this.teNivell = niv;
		
		this.nCols = this.teNivell.getNombreCasellesxFila();
		this.nRows = this.teNivell.getNombreCasellesxColumna();
		this.nMines = this.teNivell.getNombreMines();
		
		this.inicialitzarCaselles(nRows, nCols);
		this.estrategia = estrat;
	}
	
	public Partida(Jugador jugName, String niv) {
		this.estaAcabada = false;
		this.estaGuanyada = false;
		this.nombreTirades = 0;
		this.taulell = new ArrayList<Casella>();
		this.jugadorPartidaActual = jugName;
		this.teNivell = FactoriaControladors.getCtrlNivell().get(niv);
		
		this.nCols = this.teNivell.getNombreCasellesxFila();
		this.nRows = this.teNivell.getNombreCasellesxColumna();
		this.nMines = this.teNivell.getNombreMines();
		
		this.inicialitzarCaselles(nRows, nCols);
		try {
			this.estrategia = assignarEstrategiaPuntuacio();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
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
	
	public Casella getCasellaTaulell(int numF, int numC) {
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
	
	/**
	 * Aquesta funcio marca la casella (numF, numC).
	 * @param numF numero de fila de la casella.
	 * @param numC numero de columna de la casella.
	 * @throws Exception
	 * 					casellaJaDescoberta: es vol marcar una casella que esta descoberta.
	 * 					casellaJaMarcada: es vol marcar una casella que esta marcada.
	 */
	public void marcarCasella(int numF, int numC) throws Exception{
		getCasellaTaulell(numF, numC).marcar();
	}
	
	
	/**
	 * Aquesta funcio desmarca la casella (numF, numC).
	 * @param numF numero de fila de la casella.
	 * @param numC numero de columna de la casella.
	 * @throws Exception
	 * 					casellaJaDescoberta: es vol desmarcar una casella que esta descoberta.
	 * 					casellaJaDesmarcada: es vol desmarcar una casella que esta desmarcada.
	 */
	public void desmarcarCasella (int numF, int numC) throws Exception {
		getCasellaTaulell(numF, numC).desmarcar();
	}
	
	/**
	 * Descobreix la casella (numF,numC) i totes les possibles del seu voltant en cas
	 * que sigui possible (numero == null)
	 * @param numF coordenada fila de la casella.
	 * @param numC coordenada columna de la casella.
	 * @return retorna un EstatPartida que representa la situacio actual de la partida.
	 * @throws Exception
	 * 					casellaMarcada: es vol marcar una casella ja marcada
	 * 					casellaJaDescoberta: es vol descobrir una casella ja descoberta.
	 */
	public EstatPartida descobrirCasella (int numF, int numC) throws Exception {
		EstatPartida es = new EstatPartida();
		Casella c = getCasellaTaulell(numF, numC);
		boolean teMina = c.tensMina();
		if (teMina) {
			es.acabada = true;
			es.guanyada = false;
		}
		else if (!teMina && this.casellesPerDescobrir == 1){
			es.acabada = true;
			es.guanyada = true;
		}
		c.descobrir();
		this.casellesPerDescobrir--;
		ArrayList<Pair<Integer, Integer> > l = new ArrayList<Pair<Integer, Integer> >();
		if (c.getNumero() == null) 
			for (int i = numF-1; i <= numF+1; ++i) 
				for (int j = numC-1; j <=  numC+1; ++j) 
					if(0 <= i && i < this.nRows && 0 <= j && j < this.nCols && !(numF == i && numC == j)){
						l.addAll(descobrirCasellesVoltant(i, j));
		}
		es.casellesPerDescobrir = l;
		this.casellesPerDescobrir -= l.size();
		if (this.casellesPerDescobrir == 0) {
			es.acabada = true;
			es.guanyada = true;
		}
		if (es.acabada != null && es.acabada
				&& es.guanyada != null && es.guanyada) {
			es.puntuacio = computaPuntuacio();
		}
		return es;
	}
	
	/**
	 * 
	 * Aquesta funcio calcula la puntuacio de la partida
	 * @return els punts que l'usuari ha aconseguit en la partida.
	 * 
	 */
	private Integer computaPuntuacio() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Aquesta funcio inicialitza les caselles d'una partida. 
	 * @param filesDelNivell numero total de files que te el taulell
	 * @param columnesDelNivell numero total de columnes que te el taulell
	 */
	public void inicialitzarCaselles(Integer filesDelNivell, Integer columnesDelNivell) {
		for (int nF = 0; nF < filesDelNivell; ++nF) {
			for (int nC = 0; nC <  columnesDelNivell; ++nC) {
				Casella c = new Casella(nF, nC, this);
				this.taulell.add(c);
			}
		}
	}
	
	/**
	 * Posa totes les mines en el taulell de manera aleatòria.
	 */
	public void colocarMines(){
		Integer numMinesDelNivell = this.nMines;
		while(numMinesDelNivell > 0){
			Random rand = new Random();
			Integer x = rand.nextInt(this.nRows);
			Integer y = rand.nextInt(this.nCols);
			Casella c = getCasellaTaulell(x, y);
			if(!c.tensMina()){
				c.setTeMina(true);
				for (int i = x-1; i <= x+1; ++i) {
					for (int j = y-1; j <=  y+1; ++j) {
						if(0 <= i && i < this.nRows && 0 <= j && j < this.nCols && !(x == i && y == j)){
							Casella c2 = getCasellaTaulell(i, j);
							if(!c2.tensMina()) c2.incrementaNumero();
						}
					}
				}
				--numMinesDelNivell;
			}			
		}
	}
	
	
	/**
	 * Funcio que crea les caselles d'una partida.
	 * @param F numero de files que te el taulell.
	 * @param C numero de columnes que te el taulell.
	 * @param nM numero de mines que te el taulell.
	 */
	public void crearCaselles (Integer F, Integer C, Integer nM) {
		this.casellesPerDescobrir = F*C - nM;
		inicialitzarCaselles(F, C);
		colocarMines();
	}
	
	public ArrayList<Pair<Integer, Integer>> descobrirCasellesVoltant(int numF, int numC) {
		Casella c = getCasellaTaulell(numF, numC);
		Boolean ambMina = c.getTeMina();
		Boolean descoberta = c.getEstaDescoberta();
		Boolean marcada = c.getEstaMarcada();
		ArrayList<Pair<Integer, Integer>> l = new ArrayList<Pair<Integer, Integer>>();
		if(!ambMina && !descoberta && !marcada) {
			c.setEstaDescoberta(true);
			Pair<Integer, Integer> p = new Pair<Integer, Integer> (numF, numC);
			l.add(p);
			if(c.getNumero() == null) {
				for (int i = numF-1; i <= numF+1; ++i) {
					for (int j = numC-1; j <=  numC+1; ++j) {
						if(0 <= i && i < this.nRows && 0 <= j && j < this.nCols && !(numF == i && numC == j)){
							l.addAll(descobrirCasellesVoltant(i, j));	
						}
					}
				}
			}
		}
		return l;
	}
	
	/**
	 * Funcio que selecciona una estrategia per comptar els punts en la partida.
	 * @return retorna una estrategia que hi ha en el sistema de manera aleatoria.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public EstrategiaPuntuacio assignarEstrategiaPuntuacio() throws InstantiationException, IllegalAccessException {
		ArrayList<EstrategiaPuntuacio> estrategies = FactoriaEstrategiaPuntuacio.getAll();
		Random rand = new Random();
		int i = rand.nextInt(estrategies.size());
		return estrategies.get(i);
	}
	
	/*public static void main(String[] args) throws Exception {
		Partida p = new Partida();
		EstatPartida es = p.descobrirCasella(0, 0);
		System.out.print(es.puntuacio);
	}*/
}
