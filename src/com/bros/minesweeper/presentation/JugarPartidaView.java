package com.bros.minesweeper.presentation;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
    private PanelProva panelProva = new PanelProva();
    private PanelInici panelIni = new PanelInici();
	
    /**
     * Creadora de la classe VistaAplicacio
     * @param CP es el controlador de presentacio que utilitzara
     */
    public JugarPartidaView (JugarPartidaViewController J) {
    	JPVC = J;
        InicialitzarFrame();
    }
    
    /**
     * Funcio que inicialitza el frame de l'aplicacio
     */
    private void InicialitzarFrame() {
        frameApp.setMinimumSize(new Dimension(800,600));
        frameApp.setPreferredSize(frameApp.getMinimumSize());
        frameApp.setLocationRelativeTo(null);
        frameApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelActual = (JPanel) frameApp.getContentPane();
        panelAux = panelIni;
        panelActual.add(panelAux);
    }
    
	public JFrame getFrameApp() {
		return frameApp;
	}

	public void setFrameApp(JFrame frameApp) {
		this.frameApp = frameApp;
	}
	
	public JugarPartidaViewController getJPVC() {
		return JPVC;
	}

	public void setJPVC(JugarPartidaViewController jPVC) {
		JPVC = jPVC;
	}
	
	/**
	 * Metodes dels Panels
	 */
	
	public void Inici() {
        frameApp.pack();
        frameApp.setVisible(true);
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
