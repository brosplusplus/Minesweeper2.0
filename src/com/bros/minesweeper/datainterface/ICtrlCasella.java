package com.bros.minesweeper.datainterface;

import com.bros.minesweeper.domain.model.Casella;

/**
 * Interficie del Controlador de persistencia de la clase Casella
 * @author Borja Arias
 */
public interface ICtrlCasella {
	public Casella get(Integer idPartida, Integer numF, Integer numC);
	public String save(Casella casella);
}
