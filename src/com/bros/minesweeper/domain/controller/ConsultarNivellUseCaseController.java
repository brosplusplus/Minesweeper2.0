package com.bros.minesweeper.domain.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.bros.minesweeper.db.CtrlNivell;
import com.bros.minesweeper.domain.model.Nivell;
import com.bros.minesweeper.factory.FactoriaControladors;

public class ConsultarNivellUseCaseController {

	public ArrayList<HashMap<String,String>> consultarNivells() throws Exception{
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
		if(result.isEmpty()) throw new Exception("No hi ha nivells al sistema");
		
		return result;

	}
}
