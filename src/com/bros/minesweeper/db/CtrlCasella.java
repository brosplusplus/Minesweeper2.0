/**
 * 
 */
package com.bros.minesweeper.db;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.bros.minesweeper.datainterface.ICtrlCasella;
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
			Session session = PersistenceSessionFactory.getInstance().openSession();
			
			String iden = idPartida+":"+numF+":"+numC;
			Casella lcas = (Casella)session.get(Casella.class,iden);
			session.close();
			return null;
		}
		catch (Exception e) {
            e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main (String[] args) {
		Configuration conf = new Configuration().configure("hibernate.cfg.xml");
		new SchemaExport(conf).create(true,true);
		
//		CtrlCasella ctrlcas = new CtrlCasella();
//		Casella cas = ctrlcas.get(1, 1, 2);
//		System.out.println(cas.getNumero());
	}
}
