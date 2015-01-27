package com.bros.minesweeper.exceptions;

public class NoHiHaNivells extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String msg = "No hi ha nivells al sistema";
	
	@Override
	public String getMessage() {
		return msg;
	}
}
