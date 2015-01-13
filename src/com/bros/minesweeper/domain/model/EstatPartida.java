package com.bros.minesweeper.domain.model;

import java.util.ArrayList;

import com.bros.minesweeper.utils.Pair;

/**
 * Aquesta classe representa una tupla amb la informacio
 * d'una partida despres de realitzar un moviment.
 *
 */
public class EstatPartida {
	public Boolean guanyada;
	public Boolean acabada;
	public Integer puntuacio;
	public ArrayList<Pair<Integer, Integer> > casellesPerDescobrir;
}