package com.bros.minesweeper.factory;

import com.bros.minesweeper.adapter.AdaptadorCorreuPropi;
import com.bros.minesweeper.adapter.IAdaptadorCorreu;

public class FactoriaAdaptadorCorreu {
	public static IAdaptadorCorreu getAdaptadorCorreu(AdaptadorType tipus)
	{
		IAdaptadorCorreu adap = null;
		switch (tipus){
			case OWN: 
				adap = new AdaptadorCorreuPropi();
				break;
			default:
				break;
		}
		return adap;
	}
}
