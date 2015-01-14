package com.bros.minesweeper.presentation;

import java.util.ArrayList;
import java.util.HashMap;

import com.bros.minesweeper.domain.controller.JugarPartidaUseCaseController;
import com.bros.minesweeper.domain.model.EstatPartida;
import com.bros.minesweeper.utils.Pair;

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

    public JugarPartidaViewController() {
    	JPUCC = new JugarPartidaUseCaseController();
        JPV = new JugarPartidaView(this);
    }
    
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
	
	public void IniciAplicacio() {
		JPV.Inici();
	}
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
			JPUCC.FerAutenticacio(usuari, password);
			JPV.mostrarMenuPrincipal(usuari);
	}
	
	/**
	 * Premem el boto de Jugar per anar a la vista de seleccionar nivell
	 * @throws Exception
	 *  [noHiHaNivells]	No hi han nivells a la BD del sistema
	 */
	public void PrAccioJugar() throws Exception {
			ArrayList<HashMap<String, String> > nivells = JPUCC.obtenirNivells();
			String usuari = JPUCC.getJugName();
			JPV.mostrarNivells(usuari, nivells);
	}
	
	/**
	 * Premem el boto de Jugar per començar a jugar la partida
	 * @param nomNivell	Es el nom del nivell seleccionat
	 */
	public void PrJugarPartida(String nomNivell) {
		JPUCC.crearPartida(nomNivell);
		int files = JPUCC.getPartida().getTeNivell().getNombreCasellesxColumna();
		int columnes = JPUCC.getPartida().getTeNivell().getNombreCasellesxFila();
		JPV.mostrarPartida(files, columnes);
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
			ArrayList<Pair<Integer,Integer>> l = new ArrayList<Pair<Integer, Integer>>();
			l.add(new Pair<Integer, Integer>(x, y));
			JPV.actualitzaTaulell(l, "marcar");
			JPV.mostrarMissatge("S'ha marcat la casella ("+x+","+y+")");
		}
		catch(Exception e){
			JPV.mostrarMissatge(e.getMessage());
		}
	}
	
	public void PrBotoEsq(Integer x, Integer y) {
		try {
			JPUCC.desmarcarCasella(x, y);
			ArrayList<Pair<Integer,Integer>> l = new ArrayList<Pair<Integer, Integer>>();
			l.add(new Pair<Integer, Integer>(x, y));
			JPV.actualitzaTaulell(l, "desmarcar");
			JPV.mostrarMissatge("S'ha desmarcat la casella ("+x+","+y+")");
		}
		catch (Exception e) {
			JPV.mostrarMissatge(e.getMessage());
		}
	}
	public void PrDobleBotoEsq(Integer x, Integer y) {
		try {
			EstatPartida ep = JPUCC.descobrirCasella(x, y);
			JPV.actualitzaTaulell(ep.casellesPerDescobrir, "descobrir");
			JPV.mostrarMenuPrincipal("S'ha descobert la casella("+x+","+y+")");
			boolean acabada = ep.acabada;
			boolean guanyada = ep.guanyada;
			if (acabada && guanyada) {
				JPV.mostrarMissatgeVictoria(ep.puntuacio);
			}
			else if (acabada && !guanyada) {
				JPV.mostrarMissatgeDerrota();
			}
			
		}
		catch (Exception e) {
			JPV.mostrarMissatge(e.getMessage());
		}
	}
	public void PrSortir() {
		JPV.tancar();
	}
}
