package com.bros.minesweeper.test;

import com.bros.minesweeper.domain.model.EstrategiaPerTemps;
import com.bros.minesweeper.domain.model.Jugador;
import com.bros.minesweeper.domain.model.Nivell;
import com.bros.minesweeper.domain.model.Partida;

public class ProvaTreminal {
	
	public static void main(String[] args) {
		
		Jugador player1 = new Jugador();
		player1.setNom("Jugador1");
		player1.setCognom("Blau");
		player1.setEmail("player1@bros.com");
		player1.setPwd("password");
		
		Nivell nivell = new Nivell();
		nivell.setNom("facil");
		nivell.setNombreCasellesxColumna(5);
		nivell.setNombreCasellesxFila(5);
		nivell.setNombreMines(5);
		
		EstrategiaPerTemps estrat = new EstrategiaPerTemps();
		
		Partida partida = new Partida(player1, nivell, estrat);
		partida.crearCaselles(nivell.getNombreCasellesxColumna(), 
				nivell.getNombreCasellesxFila(), nivell.getNombreMines());
		
		for(int i = 0; i < nivell.getNombreCasellesxColumna(); ++i) {
			for(int j = 0;)
		}
		
	}
}
