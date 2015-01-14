package com.bros.minesweeper.factory;

import com.bros.minesweeper.db.CtrlAdministrador;
import com.bros.minesweeper.db.CtrlCasella;
import com.bros.minesweeper.db.CtrlJugador;
import com.bros.minesweeper.db.CtrlNivell;
import com.bros.minesweeper.db.CtrlPartida;
import com.bros.minesweeper.db.CtrlUsuariRegistrat;

/**
 * Factoria dels controladors de persistencia.
 * @author Borja Arias
 */

public class FactoriaControladors extends AbstractFactory{

	public static CtrlUsuariRegistrat getCtrlUsuariRegistrat() {
		return new CtrlUsuariRegistrat();
	}

	public static CtrlNivell getCtrlNivell() {
		return new CtrlNivell();
	}

	public static CtrlJugador getCtrlJugador() {
		return new CtrlJugador();
	}
	
	public static CtrlPartida getCtrlPartida() {
		return new CtrlPartida();
	}
	
	public static CtrlCasella getCtrlCasella() {
		return new CtrlCasella();
	}

	public static CtrlAdministrador getCtrlAdministrador() {
		return new CtrlAdministrador();
	}
}
