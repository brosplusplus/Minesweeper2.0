/**
 * 
 */
package com.bros.minesweeper.db;

import org.hibernate.Session;

import com.bros.minesweeper.datainterface.ICtrlCasella;
import com.bros.minesweeper.domain.model.Casella;

/**
 * Controlador de la persistencia de la clase Casella
 * @author Borja Arias
 */
public class CtrlCasella implements ICtrlCasella{
	
	/**
	 * Obtenim la casella (numF, numC) de la partida idPartida.
	 */
	@Override
	public Casella get(Integer idPartida, Integer numF, Integer numC) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		String iden = "null:"+numF+":"+numC;

		Casella lcas = (Casella)session.get(Casella.class,iden);
		
		session.close();
		return lcas;
	}

	/**
	 * Guardem la Casella casella a la base de dades.
	 */
	@Override
	public String save(Casella casella) {
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		session.beginTransaction();
		String id = (String)session.save(casella);
		session.getTransaction().commit();
		session.close();
		
		return id;
	}

	@Override
	public void update(Casella casella) {
		// TODO Auto-generated method stub
		Session session = PersistenceSessionFactory.getInstance().openSession();
		
		session.beginTransaction();
		session.update(casella);
		
		session.close();
	}
}
