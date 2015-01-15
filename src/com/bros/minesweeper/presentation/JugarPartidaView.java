package com.bros.minesweeper.presentation;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
//      frameApp.setMinimumSize(new Dimension());
		frameApp.setResizable(false);
		frameApp.setPreferredSize(frameApp.getMinimumSize());
		frameApp.setLocationRelativeTo(null);
		frameApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelActual = (JPanel) frameApp.getContentPane();
		panelActual.add(panelIni);
		Dimension d = panelIni.getPreferredSize();
		panelActual.setMinimumSize(d);
		panelActual.setMaximumSize(d);
		frameApp.setMinimumSize(d);
		frameApp.setMaximumSize(d);
		
		URL url = ClassLoader.getSystemResource("img/caselles/banderaIcon.png");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.createImage(url);
		frameApp.setIconImage(img);
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
		panelActual.removeAll();
        panelActual.add(panelLog);
        frameApp.pack();
        frameApp.repaint();
	}
	
	public void mostrarMenuPrincipal(String usuari) {
		panelActual.removeAll();
		panelMP = new PanelMenuPrincipal(this);
		panelMP.setNomUsuari(usuari);
        panelActual.add(panelMP);
        frameApp.pack();
        frameApp.repaint();
	}
	
	public void logout() {
		panelActual.removeAll();
        panelActual.add(panelLog);
        frameApp.pack();
        frameApp.repaint();
	}
	
	public void mostrarNivells(String usuari, ArrayList<HashMap<String, String>> nivells) {
		panelLvl.setTaulaNivells(nivells);
		panelActual.removeAll();
        panelActual.add(panelLvl);
        frameApp.pack();
        frameApp.repaint();
	}
	
	public void mostrarPartida(int files, int columnes) {
		panelActual.removeAll();
		frameApp.setMinimumSize(new Dimension(850,600));
		panelGame = new PanelPartida(this);
		panelGame.setTaulellJoc(files, columnes);
        panelActual.add(panelGame);
        frameApp.revalidate();
        Dimension d = panelGame.getPreferredSize();
		panelActual.setMinimumSize(d);
		panelActual.setMaximumSize(d);
		frameApp.setMinimumSize(d);
		frameApp.setMaximumSize(d);
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
		JButton exit = new JButton("Sortir");
		int res = JOptionPane.showOptionDialog(null, 
				"Felicitats! Has guanyat!\n"
			    + "Puntuacio: "+ p,
			    "Final de Partida - Minesweeper", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, new Object [] {exit}, exit);
		if(exit.isSelected()) tancar();
	}
	
	public void mostrarMissatgeDerrota(){
		JOptionPane.showConfirmDialog(null,
			    "Oh! Has descobert una mina!\n"
			    + "Ho sentim, has perdut...",
			    "Final de Partida - Minesweeper",
			    JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void tancar() {
		frameApp.dispose();
	}

}
