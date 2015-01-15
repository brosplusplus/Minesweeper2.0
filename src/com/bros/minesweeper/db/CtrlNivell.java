package com.bros.minesweeper.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.bros.minesweeper.datainterface.ICtrlNivell;
import com.bros.minesweeper.domain.model.Nivell;

/**
 * Controlador de la persistencia de la clase Nivell
 * @author Alejandro Martinez
 *
 */
public class CtrlNivell implements ICtrlNivell{
	
	/**
	 * Obtenim tots els nivells disponibles a la base de dades.
	 */
	public ArrayList<Nivell> getAll() throws SQLException {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		List<Nivell> nivells = session.createCriteria(Nivell.class).list();
		return (ArrayList<Nivell>) nivells;
	}
	
	/**
	 * Obtenim el nivell amb nom nomNivell de la base de dades
	 */
	public Nivell get(String nomNivell) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		Nivell nivell = (Nivell)session.get(Nivell.class,nomNivell);
		session.close();
		
		return nivell;
	}

	/**
	 * Guardem el Nivell nivell a la base de dades.
	 */
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
