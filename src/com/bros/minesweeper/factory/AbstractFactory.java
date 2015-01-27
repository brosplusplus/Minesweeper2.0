package com.bros.minesweeper.factory;

/**
 * Factoria abstracta d'on hereten la resta de factories del sistema
 * @author Borja Arias
 */
public abstract class AbstractFactory {
	
	private static AbstractFactory instance;
	
	public static AbstractFactory getInstance() {
		return instance;
	}
	
}
