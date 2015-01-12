package com.bros.minesweeper.domain.model;


public class EstrategiaPerTirades implements EstrategiaPuntuacio{
	private Integer tiradesMaximes;
	
	public EstrategiaPerTirades(Integer tiradesMaximes) {
		super();
		this.tiradesMaximes = tiradesMaximes;
	}

	@Override
	public Integer getPuntuacio(Partida partida) {
		Integer tiradesActuals = partida.getNombreTirades();
		if (tiradesActuals > this.tiradesMaximes) {
			return 0;
		}
		return this.tiradesMaximes - tiradesActuals;
	}
	
}
