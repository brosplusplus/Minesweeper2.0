package com.bros.minesweeper.test;

import java.util.Scanner;

import com.bros.minesweeper.domain.model.Casella;
import com.bros.minesweeper.domain.model.EstatPartida;
import com.bros.minesweeper.domain.model.EstrategiaPerTemps;
import com.bros.minesweeper.domain.model.Jugador;
import com.bros.minesweeper.domain.model.Nivell;
import com.bros.minesweeper.domain.model.Partida;
import com.bros.minesweeper.utils.Pair;
import com.bros.minesweeper.utils.debug;

public class ProvaTreminal {
	
	public static void main(String[] args) throws Exception {
		
		Jugador player1 = new Jugador();
		player1.setNom("Jugador1");
		player1.setCognom("Blau");
		player1.setEmail("player1@bros.com");
		player1.setPwd("password");
		
		Nivell nivell = new Nivell();
		nivell.setNom("facil");
		nivell.setNombreCasellesxColumna(9);
		nivell.setNombreCasellesxFila(9);
		nivell.setNombreMines(0);
		
		EstrategiaPerTemps estrat = new EstrategiaPerTemps(120);
		
		Partida partida = new Partida(player1, nivell, estrat);
		partida.crearCaselles(nivell.getNombreCasellesxColumna(), 
				nivell.getNombreCasellesxFila(), nivell.getNombreMines());
		
		imprimeixTaulell(partida, nivell);

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		EstatPartida ep = new EstatPartida();
		while(!ep.acabada) {
			
			debug.outln("Escull la propera acció:");
			debug.outln("1. Marcar casella\n2. Desmarcar casella\n3. Descobrir casella");
			int accio = in.nextInt();
			debug.outln("Introdueix una fila [0-"+(nivell.getNombreCasellesxColumna()-1)+"]:");
			int numF = in.nextInt();
			debug.outln("Introdueix una columna [0-"+(nivell.getNombreCasellesxFila()-1)+"]:");
			int numC = in.nextInt();
			try{
				switch (accio) {
				case 1:
					partida.marcarCasella(numF, numC);
					break;
				case 2:
					partida.desmarcarCasella(numF, numC);
					break;
				case 3:
					ep = partida.descobrirCasella(numF, numC);
					for (Pair<Integer, Integer> punt : ep.casellesPerDescobrir)
					{
						if (partida.getCasellaTaulell(punt.getFirst(), punt.getSecond()).estaDescoberta())
							debug.outln(punt.getFirst()+" "+punt.getSecond()+" : YEZ");
						else
							debug.outln(punt.getFirst()+" "+punt.getSecond()+" : NOP");
					}
					break;
				default:
					break;
				}
			} catch (Exception e) {
				debug.outln(e.getMessage());
			}
			imprimeixTaulell(partida, nivell);
		}
		
		if (ep.acabada && ep.guanyada) {
			debug.outln("Has guanyat, "+player1.getNom()+"!");
			debug.outln(partida.computaPuntuacio() + " punts");
		}
		else if (ep.acabada) {
			debug.outln("Ta petao una mina hippiecolgaoo!!!");
		}
		
	}

	private static void imprimeixTaulell(Partida partida, Nivell nivell) {
		// TODO Auto-generated method stub
		for(int i = 0; i < nivell.getNombreCasellesxColumna(); ++i) {
			for(int j = 0; j < nivell.getNombreCasellesxFila(); ++j) {
				Casella c = partida.getCasellaTaulell(i, j);
				if (c.getEstaMarcada()){
					debug.out(" M ");
				}
				else if (c.getEstaDescoberta()) {
					if (c.tensMina()) {
						debug.out(" # ");
					}
					else if (c.getNumero() == null) {
						debug.out(" _ ");
					}
					else {
						debug.out(" "+c.getNumero()+" ");
					}
				}
				else {
					debug.out(" . ");
				}	
			}
			debug.outln("\n");
		}
	}
}
