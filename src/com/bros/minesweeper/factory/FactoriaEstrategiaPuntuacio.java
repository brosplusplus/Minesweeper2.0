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

	private static EstrategiaPerTemps estrategiaPerTemps;
	private static EstrategiaPerTirades estrategiaPerTirades;
	
	/**
	 * Genera una llista de les estrategies de puntuacio que hi han al sistema
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static ArrayList<EstrategiaPuntuacio> getAll() throws InstantiationException, IllegalAccessException {
		ArrayList<EstrategiaPuntuacio> ret = new ArrayList<EstrategiaPuntuacio>();
		ret.add(estrategiaPerTemps.getClass().newInstance());
		ret.add(estrategiaPerTirades.getClass().newInstance());
		return ret;		
	}

}
