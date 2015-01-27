package com.bros.minesweeper.presentation;

import java.awt.EventQueue;

import com.bros.minesweeper.utils.DerbyDB;

public class Main {
	public static void main(String[] args) {
		//DerbyDB.stopDerbyDB(); //to ensure that server is down
		Process p = DerbyDB.startDerbyDB();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DerbyDB.initialConfig();
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
