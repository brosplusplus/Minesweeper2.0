package com.bros.minesweeper.domain.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.bros.minesweeper.db.CtrlJugador;
import com.bros.minesweeper.domain.model.EstatPartida;
import com.bros.minesweeper.domain.model.Jugador;
import com.bros.minesweeper.domain.model.Partida;
import com.bros.minesweeper.factory.FactoriaControladors;

/**
 *  JugarPartidaUseCaseController representa el cas d'us de Jugar Partida
 * @author Alex More
 *
 */
public class JugarPartidaUseCaseController {

	/**
	 * Association attributes
	 */
	private Partida partida;
	private Jugador jugName;
	
	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
	public String getJugName() {
		return jugName.getNom();
	}

	public void setJugName(String jugName) {
		this.jugName.setNom(jugName);
	}
	
	/**
	 * Crea una partida amb el Nivell nomnivell.
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws Exception 
	 */
	public void crearPartida (String nomNivell) {
		String nivell = FactoriaControladors.getCtrlNivell().get(nomNivell).getNom();
		this.partida = new Partida(jugName, nivell);
	}
	
	/**
	 * Marquem una casella del taulell.
	 * @param numF fila de la casella.
	 * @param numC columna de la casella.
	 * @throws Exception
	 */
	public void marcarCasella (int numF, int numC) throws Exception {
		this.partida.marcarCasella(numF, numC);
	}
	
	/**
	 * Desmarquem una casella del taulell.
	 * @param numF fila de la casella.
	 * @param numC columna de la casella.
	 * @throws Exception
	 */
	public void desmarcarCasella (int numF, int numC) throws Exception {
		this.partida.desmarcarCasella(numF, numC);
	}
	
	/**
	 * Descobrim una casella del taulell.
	 * @param numF
	 * @param numC
	 * @return retorna un EstatPartida amb la situacio actual de la partida.
	 * @throws Exception
	 */
	public EstatPartida descobrirCasella (int numF, int numC) throws Exception {
		return this.partida.descobrirCasella(numF, numC);
	}
	
	/**
	 * Funcio per validar l'acces d'un usuari al sistema.
	 * @param userN nom d'usuari.
	 * @param passwd contrasenya de l'usuari.
	 * @throws Exception
	 */
	public void FerAutenticacio(String userN,String passwd) throws Exception {
		CtrlJugador cj = FactoriaControladors.getCtrlJugador();
		if (!cj.exists(userN)) throw new Exception("L'usuari " + userN + " no es jugador");
		LoginUseCaseController lucc = new LoginUseCaseController();
		lucc.login(userN, passwd);
		jugName = cj.get(userN);
	}
	
	/**
	 * Funcio per obtenir tots els nivells de la DB.
	 * @return retorna una llista amb els nivells.
	 * @throws Exception
	 */
	public ArrayList<HashMap<String, String> > obtenirNivells() throws Exception {
		ConsultarNivellUseCaseController cnucc = new ConsultarNivellUseCaseController();
		return cnucc.consultarNivells();
	}

}
