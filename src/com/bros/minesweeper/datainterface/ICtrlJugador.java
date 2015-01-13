/**
 * 
 */
package com.bros.minesweeper.datainterface;

import com.bros.minesweeper.domain.model.Jugador;

/**
 * Interficie del Controlador de persistencia de la clase Jugador
 * @author Borja Arias
 */
public interface ICtrlJugador {
	public boolean exists(String userN);
	public Jugador get(String username);
}
