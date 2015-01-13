package com.bros.minesweeper.presentation;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import antlr.debug.Event;

import com.bros.minesweeper.domain.model.Nivell;

/**
 * Vista de l'aplicacio del Buscamines
 * 
 * @author Alejandro Martinez
 *
 */
public class JugarPartidaView {
	
	//Controlador de presentacio
	private JugarPartidaViewController JPVC;

	//Components de la interficie grafica
    private JFrame frameApp = new JFrame("Minesweeper");
    private JPanel panelActual = new JPanel();
    private JPanel panelAux = new JPanel();
	
	public JugarPartidaViewController getJPVC() {
		return JPVC;
	}

	public void setJPVC(JugarPartidaViewController jPVC) {
		JPVC = jPVC;
	}
	
	public void mostrarIdentificacio() {
		
	}
	
	public void mostrarMenuPrincipal() {
		
	}
	
	public void mostrarNivells(String usuari, ArrayList<HashMap<String, String>> nivells) {
		
	}
	
	public void mostrarPartida() {
		
	}
	
	public void actualitzaTaulell() {
		
	}
	public void mostrarMissatge(String txt){
		
	}
	
	public void mostrarMissatgeVictoria(Integer p){
		
	}
	
	public void mostrarMissatgeDerrota(){
		
	}
	
	public void tancar() {
		frameApp.dispose();
	}
}
