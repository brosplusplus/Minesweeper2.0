package com.bros.minesweeper.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexioDB {
	
	private static String dbURL = "jdbc:derby://localhost:1527/HibernateDB;create=true";
    private static Connection conn = null;
	
    public static void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
