package com.bros.minesweeper.domain.model;


public class EstrategiaPerTemps implements EstrategiaPuntuacio {

	/**
	 * Maximum time in millis
	 */
	private long tempsMaxim;
	private long startTimeStamp;
	
	public EstrategiaPerTemps() {
		this.startTimeStamp = System.currentTimeMillis(); 
	}
	
	@Override
	public Integer getPuntuacio(Partida partida) {
		long actualTime = System.currentTimeMillis();
		long timeDiff = actualTime - this.startTimeStamp;
		if (timeDiff > this.tempsMaxim)
			return 0;
		else
			return (int) (this.tempsMaxim - timeDiff);
	}

}
