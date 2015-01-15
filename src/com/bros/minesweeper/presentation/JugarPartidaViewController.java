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
    
    /**
     * Getters i Setters
     */
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
	 * Metodes de la Classe
	 */
	
	/**
	 * Metode que crida a la vista de l'aplicacio per a que aquesta s'inicii
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
	public void PrEntrar(String usuari, String password){
		try {	
		JPUCC.FerAutenticacio(usuari, password);
		JPV.mostrarMenuPrincipal(usuari);
		}
		catch (Exception e){
			JPV.mostrarMissatge(e.getMessage());
		}
	}
	
	/**
	 * Premem el boto de Jugar per anar a la vista de seleccionar nivell
	 * @throws Exception
	 *  [noHiHaNivells]	No hi han nivells a la BD del sistema
	 */
	public void PrAccioJugar() {
		try {	
		ArrayList<HashMap<String, String> > nivells = JPUCC.obtenirNivells();
		String usuari = JPUCC.getJugName();
		JPV.mostrarNivells(usuari, nivells);
		}
		catch (Exception e){
			JPV.mostrarMissatge(e.getMessage());
		}
	}
	
	/**
	 * Premem el boto de Jugar per començar a jugar la partida
	 * @param nomNivell	Es el nom del nivell seleccionat
	 */
	public void PrJugarPartida(String nomNivell) {
		JPUCC.crearPartida(nomNivell);
		int files = JPUCC.obteCasellesxColumna();
		int columnes = JPUCC.obteCasellesxFila();
		JPV.mostrarPartida(files, columnes);
	}
	
	/**
	 * Utilitzem el boto dret per a marcar una casella
	 * @param index	Es l'index de la casella sobre la que es fa l'acció
	 * @throws Exception
	 *  [casellaJaMarcada]		La casella que s'intenta marcar, ja esta marcada
	 *  [casellaJaDescoberta]	La casella que s'intenta marcar, esta descoberta
	 */
	public void PrBotoDret(Integer index) {
		int x,y, files;
		files = JPUCC.obteCasellesxColumna();
		x = index/files;
		y = index%files;
		try {
			JPUCC.marcarCasella(x, y);
			ArrayList<Pair<Integer, EstatCasella>> dataCell = 
					new ArrayList<Pair<Integer, EstatCasella>>();
			
			dataCell.add(new Pair<Integer, EstatCasella>(index, EstatCasella.MARCADA));
			
			JPV.actualitzaTaulell(dataCell);
			JPV.mostrarMissatge("S'ha marcat la casella ("+x+","+y+")");
		}
		catch(Exception e){
			JPV.mostrarMissatge(e.getMessage());
		}
	}
	
	/**
	 * Utilitzem el boto esquerre per desmarcar una casella
	 * @param index  Es l'index de la casella sobre la que es fa l'acció
	 * @throws Exception
	 *  [casellaJaMarcada]		La casella que s'intenta marcar, ja esta marcada
	 *  [casellaJaDescoberta]	La casella que s'intenta marcar esta descoberta
	 */
	public void PrBotoEsq(Integer index) {
		int x,y, files;
		files = JPUCC.obteCasellesxColumna();
		
		x = index/files;
		y = index%files;
		try {
			JPUCC.desmarcarCasella(x, y);
			ArrayList<Pair<Integer, EstatCasella>> dataCell = 
					new ArrayList<Pair<Integer, EstatCasella>>();
			
			dataCell.add(new Pair<Integer, EstatCasella>(index, EstatCasella.DESMARCADA));
			
			JPV.actualitzaTaulell(dataCell);
			JPV.mostrarMissatge("S'ha desmarcat la casella ("+x+","+y+")");
		}
		catch (Exception e) {
			JPV.mostrarMissatge(e.getMessage());
		}
	}
	
	/**
	 * Utilitzem dos cops el boto dret del ratoli per descobrir una casella
	 * @param index  Es l'index de la casella sobre la que es fa l'acció
	 * @throws Exception
	 *  [casellaJaDescoberta]	La casella que s'intenta descobrir, ja esta descoberta
	 *  [casellaMarcada]		La casella que s'intenta descobrir esta marcada
	 */
	public void PrDobleBotoEsq(Integer index) {
		int x,y, files;
		files = JPUCC.obteCasellesxColumna();
		x = index/files;
		y = index%files;
		try {
			EstatPartida ep = JPUCC.descobrirCasella(x, y);
			
			ArrayList<Pair<Integer, EstatCasella>> dataCell = 
					new ArrayList<Pair<Integer, EstatCasella>>();
			
			dataCell.add(new Pair<Integer, EstatCasella>(index, consultaEstatCasella(x, y)));
			
			for (int i = 0; i < ep.casellesPerDescobrir.size(); ++i) {
				Pair<Integer, Integer> casellaVoltant = ep.casellesPerDescobrir.get(i);
				Integer indexVolt = casellaVoltant.getFirst()*files+casellaVoltant.getSecond();
				dataCell.add(new Pair<Integer, EstatCasella>(indexVolt, 
						consultaEstatCasella(casellaVoltant.getFirst(), casellaVoltant.getSecond())));
			}
			
			JPV.actualitzaTaulell(dataCell);
			JPV.mostrarMissatge("S'ha descobert la casella("+x+","+y+")");
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
	
	/**
	 * Obtenim el numero que ha de contenir la cassella
	 * @param index Es l'index de la casella sobre la que es fa l'acció
	 * @return Retornem el numero de mines que te al voltant la casella
	 */
	public int getNumber(Integer index) {
		int files = JPUCC.obteCasellesxColumna();
		int x = index/files;
		int y = index%files;
		return JPUCC.obteNumero(x,y);
	}
	
	/**
	 * Consultem el contingut d'una casella
	 * @param x	Es el numero de fila de la casella
	 * @param y Es el numero de columna de la casella
	 * @return	Retornem el contingut de la casella mitjançant els elements de la enumeracio
	 */
	private EstatCasella consultaEstatCasella(Integer x, Integer y) {
		Integer estat = JPUCC.obteNumero(x, y);
		if (JPUCC.tensMina(x,y)) {
			return EstatCasella.BOMBA;
		}
		else if (estat > 0) {
			return EstatCasella.DESCOBERTA;
		}
		else if (estat == -1) {
			return EstatCasella.BLANCA;
		}
		else {
			return EstatCasella.MARCADA;
		}
	}
	
	/**
	 * Premem el boto per sortir de l'aplicacio
	 */
	public void PrSortir() {
		JPV.tancar();
	}

}
