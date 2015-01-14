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
    private PanelInici panelIni = new PanelInici(this);
    private PanelLogin panelLog = new PanelLogin(this);
    private PanelMenuPrincipal panelMP = new PanelMenuPrincipal(this);
    private PanelNivells panelLvl = new PanelNivells(this);
    private PanelPartida panelGame = new PanelPartida(this);
	
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
        frameApp.setMinimumSize(new Dimension(500,300));
        frameApp.setResizable(false);
        frameApp.setPreferredSize(frameApp.getMinimumSize());
        frameApp.setLocationRelativeTo(null);
        frameApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelActual = (JPanel) frameApp.getContentPane();
        panelActual.add(panelIni);
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
		panelActual.remove(panelIni);
        panelActual.add(panelLog);
        frameApp.pack();
        frameApp.repaint();
	}
	
	public void mostrarMenuPrincipal(String usuari) {
		panelActual.remove(panelLog);
		panelMP.setNomUsuari(usuari);
        panelActual.add(panelMP);
        frameApp.pack();
        frameApp.repaint();
	}
	
	public void logout() {
		panelActual.remove(panelMP);
        panelActual.add(panelLog);
        frameApp.pack();
        frameApp.repaint();
	}
	
	public void mostrarNivells(String usuari, ArrayList<HashMap<String, String>> nivells) {
		panelLvl.setTaulaNivells(nivells);
		panelActual.remove(panelMP);
        panelActual.add(panelLvl);
        frameApp.pack();
        frameApp.repaint();
	}
	
	public void mostrarPartida() {
		panelActual.remove(panelLvl);
        panelActual.add(panelGame);
        frameApp.pack();
        frameApp.repaint();
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
