package com.bros.minesweeper.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bros.minesweeper.datainterface.ICtrlPartida;
import com.bros.minesweeper.domain.model.Nivell;
import com.bros.minesweeper.domain.model.Partida;

public class CtrlPartida implements ICtrlPartida{

    private static String tableName = "Partida";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
    
	@Override
	public Partida get(Integer idPartida) {
		// TODO Auto-generated method stub
		try {
			ConnexioDB.createConnection();
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM " + tableName +" WHERE idPartida =" + idPartida);
            
            //TODO FALTA ACABAR
            
            result.close();
            stmt.close();
            conn.close();
    		return null;
		}
        catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}

}
