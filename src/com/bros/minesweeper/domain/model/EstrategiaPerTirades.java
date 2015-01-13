package com.bros.minesweeper.domain.model;


public class EstrategiaPerTirades implements EstrategiaPuntuacio{
	private Integer tiradesMaximes;
	
	public EstrategiaPerTirades(Integer tiradesMaximes) {
		super();
		this.tiradesMaximes = tiradesMaximes;
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
		return this.tiradesMaximes - tiradesActuals;
	}
	
}
