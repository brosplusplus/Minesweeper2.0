package com.bros.minesweeper.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.bros.minesweeper.datainterface.ICtrlNivell;
import com.bros.minesweeper.domain.model.Nivell;

/**
 * Accedim a la informacio dels nivells que conte la base de dades
 * 
 * @author Alejandro Martinez
 *
 */
public class CtrlNivell implements ICtrlNivell{
	
	public ArrayList<Nivell> getAll() throws SQLException {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		List<Nivell> nivells = session.createCriteria(Nivell.class).list();
		return (ArrayList<Nivell>) nivells;
	}
	
	public Nivell get(String nomNivell) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		Nivell nivell = (Nivell)session.get(Nivell.class,nomNivell);
		session.close();
		
		return nivell;
	}

	@Override
	public String save(Nivell nivell) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		session.beginTransaction();
		String id = (String)session.save(nivell);
		session.save(nivell);
		session.getTransaction().commit();
		session.close();
		
		return id;
	} 
    
}
