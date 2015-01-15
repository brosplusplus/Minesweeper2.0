package com.bros.minesweeper.factory;

import com.bros.minesweeper.adapter.AdaptadorCorreuPropi;

/**
 * Factoria de l'Adaptador de correu propi.
 * @author Alex More
 *
 */
public class FactoriaAdaptadorCorreu extends AbstractFactory {
	
	public static AdaptadorCorreuPropi getAdaptadorCorreuPropi()
	{
		return new AdaptadorCorreuPropi();
	}
}
