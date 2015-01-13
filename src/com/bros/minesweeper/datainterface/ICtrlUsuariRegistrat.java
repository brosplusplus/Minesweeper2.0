/**
 * 
 */
package com.bros.minesweeper.datainterface;

import com.bros.minesweeper.domain.model.UsuariRegistrat;

/**
 * Interficie del Controlador de persistencia de la clase Casella
 * @author Borja Arias
 */
public interface ICtrlUsuariRegistrat {
	public UsuariRegistrat get(String username);
	public String save(UsuariRegistrat usuariRegistrat);
}
