package com.bros.minesweeper.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bros.minesweeper.datainterface.ICtrlJugador;
import com.bros.minesweeper.domain.model.Jugador;
import com.bros.minesweeper.domain.model.Nivell;

public class CtrlJugador implements ICtrlJugador {

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

	@Override
	public Jugador get(String username) {
		try {
			ConnexioDB.createConnection();
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM " + tableName +
            		" WHERE nom =" + username);

            Jugador j = new Jugador();
        	j.setNom(result.getString("nom"));
        	j.setCognom(result.getString("cognom"));
        	j.setEmail(result.getString("email"));
        	j.setPwd(result.getString("pwd"));
        	j.setUsername(username);

            result.close();
            stmt.close();
            conn.close();
    		return j;
		}
        catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	} 
}

