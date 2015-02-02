package com.bros.minesweeper.domain.controller;

import com.bros.minesweeper.datainterface.ICtrlJugador;
import com.bros.minesweeper.domain.model.Jugador;
import com.bros.minesweeper.factory.FactoriaControladors;

public class RegistrarJugadorUCC {
	public void registrarUsuari (String nom, String cognom, String username, String pwd, String email) throws Exception {
		ICtrlJugador cJ = FactoriaControladors.getCtrlJugador();
		Jugador j = new Jugador();
		j.setNom(nom);
		j.setCognom(cognom);
		j.setUsername(username);
		j.setPwd(pwd);
		j.setEmail(email);
		cJ.save(j);
	}
}
