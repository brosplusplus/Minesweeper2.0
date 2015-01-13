package com.bros.minesweeper.factory;

import com.bros.minesweeper.adapter.AdaptadorCorreuPropi;

public class FactoriaAdaptadorCorreu extends AbstractFactory {
	
	public static AdaptadorCorreuPropi getAdaptadorCorreuPropi()
	{
		return new AdaptadorCorreuPropi();
	}
}
