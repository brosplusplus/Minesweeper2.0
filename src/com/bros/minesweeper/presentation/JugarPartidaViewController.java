package com.bros.minesweeper.presentation;

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
	 * 
	 */
	public void PrJugar() {
		JPV.mostrarIdentificacio();
	}
	
	/**
	 * 
	 * @param usuari
	 * @param password
	 * @throws Exception
	 *  [usernameNoExisteix]
	 *  [pwdIncorrecte]
	 *  [usuariNoJugador]
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
	
	//PrJugarPartida(String nomNivell)
	//PrBotoDret(Integer x, Integer y)
	//PrBotoEsq(Integer x, Integer y)
	//PrDobleBotoEsq(Integer x, Integer y)
	//PrSortir()
}
