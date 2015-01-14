package com.bros.minesweeper.domain.model;



/**
 * EstrategiaPuntuacio defines the interface to create Strategy 
 * Pattern over puntuation policy
 * @author Borja Arias
 * @version 0.1
 *
 */

public interface EstrategiaPuntuacio {
	public void setMaxim(Integer files, Integer Columnes, Integer mines);
	public Integer getPuntuacio(Partida partida);
}
