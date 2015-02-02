package com.bros.minesweeper.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class FinestraPartida {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraPartida window = new FinestraPartida(450,300);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setVisible() {
		frame.setVisible(true);
	}
	
	/**
	 * Create the application.
	 */
	public FinestraPartida(int width, int height) {
		initialize(width, height);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int width, int height) {
		frame = new JFrame();
		frame.setBounds(100, 100, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
