package com.bros.minesweeper.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bros.minesweeper.datainterface.ICtrlNivell;
import com.bros.minesweeper.domain.model.Nivell;

/**
 * Accedim a la informacio dels nivells que conte la base de dades
 * 
 * @author Alejandro Martinez
 *
 */
public class CtrlNivell implements ICtrlNivell{
	
    private static String tableName = "Nivell";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
    
	public ArrayList<Nivell> getAll() throws SQLException {
		// TODO Auto-generated method stub
		try {
			ConnexioDB.createConnection();
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM " + tableName);
            ArrayList<Nivell> nivells = new ArrayList<Nivell>();
            while(results.next()){
            	Nivell n = new Nivell();
            	n.setNom(results.getString("nom"));
            	n.setNombreCasellesxFila(results.getInt("nombreCasellesxFila"));
            	n.setNombreCasellesxColumna(results.getInt("nombreCasellesxColumna"));
            	n.setNombreMines(results.getInt("nombreMines"));
            	nivells.add(n);
            }
            results.close();
            stmt.close();
            conn.close();
    		return nivells;
		}
        catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}

	public Nivell get(String nomNivell) {
		// TODO Auto-generated method stub
		try {
			ConnexioDB.createConnection();
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM " + tableName +" WHERE nom =" + nomNivell);

            Nivell n = new Nivell();
        	n.setNom(result.getString("nom"));
        	n.setNombreCasellesxFila(result.getInt("nombreCasellesxFila"));
        	n.setNombreCasellesxColumna(result.getInt("nombreCasellesxColumna"));
        	n.setNombreMines(result.getInt("nombreMines"));

            result.close();
            stmt.close();
            conn.close();
    		return n;
		}
        catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	} 
    
}
