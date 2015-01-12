package com.bros.minesweeper.domain.controller;

import com.bros.minesweeper.domain.datainterface.CtrlUsuariRegistrat;
import com.bros.minesweeper.domain.factory.FactoriaControladors;
import com.bros.minesweeper.domain.model.UsuariRegistrat;

public class LoginUseCaseController {
	
	public Boolean login (String userN, String passwd) throws Exception {
		CtrlUsuariRegistrat cu = FactoriaControladors.getCtrlUsuari();
		UsuariRegistrat u = cu.get(userN);

		if(passwd != u.getPwd()) throw new Exception("Password Incorrecta");

		return true;
	}

}
