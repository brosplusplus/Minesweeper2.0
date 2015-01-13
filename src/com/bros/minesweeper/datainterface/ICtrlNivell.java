/**
 * 
 */
package com.bros.minesweeper.datainterface;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bros.minesweeper.domain.model.Nivell;

/**
 * Interficie del Controlador de persistencia de la clase Jugador
 * @author Borja Arias
 */
public interface ICtrlNivell {
	public Nivell get(String nomNivell);
	public ArrayList<Nivell> getAll() throws SQLException;
}
