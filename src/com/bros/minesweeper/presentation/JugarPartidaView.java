package com.bros.minesweeper.presentation;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.bros.minesweeper.utils.Pair;

/**
 * Vista de l'aplicacio del Buscamines
 * 
 * @author Alejandro Martinez
 *
 */
public class JugarPartidaView {
	
	//Controlador de presentacio
	private JugarPartidaViewController JPVC;
	
	//Area de missatges
	public static JLabel lblMessageArea;
	
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
		panelMP = new PanelMenuPrincipal(this);
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
	
	public void mostrarPartida(int files, int columnes) {
		panelActual.remove(panelLvl);
		frameApp.setMinimumSize(new Dimension(1000,600));
		panelGame = new PanelPartida(this);
		panelGame.setTaulellJoc(files, columnes);
        panelActual.add(panelGame);
        frameApp.pack();
        frameApp.repaint();
	}
	
	public void actualitzaTaulell(Pair<Pair<Integer, Integer>, EstatCasella> dataCell, String tasca) {
		if (tasca.equals("marcar")) {
			Pair<Integer, Integer> casella = dataCell.getFirst();
			EstatCasella eC = dataCell.getSecond();
			
		}
		else {
			Pair<Integer, Integer> casella = dataCell.getFirst();
			EstatCasella eC = dataCell.getSecond();
		}
	}

	public void actualitzaTaulell(ArrayList<Pair<Pair<Integer, Integer>, EstatCasella>> dataCell) {
		for(int i = 0; i < dataCell.size(); i++){
			Pair<Integer, Integer> casella = dataCell.get(i).getFirst();
			EstatCasella eC = dataCell.get(i).getSecond();
			if (eC == EstatCasella.BOMBA) {
				
			}
			else if (eC == EstatCasella.BLANCA) {
				
			}
			else {
				
			}
		}
	}
	
	public void mostrarMissatge(String txt){
		panelLog.escriuMissatge(txt);
		panelMP.escriuMissatge(txt);
		panelGame.escriuMissatge(txt);
	}
	
	public void mostrarMissatgeVictoria(Integer p){
		
	}
	
	public void mostrarMissatgeDerrota(){
		
		
	}
	
	public void tancar() {
		frameApp.dispose();
	}

}
