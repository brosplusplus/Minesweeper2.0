package com.bros.minesweeper.test;

import java.util.Scanner;

import com.bros.minesweeper.db.CtrlJugador;
import com.bros.minesweeper.domain.controller.LoginUseCaseController;
import com.bros.minesweeper.domain.model.Jugador;
import com.bros.minesweeper.utils.debug;

public class HibernateJugadorTest {
	
	@SuppressWarnings("resource")
	public static Jugador obteJugadorActual(String[] args) {
		Scanner in = new Scanner(System.in);
		debug.outln("Hola, què vols fer?");
		debug.outln("1. Nou perfil\n2. Carregar perfil");
		int accio = in.nextInt();
		Jugador jugador = new Jugador();
		CtrlJugador cj = new CtrlJugador();
		if (accio == 1) {
			debug.outln("Nom:");
			jugador.setNom(in.nextLine());
			debug.outln("Cognom:");
			jugador.setCognom(in.nextLine());
			debug.outln("Username:");
			jugador.setUsername(in.nextLine());
			debug.outln("Password:");
			jugador.setPwd(in.nextLine());
			cj.save(jugador);
		}
		else {
			debug.outln("Nom d'usuari:");
			String username = in.nextLine();
			debug.outln("Contrasenya:");
			String pwd = in.nextLine();
			LoginUseCaseController lucc = new LoginUseCaseController();
			while (jugador == null) {
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
