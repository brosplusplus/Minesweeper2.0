package com.bros.minesweeper.domain.controller;

import com.bros.minesweeper.datainterface.CtrlUsuariRegistrat;
import com.bros.minesweeper.domain.model.UsuariRegistrat;
import com.bros.minesweeper.factory.FactoriaControladors;

/**
 * LoginUseCaseController representa el cas d'us de Login
 * 
 * @author Alejandro Martinez
 *
 */

public class LoginUseCaseController {
	
	public Boolean login (String userN, String passwd) throws Exception {
		CtrlUsuariRegistrat cu = FactoriaControladors.getCtrlUsuari();
		UsuariRegistrat u = cu.get(userN);

		if(passwd != u.getPwd()) throw new Exception("Password Incorrecta");

		return true;
	}

}
