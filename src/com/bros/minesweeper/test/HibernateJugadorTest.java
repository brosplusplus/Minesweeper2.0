package com.bros.minesweeper.test;

import java.util.Scanner;

import com.bros.minesweeper.db.CtrlJugador;
import com.bros.minesweeper.domain.controller.LoginUseCaseController;
import com.bros.minesweeper.domain.model.Jugador;
import com.bros.minesweeper.utils.debug;

public class HibernateJugadorTest {
	
	@SuppressWarnings("resource")
	public static Jugador newJugador() {
		Scanner in = new Scanner(System.in);
		debug.outln("Hola, que vols fer?");
		debug.outln("1. Nou perfil\n2. Carregar perfil");
		int accio = Integer.parseInt(in.nextLine());
//		String accio = in.nextLine();
		Jugador jugador = null;
		CtrlJugador cj = new CtrlJugador();
		if (accio == 1) {
			jugador = new Jugador();
			debug.outln("Nom:");
			jugador.setNom(in.nextLine());
			debug.outln("Cognom:");
			jugador.setCognom(in.nextLine());
			debug.outln("Username:");
			jugador.setUsername(in.nextLine());
			debug.outln("Password:");
			jugador.setPwd(in.nextLine());
			
			try {
				cj.save(jugador);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				debug.err(e.getMessage());
				debug.outln("Tornem a començar");
				return newJugador();
			}
		}
		else {
			debug.outln("Nom d'usuari:");
			String username = in.nextLine();
			LoginUseCaseController lucc = new LoginUseCaseController();
			while (jugador == null) {
				debug.outln("Contrasenya:");
				String pwd = in.nextLine();
				try {
					lucc.login(username, pwd);
					jugador = cj.get(username);
				}
				catch (Exception e) {
					debug.err(e.getMessage());
				}
			}			
		}
		return jugador;
	}
}
