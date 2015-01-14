package com.bros.minesweeper.factory;

import java.util.ArrayList;

import com.bros.minesweeper.domain.model.EstrategiaPerTemps;
import com.bros.minesweeper.domain.model.EstrategiaPerTirades;
import com.bros.minesweeper.domain.model.EstrategiaPuntuacio;

/**
 * Factoria de les estrategies de puntuacio
 * @author Borja Arias
 */
public class FactoriaEstrategiaPuntuacio extends AbstractFactory{
	
	/**
	 * Genera una llista de les estrategies de puntuacio que hi han al sistema
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static ArrayList<Class> getAll() throws InstantiationException, IllegalAccessException {
		ArrayList<Class> ret = new ArrayList<Class>();
		ret.add(EstrategiaPerTemps.class);
		ret.add(EstrategiaPerTirades.class);
		return ret;		
	}

}
