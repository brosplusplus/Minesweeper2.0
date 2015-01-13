package com.bros.minesweeper.presentation;

import java.util.ArrayList;
import java.util.HashMap;

import com.bros.minesweeper.domain.controller.JugarPartidaUseCaseController;

/**
 * Controlador de la vista del joc
 * 
 * @author Alejandro Martinez Romero
 *
 */
public class JugarPartidaViewController {
	
	/**
	 * Atributs d'associacio
	 */
	private JugarPartidaUseCaseController JPUCC;
	private JugarPartidaView JPV;

	public JugarPartidaUseCaseController getJPUCC() {
		return JPUCC;
	}

	public void setJPUCC(JugarPartidaUseCaseController jPUCC) {
		JPUCC = jPUCC;
	}

	public JugarPartidaView getView() {
		return JPV;
	}

	public void setView(JugarPartidaView jPV) {
		JPV = jPV;
	}

	/**
	 * Metodes
	 */
	
	/**
	 * Premem el boto de Jugar per anar a la vista d'identificacio
	 */
	public void PrJugar() {
		JPV.mostrarIdentificacio();
	}
	
	/**
	 * Premem el boto de Entrar per fer el Login
	 * @param usuari	Es el nom d'usuari del jugador
	 * @param password	Es la contrasenya del compte del jugador
	 * @throws Exception
	 *  [usernameNoExisteix]	El nom d'usuari no existeix al sistema
	 *  [pwdIncorrecte]			La contrassenya indroduida no es valida per al nom d'usuari
	 *  [usuariNoJugador]		El nom d'usuari introduit no pertany al de un Jugador
	 */
	public void PrEntrar(String usuari, String password) throws Exception {
		try{
			JPUCC.FerAutenticacio(usuari, password);
			JPV.mostrarMenuPrincipal();
		}
		catch(Exception e){
			JPV.mostrarMissatge(e.getMessage());
		}
		
	}
	
	/**
	 * Premem el boto de Jugar per anar a la vista de seleccionar nivell
	 * @throws Exception
	 *  [noHiHaNivells]	No hi han nivells a la BD del sistema
	 */
	public void PrAccioJugar() throws Exception {
		try {
			ArrayList<HashMap<String, String> > nivells = JPUCC.obtenirNivells();
			String usuari = JPUCC.getJugName();
			JPV.mostrarNivells(usuari, nivells);
		}
		catch(Exception e){
			JPV.mostrarMissatge(e.getMessage());
		}
	}
	
	/**
	 * Premem el boto de Jugar per començar a jugar la partida
	 * @param nomNivell	Es el nom del nivell seleccionat
	 */
	public void PrJugarPartida(String nomNivell) {
		JPUCC.crearPartida(nomNivell);
		JPV.mostrarPartida();
	}
	
	/**
	 * Utilitzem el boto dret per a marcar una casella
	 * @param x	La fila de la casella seleccionada
	 * @param y La columna de la casella seleccionada
	 * @throws Exception
	 *  [casellaJaMarcada]		La casella que s'intenta marcar, ja esta marcada
	 *  [casellaJaDescoberta]	La casella que s'intenta marcar, esta descoberta
	 */
	public void PrBotoDret(Integer x, Integer y) throws Exception {
		try {
			JPUCC.marcarCasella(x, y);
			// TODO falta capturar l'event
			JPV.actualitzaTaulell();
			JPV.mostrarMissatge("S'ha marcat la casella ("+x+","+y+")");
		}
		catch(Exception e){
			JPV.mostrarMissatge(e.getMessage());
		}
	}
	
	//PrBotoEsq(Integer x, Integer y)
	//PrDobleBotoEsq(Integer x, Integer y)
	//PrSortir()
}
