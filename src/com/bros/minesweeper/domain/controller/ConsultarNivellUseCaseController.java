package com.bros.minesweeper.domain.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.bros.minesweeper.db.CtrlNivell;
import com.bros.minesweeper.domain.model.Nivell;
import com.bros.minesweeper.factory.FactoriaControladors;
import com.bros.minesweeper.utils.debug;

/**
 *ConsultarNivellUseCaseController representa el cas d'us de Consultar Nivell
 * 
 * @author Alejandro Martinez
 *
 */

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
	
	public static void main(String args[]) 
	{
		ConsultarNivellUseCaseController ucc = new ConsultarNivellUseCaseController();
		
		try {
			ArrayList<HashMap<String,String>> ar = ucc.consultarNivells();
			debug.outln(ar.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			debug.outln(e.getMessage());
		}
	}
}
