package com.bros.minesweeper.datainterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bros.minesweeper.db.ConnexioDB;

public class CtrlJugador {

	private static String tableName = "Jugador";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
	
	public boolean exists(String userN) {
		try {
			ConnexioDB.createConnection();
	        stmt = conn.createStatement();
	        ResultSet result = stmt.executeQuery("SELECT * FROM " + 
	        		tableName + " WHERE username = " + userN);
	        return result != null;
		}
		catch (Exception e) {
            e.printStackTrace();
		}

		return false;
	}

}
