package com.bros.minesweeper.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JugarPartidaViewController J = new JugarPartidaViewController();
			        J.IniciAplicacio(); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
