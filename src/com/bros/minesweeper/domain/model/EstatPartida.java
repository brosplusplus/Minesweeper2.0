package com.bros.minesweeper.domain.model;

import java.util.ArrayList;

import com.bros.minesweeper.utils.Pair;

public class EstatPartida {
	public Boolean guanyada;
	public Boolean acabada;
	public Integer puntuacio;
	public ArrayList<Pair<Integer, Integer> > casellesPerDescobrir;
}