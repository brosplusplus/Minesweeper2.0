package com.bros.minesweeper.domain.model;



public class EstrategiaPerTirades implements EstrategiaPuntuacio{
	private Integer tiradesMaximes;

	public EstrategiaPerTirades() {
		super();
	}

	@Override
	/**
	 * Aquesta funcio retorna la puntuacio seguint
	 * l'estrategia puntuacio per tirades.
	 * 
	 * @param partida es la partida la qual es calcula
	 * la puntuacio.
	 * 
	 * @return retorna la puntuacio de la partida.
	 * 
	 */
	public Integer getPuntuacio(Partida partida) {
		Integer tiradesActuals = partida.getNombreTirades();
		if (tiradesActuals > this.tiradesMaximes) {
			return 0;
		}
		int multiplicador = 10000;
		double percent = (double)(this.tiradesMaximes - tiradesActuals)/this.tiradesMaximes;
		return (int)(percent * multiplicador);
	}

	@Override
	public void setMaxim(Integer files, Integer columnes, Integer mines) {
		Double x = 0.3;
		Double y = -0.93;
		Double mida = (Double)(double)files*columnes;
		Double factor = (mida/mines)*x+y;
		this.tiradesMaximes = (int) Math.round((mida-mines)*factor); 		
	}
	
}
