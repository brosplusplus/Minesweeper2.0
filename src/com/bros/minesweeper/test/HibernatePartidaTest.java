package com.bros.minesweeper.test;

import java.util.Scanner;

import com.bros.minesweeper.datainterface.ICtrlPartida;
import com.bros.minesweeper.domain.model.Jugador;
import com.bros.minesweeper.domain.model.Partida;
import com.bros.minesweeper.factory.FactoriaControladors;
import com.bros.minesweeper.utils.debug;

public class HibernatePartidaTest {
	public static Partida newPartida() {
		Scanner in = new Scanner(System.in);
		debug.outln("Hola, que vols fer?");
		debug.outln("1. Nova Partida\n");
		int accio = Integer.parseInt(in.nextLine());
		Partida partida = null;
		ICtrlPartida cp = FactoriaControladors.getCtrlPartida();
		if (accio == 1) {
			partida = new Partida();
			debug.outln("Nom del jugador que hi jugara:");
			String nomU = in.nextLine();
			Jugador jug = FactoriaControladors.getCtrlJugador().get(nomU);
			debug.outln("Nom del nivell");
			String nomName = in.nextLine();
			partida = new Partida(jug, nomName);
			try {
				cp.save(partida);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				debug.err(e.getMessage());
			}
		}
		in.close();
		return partida;
	}
}
