package com.bros.minesweeper.datainterface;

import com.bros.minesweeper.domain.model.Partida;

/**
 * Interficie del Controlador de persistencia de la clase Jugador
 * @author Borja Arias
 */
public interface ICtrlPartida {
	public Partida get(Integer idPartida);
	public Integer save(Partida partida);
}
