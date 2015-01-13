/**
 * 
 */
package com.bros.minesweeper.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.bros.minesweeper.datainterface.ICtrlCasella;
import com.bros.minesweeper.domain.model.Administrador;
import com.bros.minesweeper.domain.model.Casella;

/**
 * Controlador de la persistencia de la clase Casella
 * @author Borja Arias
 */
public class CtrlCasella implements ICtrlCasella{
	
	private static String tableName = "Casella";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
	
	@Override
	public Casella get(Integer idPartida, Integer numF, Integer numC) {
		try {
			//ConnexioDB.createConnection();
			AnnotationConfiguration conf = new AnnotationConfiguration();
			conf.configure("hibernate.cfg.xml");
			SessionFactory sessionfact = conf.buildSessionFactory();
			Session session = sessionfact.getCurrentSession();
			Casella cas = (Casella)session.createSQLQuery("select * from test.Casella c "
					+ "where  c.idPartida = "+idPartida
					+ "       c.numeroFila = "+numF
					+ "       c.numeroColumna = "+numC)
					.addEntity("com.bros.minesweeper.domain.model.Casella")
					.uniqueResult();
			return cas;
		}
		catch (Exception e) {
            e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main (String[] args) {
		
	}
}
