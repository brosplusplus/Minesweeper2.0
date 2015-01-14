package com.bros.minesweeper.datainterface;

import com.bros.minesweeper.domain.model.Administrador;

/**
 * Interficie del Controlador de persistencia de la clase Administrador
 * @author Alex More
 *
 */
public interface ICtrlAdministrador {

	public Administrador get(String username);
	public String save(Administrador administrador);

}
