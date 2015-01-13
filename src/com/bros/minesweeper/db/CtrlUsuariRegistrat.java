package com.bros.minesweeper.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bros.minesweeper.datainterface.ICtrlUsuariRegistrat;
import com.bros.minesweeper.domain.model.UsuariRegistrat;

public class CtrlUsuariRegistrat implements ICtrlUsuariRegistrat {

	private static String tableName = "USUARIREGISTRAT";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
	
	public UsuariRegistrat get(String username) {
		try {
			ConnexioDB.createConnection();
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM " + tableName +" WHERE nom =" + username);

            // TODO revisar aquesta creadora.
            UsuariRegistrat ur = new UsuariRegistrat() {};
        	ur.setNom(result.getString("nom"));
        	ur.setCognom(result.getString("cognom"));
        	ur.setPwd(result.getString("pwd"));
        	ur.setUsername(result.getString("username"));
        	
            result.close();
            stmt.close();
            conn.close();
    		return ur;
		}
        catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}

}