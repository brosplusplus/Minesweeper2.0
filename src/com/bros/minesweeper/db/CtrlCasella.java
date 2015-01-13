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
import com.bros.minesweeper.utils.debug;

/**
 * Controlador de la persistencia de la clase Casella
 * @author Borja Arias
 */
public class CtrlCasella implements ICtrlCasella{
	
	@Override
	public Casella get(Integer idPartida, Integer numF, Integer numC) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		String iden = "null:"+numF+":"+numC;

		Casella lcas = (Casella)session.get(Casella.class,iden);
		
		session.close();
		return lcas;
	}

	@Override
	public String save(Casella casella) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		session.beginTransaction();
		String id = (String)session.save(casella);
		session.getTransaction().commit();
		session.close();
		
		return id;
	}
}
