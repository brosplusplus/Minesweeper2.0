package com.bros.minesweeper.domain.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.bros.minesweeper.db.CtrlJugador;
import com.bros.minesweeper.db.CtrlNivell;
import com.bros.minesweeper.domain.model.EstatPartida;
import com.bros.minesweeper.domain.model.EstrategiaPuntuacio;
import com.bros.minesweeper.domain.model.Jugador;
import com.bros.minesweeper.domain.model.Partida;
import com.bros.minesweeper.factory.FactoriaControladors;
import com.bros.minesweeper.factory.FactoriaEstrategiaPuntuacio;

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
	 * Methods
	 * @throws Exception 
	 */
	public void crearPartida (String nomNivell) {
		int id = this.partida.getIdPartida() + 1;
		String nivell = CtrlNivell.get(nomNivell).getNom();
		ArrayList<EstrategiaPuntuacio> estrategies = FactoriaEstrategiaPuntuacio.getAll();
		int index = new Random().nextInt(estrategies.size());
		EstrategiaPuntuacio estrategiaEscollida = estrategies.get(index);
		this.partida = new Partida(jugName, nivell, estrategiaEscollida);
	}
	
	
	public void marcarCasella (int numF, int numC) throws Exception {
		this.partida.marcarCasella(numF, numC);
	}
	
	public void desmarcarCasella (int numF, int numC) throws Exception {
		this.partida.desmarcarCasella(numF, numC);
	}
	
	public EstatPartida descobrirCasella (int numF, int numC) throws Exception {
		return this.partida.descobrirCasella(numF, numC);
	}
	
	public void FerAutenticacio(String userN,String passwd) throws Exception {
		CtrlJugador cj = FactoriaControladors.getCtrlJugador();
		if (!cj.exists(userN)) throw new Exception("L'usuari " + userN + " no es jugador");
		LoginUseCaseController lucc = new LoginUseCaseController();
		lucc.login(userN, passwd);
		this.setJugName(userN);
	}
	
	public ArrayList<HashMap<String, String> > obtenirNivells() throws Exception {
		ConsultarNivellUseCaseController cnucc = new ConsultarNivellUseCaseController();
		return cnucc.consultarNivells();
	}

}
