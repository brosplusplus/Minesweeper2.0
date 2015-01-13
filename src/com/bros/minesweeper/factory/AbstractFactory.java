package com.bros.minesweeper.factory;

/**
 * Factoria abstracta d'on hereten la resta de factories del sistema
 * @author Borja Arias
 */
public abstract class AbstractFactory {
	
	private static FactoriaAdaptadorCorreu instance;
	
	public static FactoriaAdaptadorCorreu getInstance() {
		return instance;
	}
	
}
