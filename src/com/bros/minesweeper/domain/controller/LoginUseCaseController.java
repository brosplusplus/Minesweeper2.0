package com.bros.minesweeper.domain.controller;

import com.bros.minesweeper.db.CtrlUsuariRegistrat;
import com.bros.minesweeper.domain.model.UsuariRegistrat;
import com.bros.minesweeper.factory.FactoriaControladors;

/**
 * LoginUseCaseController representa el cas d'us de Login
 * 
 * @author Alejandro Martinez
 *
 */

public class LoginUseCaseController {
	
	/**
	 * Funció per comprovar que les dades de l'usuari son correctes i estan a la DB.
	 * @param userN nom d'usuari.
	 * @param passwd contrasenya.
	 * @return retorna true si l'usuari existeix i el userN i el pwd son correctes, false altrament.
	 * @throws Exception
	 */
	public Boolean login (String userN, String passwd) throws Exception {
		CtrlUsuariRegistrat cu = FactoriaControladors.getCtrlUsuariRegistrat();
		UsuariRegistrat u = cu.get(userN);
		
		if(!passwd.equals(u.getPwd())) throw new Exception("Password Incorrecte");

		return true;
	}

}
