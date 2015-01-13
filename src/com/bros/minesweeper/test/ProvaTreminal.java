package com.bros.minesweeper.test;

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
		
		Partida partida = new Partida(player1, nivell.getNom());
		partida.crearCaselles(nivell.getNombreCasellesxColumna(), 
				nivell.getNombreCasellesxFila(), nivell.getNombreMines());
		
		
	}
}
