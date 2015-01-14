package com.bros.minesweeper.domain.model;


public class EstrategiaPerTemps implements EstrategiaPuntuacio {

	/**
	 * Maximum time in millis
	 */
	private long tempsMaxim;
	private long startTimeStamp;
	
	public EstrategiaPerTemps(long tMax) {
		// tMax son segons i el passem a ms
		this.startTimeStamp = System.currentTimeMillis(); 
		this.tempsMaxim = tMax*1000;
	}
	
	@Override
	/**
	 * Aquesta funcio retorna la puntuacio seguint
	 * l'estrategia puntuacio per temps.
	 * 
	 * @param partida es la partida la qual es calcula
	 * la puntuacio.
	 * 
	 * @return retorna la puntuacio de la partida.
	 * 
	 */
	public Integer getPuntuacio(Partida partida) {
		long actualTime = System.currentTimeMillis();
		long timeDiff = actualTime - this.startTimeStamp;
		if (timeDiff > this.tempsMaxim)
			return 0;
		int multiplicador = 10000;
		double percent = (double)(this.tempsMaxim - timeDiff)/this.tempsMaxim;
		return (int)percent * multiplicador;
	}

	@Override
	public void setMaxim(Integer files, Integer columnes, Integer mines) {
		Double x = 0.3;
		Double y = -0.93;
		Double mida = (Double)(double)files*columnes;
		Double factor = (mida/mines)*x+y;
		this.tempsMaxim = (int) Math.round((mida-mines)*factor); 		
	}

}
