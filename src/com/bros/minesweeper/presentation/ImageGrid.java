package com.bros.minesweeper.presentation;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.bros.minesweeper.utils.debug;


public class ImageGrid {

	public enum Estat {
		TAPADA, BLANC, MARCADA, NUMERO, BOMBA  
	}
	
	private JPanel frame;
	private static ArrayList<JButton> gridArr;
	private static ImageIcon icnNum;
	private static ImageIcon icnBomb;
	private static ImageIcon icnMarc;
	private static ImageIcon icnPunt;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageGrid window = new ImageGrid(5, 5, 100, 100);
					JFrame mainFrame = new JFrame();
					mainFrame.add(window.frame);
					mainFrame.setBounds(window.frame.getBounds());
					mainFrame.setVisible(true);
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
	
	/**
	 * Create the panel.
	 */
	public ImageGrid(int files, int columnes, int width, int height) {
		int cellWidth = width/(files+1)-1;
		int cellHeight = height/(columnes+1)-1;
		int widthSpace = cellWidth / files;
		int heightSpace = cellHeight / columnes;
		
		this.icnBomb = getIcon("/img/caselles/bomba.png", cellWidth, cellHeight);
		this.icnMarc = getIcon("/img/caselles/bandera.png", cellWidth, cellHeight);
		this.icnNum = getIcon("/img/caselles/1.png", cellWidth, cellHeight);
		this.icnPunt = getIcon("/img/caselles/punt.png", cellWidth, cellHeight);
		
		frame = new JPanel();
		frame.setBounds(0,0,width*2,height*2);
		
		GridLayout grid = new GridLayout(files, columnes);
		frame.setLayout(grid);
		
		gridArr = new ArrayList<JButton>();
		for (int i = 0; i < files; i++) {
			int actualHeight = i*(cellHeight+heightSpace);
			for (int j = 0; j < columnes; j++) {
				int actualWidth = j*(cellWidth+widthSpace);
				JButton button = new JButton();
				button.setBounds(actualWidth, actualHeight, cellWidth, cellHeight);
				debug.outln("Button: "+i+" "+j+" "+actualWidth+" "+actualHeight);
				button.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseClicked(MouseEvent arg0) {
						switch(arg0.getButton()){
						case MouseEvent.BUTTON1:
							if (arg0.getClickCount() == 2) {
								JButton btn = (JButton)arg0.getSource();
								debug.outln("NUM");
								btn.setIcon(icnNum);
							}
							else {
								JButton btn = (JButton)arg0.getSource();
								debug.outln("NULL");
								btn.setIcon(null);
							}
							break;
						case MouseEvent.BUTTON3:
							JButton btn = (JButton)arg0.getSource();
							debug.outln("MARC");
							btn.setIcon(icnMarc);
							break;
						default:
							break;
						}
						frame.requestFocus();
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				gridArr.add(button);
				frame.add(button);
			}
		}
		
		frame.setFocusable(true);
		frame.requestFocus();
		frame.addKeyListener(new KeyListener () {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				switch (arg0.getKeyCode()) {
				case 27:
					
					break;
				default:
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}

	public static synchronized void playSound(final String url) {
		  new Thread(new Runnable() {
		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
		      try {
		        Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		          this.getClass().getResourceAsStream("/path/to/sounds/" + url));
		        clip.open(inputStream);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}
}