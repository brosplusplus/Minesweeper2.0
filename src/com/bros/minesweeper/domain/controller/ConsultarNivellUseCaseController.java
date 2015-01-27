package com.bros.minesweeper.domain.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.bros.minesweeper.db.CtrlNivell;
import com.bros.minesweeper.domain.model.Nivell;
import com.bros.minesweeper.exceptions.NoHiHaNivells;
import com.bros.minesweeper.factory.FactoriaControladors;

/**
 *ConsultarNivellUseCaseController representa el cas d'us de Consultar Nivell
 * 
 * @author Alejandro Martinez
 *
 */

public class ConsultarNivellUseCaseController {

	/**
	 * Funcio per obtenir tots els nivells que te la DB.
	 * @return retorna una llista amb tots els nivells de la DB.
	 * @throws SQLException 
	 * @throws Exception: Llenca una excepcio quan hi ha algun error.
	 */
	public ArrayList<HashMap<String,String>> consultarNivells() throws NoHiHaNivells, SQLException {
		CtrlNivell cn = FactoriaControladors.getCtrlNivell();
		ArrayList<Nivell> ns = cn.getAll();
		ArrayList<HashMap<String,String>> result = new ArrayList<HashMap<String,String>>();
		for(Nivell level : ns){
			HashMap<String,String> aux = new HashMap<String,String>();
			aux.put("nom", level.getNom());
			aux.put("nCol", level.getNombreCasellesxFila().toString());
			aux.put("nRow", level.getNombreCasellesxColumna().toString());
			aux.put("nMine", level.getNombreMines().toString());
			result.add(aux);
		}		
		if(result.isEmpty()) throw new NoHiHaNivells();
		
		return result;

	}
	
}
