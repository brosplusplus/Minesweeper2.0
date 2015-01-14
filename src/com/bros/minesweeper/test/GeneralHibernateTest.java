/**
 * 
 */
package com.bros.minesweeper.test;

import com.bros.minesweeper.domain.model.Partida;
import com.bros.minesweeper.utils.debug;

/**
 * @author Borja Arias
 */
public class GeneralHibernateTest {
	public static void main (String[] args) {
//		Jugador jug = HibernateJugadorTest.newJugador();
//		if (jug != null) 
//			debug.outln("Creat el jugador: "+jug.getUsername());
//		else
//			debug.err("Error en crear el jugador");
//		Nivell niv = HibernateNivellTest.newNivell();
//		if (niv != null)
//			debug.outln("Creat el Nivell: "+niv.getNom());
//		else
//			debug.err("Error en crear el Nivell");
//		Administrador admin = HibernateAdministradorTest.newAdministrador();
//		if (admin != null)
//			debug.outln("Creat el Administrador: "+admin.getUsername());
//		else
//			debug.err("Error en crear Administrador");
		Partida part = HibernatePartidaTest.newPartida();
		if (part != null)
			debug.outln("Creada la Partida amb IdPartida: "+part.getIdPartida());
		else
			debug.err("Error en crear Partida");
		
		debug.outln("Si hem arribat fins aquí es que res a petat xD");
	}
}
