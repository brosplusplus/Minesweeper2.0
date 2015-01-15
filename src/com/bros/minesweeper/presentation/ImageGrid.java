package com.bros.minesweeper.presentation;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.bros.minesweeper.utils.debug;


public class ImageGrid {

	public enum Estat {
		DESMARCADA, MARCADA, DESCOBERTA, BOMBA, BLANCA  
	}
	
	public JPanel frame;
	private static ArrayList<JButton> gridArr;
	public static ArrayList<ImageIcon> icnNum;
	public static ImageIcon icnBomb;
	public static ImageIcon icnMarc;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageGrid window = new ImageGrid(18, 18, 160, 160);
					JFrame mainFrame = new JFrame();
					mainFrame.add(window.frame);
					mainFrame.setBounds(window.frame.getBounds());
					mainFrame.setLocationRelativeTo(null);
					mainFrame.setVisible(true);
					mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ImageIcon getIcon(String path, int cellWidth, int cellHeight) {
		ImageIcon icon = new ImageIcon(this.getClass().getResource(path));
		Image img = icon.getImage();
		img = img.getScaledInstance(cellWidth*2, cellHeight*2, Image.SCALE_SMOOTH);
		return new ImageIcon(img);
	}
	
	public JPanel getPanel(){
		return this.frame;
	}
	
	/**
	 * Create the panel.
	 */
	public ImageGrid(int files, int columnes, int width, int height) {
		int cellWidth = 10;
		int cellHeight = 10;
		
		this.icnBomb = getIcon("/img/caselles/bomba.png", cellWidth, cellHeight);
		this.icnMarc = getIcon("/img/caselles/bandera.png", cellWidth, cellHeight);
		this.icnNum = new ArrayList<ImageIcon>();
		for (int i = 1; i < 9; ++i) {
			debug.outln(i);
			this.icnNum.add(getIcon("/img/caselles/"+i+".png", cellWidth, cellHeight));
		}
		
		frame = new JPanel();
		frame.setBounds(0,0,width,height);
		frame.setOpaque(false);
		
		GridLayout grid = new GridLayout(files, columnes);
		frame.setLayout(grid);
		
		gridArr = new ArrayList<JButton>();
		for (int i = 0; i < files; i++) {
			for (int j = 0; j < columnes; j++) {
				JButton button = new JButton();
				//button.setBounds(actualWidth, actualHeight, cellWidth, cellHeight);
				button.setOpaque(true);
				button.setContentAreaFilled(true);
				button.setBackground(JugarPartidaView.defaultColor);
				button.setName(((Integer)(i*files+j)).toString());
				
				gridArr.add(button);
				frame.add(button);
			}
		}
		
		frame.setFocusable(true);
		frame.requestFocus();	
		
	}
	
	public JButton getButton(Integer index) {
		return gridArr.get(index);
	}
	
}
