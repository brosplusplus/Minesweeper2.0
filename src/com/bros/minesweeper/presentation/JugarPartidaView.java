package com.bros.minesweeper.presentation;
import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public static Color defaultColor = new Color(0,160,255);
private Dimension defaultFrameDimension = new Dimension(500,300);
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
frameApp.setMinimumSize(defaultFrameDimension);
// frameApp.setMinimumSize(new Dimension());
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
Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
private boolean isNumeric(String str)
{
try
{
int d = Integer.parseInt(str);
}
catch(NumberFormatException nfe)
{
return false;
}
return true;
}
@Override
public void eventDispatched(AWTEvent event) {
// TODO Auto-generated method stub
MouseEvent me = (MouseEvent) event;
// debug.outln(me.getSource());
if (me.getSource() instanceof JButton && (me.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
JButton btn = (JButton) me.getSource();
String name = btn.getName();
if (isNumeric(name)) {
if (me.getClickCount() == 2) {
JPVC.PrDobleBotoEsq(Integer.parseInt(name));
}
else
JPVC.PrBotoEsq(Integer.parseInt(name));
}
}
else if (me.getSource() instanceof JButton
&& (me.getModifiersEx() & MouseEvent.BUTTON3_DOWN_MASK) != 0)
{
JButton btn = (JButton) me.getSource();
String name = btn.getName();
if (isNumeric(name)) {
JPVC.PrBotoDret(Integer.parseInt(name));
}
}
}
}, MouseEvent.MOUSE_EVENT_MASK);
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
frameApp.setMinimumSize(defaultFrameDimension);
frameApp.setPreferredSize(defaultFrameDimension);
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
public void actualitzaTaulell(Pair<Integer, EstatCasella> dataCell, String tasca) {
if (tasca.equals("marcar")) {
Integer casella = dataCell.getFirst();
EstatCasella eC = dataCell.getSecond();
panelGame.actualitzaCasella(ImageGrid.icnMarc, casella, null);
}
else {
Integer casella = dataCell.getFirst();
EstatCasella eC = dataCell.getSecond();
panelGame.actualitzaCasella(null, casella, defaultColor);
}
}
public void actualitzaTaulell(ArrayList<Pair<Integer, EstatCasella>> dataCell) {
for(int i = 0; i < dataCell.size(); i++){
Integer casella = dataCell.get(i).getFirst();
EstatCasella eC = dataCell.get(i).getSecond();
if (eC == EstatCasella.BOMBA) {
panelGame.actualitzaCasella(ImageGrid.icnBomb, casella, null);
}
else if (eC == EstatCasella.BLANCA) {
panelGame.actualitzaCasella(null, casella, null);
}
else {
int number = JPVC.getNumber(casella);
panelGame.actualitzaCasella(ImageGrid.icnNum.get(number-1), casella, null);
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
JOptionPane.showMessageDialog(this.frameApp, "Has guanyat\nPuntuació: "+p, "Felicitats!", JOptionPane.INFORMATION_MESSAGE);
this.mostrarMenuPrincipal("una altra partida?");
}
public void mostrarMissatgeDerrota(){
JButton exit = new JButton("Sortir");
JOptionPane.showMessageDialog(this.frameApp, "Ho sentim, has trobat una mina", "So sorry!", JOptionPane.INFORMATION_MESSAGE);
this.mostrarMenuPrincipal("vols tornar a provar?");
}
public void tancar() {
frameApp.dispose();
}
}